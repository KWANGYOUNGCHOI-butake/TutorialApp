package com.kwang0.tutorialapp.designpattern;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.os.Bundle;

import com.kwang0.tutorialapp.R;
import com.kwang0.tutorialapp.TitleAdapter;
import com.kwang0.tutorialapp.TitleModel;
import com.kwang0.tutorialapp.TitleView;
import com.kwang0.tutorialapp.async.asynctask.AsyncTaskActivity;
import com.kwang0.tutorialapp.javaE.JavaEActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DPActivity extends AppCompatActivity {
    public static final String TAG = DPActivity.class.getSimpleName();

    private RecyclerView rv;

    private TitleView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_p);

        titleView = new TitleView(DPActivity.this);
        titleView.bindView(DPActivity.this);
        titleView.recyclerInit();

        List<TitleModel> mList = titleView.getmList();
        TitleAdapter mAdapter = titleView.getmAdapter();

        mList.add(new TitleModel("MVC"));
        mList.add(new TitleModel("MVP"));
        mList.add(new TitleModel("MVVM"));
        mAdapter.notifyDataSetChanged();
    }
}
