package com.kwang0.tutorialapp.designpattern.mvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kwang0.tutorialapp.R;
import com.kwang0.tutorialapp.designpattern.DPModel;

public class MvvmActivity extends AppCompatActivity {
    private DPModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);
    }
}
