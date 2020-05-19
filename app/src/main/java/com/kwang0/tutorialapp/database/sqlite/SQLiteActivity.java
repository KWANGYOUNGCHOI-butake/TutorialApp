package com.kwang0.tutorialapp.database.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.kwang0.tutorialapp.R;
import com.kwang0.tutorialapp.network.repository.UserRepositoryOkHttp3;

public class SQLiteActivity extends AppCompatActivity {
    public static final String TAG = SQLiteActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_q_lite);

        TextView tv = (TextView) findViewById(R.id.reuse_scroll_tv);
    }
}
