package com.kwang0.tutorialapp;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TitleView {

    private Context mContext;
    private RecyclerView rv;

    private List<TitleModel> mList;
    private TitleAdapter mAdapter;

    public TitleView(Context mContext) {
        this.mContext = mContext;
    }

    public void bindView(Activity a) {
        rv = (RecyclerView) a.findViewById(R.id.reuse_rv);
    }
    public void bindView(View v) {
        rv = (RecyclerView) v.findViewById(R.id.reuse_rv);
    }

    public void recyclerInit() {
        mList = new ArrayList<TitleModel>();
        mAdapter = new TitleAdapter(mContext, mList);
        rv.setHasFixedSize(true);
        ((SimpleItemAnimator) Objects.requireNonNull(rv.getItemAnimator())).setSupportsChangeAnimations(false);
        rv.setNestedScrollingEnabled(false);
        rv.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false));
        rv.setAdapter(mAdapter);
    }

    public List<TitleModel> getmList() {
        return mList;
    }

    public void setmList(List<TitleModel> mList) {
        this.mList = mList;
    }

    public TitleAdapter getmAdapter() {
        return mAdapter;
    }

    public void setmAdapter(TitleAdapter mAdapter) {
        this.mAdapter = mAdapter;
    }
}
