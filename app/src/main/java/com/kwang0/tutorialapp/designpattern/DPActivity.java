package com.kwang0.tutorialapp.designpattern;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.os.Bundle;

import com.kwang0.tutorialapp.MainActivity;
import com.kwang0.tutorialapp.MainRVAdapter;
import com.kwang0.tutorialapp.MainRVContents;
import com.kwang0.tutorialapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DPActivity extends AppCompatActivity {

    private RecyclerView rv;

    private List<DPContents> mList;
    private DPAdapter mAdapter;

    private void dpActContentsInit() {
        rv = (RecyclerView) findViewById(R.id.d_p_rv);
    }

    private void dpActProcessInit() {
        mList = new ArrayList<>();
        mAdapter = new DPAdapter(DPActivity.this, mList);
        rv.setHasFixedSize(true);
        ((SimpleItemAnimator) Objects.requireNonNull(rv.getItemAnimator())).setSupportsChangeAnimations(false);
        rv.setNestedScrollingEnabled(false);
        rv.setLayoutManager(new LinearLayoutManager(DPActivity.this, RecyclerView.VERTICAL, false));
        rv.setAdapter(mAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_p);

        dpActContentsInit();
        dpActProcessInit();

        mList.add(new DPContents("MVC"));
        mList.add(new DPContents("MVP"));
        mList.add(new DPContents("MVVM"));
        mAdapter.notifyDataSetChanged();
    }
}
