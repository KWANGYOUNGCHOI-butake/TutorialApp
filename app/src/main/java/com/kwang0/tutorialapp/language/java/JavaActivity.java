package com.kwang0.tutorialapp.language.java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.kwang0.tutorialapp.R;

public class JavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        TextView tv = (TextView) findViewById(R.id.java_tv);

        StringBuilder sb = new StringBuilder();
        sb.append("Hi, Java!").append("\n");

        tv.setText(sb.toString());
    }
}
