package com.kwang0.tutorialapp.designpattern.mvvm;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.library.baseAdapters.BR;

import com.kwang0.tutorialapp.designpattern.DPModel;

import kotlin.jvm.JvmStatic;

@SuppressLint("ClickableViewAccessibility")
public class MvvmBindingAdapter {

    @BindingAdapter({"touchListener"})
    public static void setTouchListener(View self, View.OnTouchListener onTouchListener){
        if (onTouchListener != null)
            self.setOnTouchListener(onTouchListener);
    }
    @BindingAdapter("moveSquare")
    public static void setSquareMove(View self, DPModel model) {
        self.setX((int) model.getX());
        self.setY((int) model.getY());
    }
    @SuppressLint("SetTextI18n")
    @BindingAdapter("stringResult")
    public static void getResult(TextView self, DPModel model) {
        if(model.isPlaying()) {
            self.setText("X : " + model.getX() + ", Y : " + model.getY());
        } else {
            self.setText("START를 눌러주세요");
        }
    }
}
