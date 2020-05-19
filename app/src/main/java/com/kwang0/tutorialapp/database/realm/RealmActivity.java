package com.kwang0.tutorialapp.database.realm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.kwang0.tutorialapp.R;
import com.kwang0.tutorialapp.database.sqlite.SQLiteActivity;

public class RealmActivity extends AppCompatActivity {
    public static final String TAG = RealmActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);

        TextView tv = (TextView) findViewById(R.id.reuse_scroll_tv);
    }
}
