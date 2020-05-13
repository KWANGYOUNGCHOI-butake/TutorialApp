package com.kwang0.tutorialapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;

    private List<MainRVContents> mList;
    private MainRVAdapter mAdapter;

    private void mainActContentsInit() {
        rv = (RecyclerView) findViewById(R.id.main_recycler);
    }

    private void mainProcessInit() {
        mList = new ArrayList<MainRVContents>();
        mAdapter = new MainRVAdapter(MainActivity.this, mList);
        rv.setHasFixedSize(true);
        ((SimpleItemAnimator) Objects.requireNonNull(rv.getItemAnimator())).setSupportsChangeAnimations(false);
        rv.setNestedScrollingEnabled(false);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));
        rv.setAdapter(mAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActContentsInit();
        mainProcessInit();

        mList.add(new MainRVContents("디자인 패턴"));
        mList.add(new MainRVContents("언어"));
        mList.add(new MainRVContents("자바8"));
        mList.add(new MainRVContents("비동기처리"));
        mAdapter.notifyDataSetChanged();
    }

}
