package com.kwang0.tutorialapp.language;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.os.Bundle;

import com.kwang0.tutorialapp.MainActivity;
import com.kwang0.tutorialapp.R;
import com.kwang0.tutorialapp.TitleAdapter;
import com.kwang0.tutorialapp.TitleModel;
import com.kwang0.tutorialapp.TitleView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LanguageActivity extends AppCompatActivity {

    private RecyclerView rv;

    private TitleView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        titleView = new TitleView(LanguageActivity.this);
        titleView.bindView(LanguageActivity.this);
        titleView.recyclerInit();

        List<TitleModel> mList = titleView.getmList();
        TitleAdapter mAdapter = titleView.getmAdapter();

        mList.add(new TitleModel("자바"));
        mList.add(new TitleModel("코틀린"));
        mAdapter.notifyDataSetChanged();
    }
}
