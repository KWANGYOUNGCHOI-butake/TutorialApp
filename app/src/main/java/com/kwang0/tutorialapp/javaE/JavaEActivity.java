package com.kwang0.tutorialapp.javaE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.kwang0.tutorialapp.R;
import com.kwang0.tutorialapp.TitleAdapter;
import com.kwang0.tutorialapp.TitleModel;
import com.kwang0.tutorialapp.TitleView;
import com.kwang0.tutorialapp.async.asynctask.AsyncTaskActivity;
import com.kwang0.tutorialapp.language.LanguageActivity;

import java.util.List;

public class JavaEActivity extends AppCompatActivity {
    public static final String TAG = JavaEActivity.class.getSimpleName();

    private RecyclerView rv;

    private TitleView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_e);

        titleView = new TitleView(JavaEActivity.this);
        titleView.bindView(JavaEActivity.this);
        titleView.recyclerInit();

        List<TitleModel> mList = titleView.getmList();
        TitleAdapter mAdapter = titleView.getmAdapter();

        mList.add(new TitleModel("Optional"));
        mList.add(new TitleModel("Stream - collect"));
        mList.add(new TitleModel("Stream - reduction"));
        mList.add(new TitleModel("Stream - find, match"));
        mList.add(new TitleModel("Stream - max, min"));
        mList.add(new TitleModel("Stream - sorted"));
        mList.add(new TitleModel("Stream - concat"));
        mList.add(new TitleModel("Stream - distinct"));
        mList.add(new TitleModel("Stream - limit, skip"));
        mList.add(new TitleModel("Stream - filter, map"));
        mAdapter.notifyDataSetChanged();
    }
}
