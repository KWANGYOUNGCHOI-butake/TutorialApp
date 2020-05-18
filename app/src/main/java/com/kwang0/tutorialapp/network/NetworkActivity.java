package com.kwang0.tutorialapp.network;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.kwang0.tutorialapp.R;
import com.kwang0.tutorialapp.TitleAdapter;
import com.kwang0.tutorialapp.TitleModel;
import com.kwang0.tutorialapp.TitleView;
import com.kwang0.tutorialapp.language.LanguageActivity;

import java.util.List;

public class NetworkActivity extends AppCompatActivity {

    private RecyclerView rv;

    private TitleView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        titleView = new TitleView(NetworkActivity.this);
        titleView.bindView(NetworkActivity.this);
        titleView.recyclerInit();

        List<TitleModel> mList = titleView.getmList();
        TitleAdapter mAdapter = titleView.getmAdapter();

        mList.add(new TitleModel("OkHttp"));
        mList.add(new TitleModel("Volley"));
        mList.add(new TitleModel("Retrofit"));
        mAdapter.notifyDataSetChanged();
    }
}
