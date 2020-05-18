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

    private TitleView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleView = new TitleView(MainActivity.this);
        titleView.bindView(MainActivity.this);
        titleView.recyclerInit();

        List<TitleModel> mList = titleView.getmList();
        TitleAdapter mAdapter = titleView.getmAdapter();

        mList.add(new TitleModel("디자인 패턴"));
        mList.add(new TitleModel("언어"));
        mList.add(new TitleModel("자바8"));
        mList.add(new TitleModel("비동기처리"));
        mList.add(new TitleModel("네트워크"));
        mAdapter.notifyDataSetChanged();
    }

}
