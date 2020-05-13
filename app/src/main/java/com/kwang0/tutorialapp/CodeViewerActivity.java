package com.kwang0.tutorialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CodeViewerActivity extends AppCompatActivity {
    private TextView tv;

    private void codeViewerContentsInit() {
        tv = (TextView) findViewById(R.id.code_viewer_tv);
    }

    private void codeViewerActProcessInit() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_viewer);

        codeViewerContentsInit();
        codeViewerActProcessInit();
    }
}
