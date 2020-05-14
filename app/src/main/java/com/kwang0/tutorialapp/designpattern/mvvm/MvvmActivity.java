package com.kwang0.tutorialapp.designpattern.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.kwang0.tutorialapp.R;
import com.kwang0.tutorialapp.databinding.ActivityMvvmBinding;

import kotlin.jvm.JvmStatic;

public class MvvmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvvmBinding mBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        mBinding.setViewModel(new MvvmViewModel());
        mBinding.executePendingBindings();
    }

}
