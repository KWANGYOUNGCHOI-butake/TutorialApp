package com.kwang0.tutorialapp.async;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.kwang0.tutorialapp.R;
import com.kwang0.tutorialapp.TitleAdapter;
import com.kwang0.tutorialapp.TitleModel;
import com.kwang0.tutorialapp.TitleView;
import com.kwang0.tutorialapp.designpattern.DPActivity;

import java.util.List;

public class AsyncActivity extends AppCompatActivity {

    private RecyclerView rv;

    private TitleView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        titleView = new TitleView(AsyncActivity.this);
        titleView.bindView(AsyncActivity.this);
        titleView.recyclerInit();

        List<TitleModel> mList = titleView.getmList();
        TitleAdapter mAdapter = titleView.getmAdapter();

        mList.add(new TitleModel("AsyncTask"));
        mList.add(new TitleModel("RxJava"));
        mList.add(new TitleModel("Coroutines"));
        mAdapter.notifyDataSetChanged();
    }
}
