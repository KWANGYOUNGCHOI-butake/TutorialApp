package com.kwang0.tutorialapp.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.kwang0.tutorialapp.R;
import com.kwang0.tutorialapp.TitleAdapter;
import com.kwang0.tutorialapp.TitleModel;
import com.kwang0.tutorialapp.TitleView;
import com.kwang0.tutorialapp.async.asynctask.AsyncTaskActivity;
import com.kwang0.tutorialapp.javaE.JavaEActivity;

import java.util.List;

public class DatabaseActivity extends AppCompatActivity {
    public static final String TAG = DatabaseActivity.class.getSimpleName();

    private RecyclerView rv;
    private TitleView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        titleView = new TitleView(DatabaseActivity.this);
        titleView.bindView(DatabaseActivity.this);
        titleView.recyclerInit();

        List<TitleModel> mList = titleView.getmList();
        TitleAdapter mAdapter = titleView.getmAdapter();

        mList.add(new TitleModel("SQLite"));
        mList.add(new TitleModel("Realm"));
        mAdapter.notifyDataSetChanged();
    }
}
