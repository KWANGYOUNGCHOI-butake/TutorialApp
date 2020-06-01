package com.kwang0.tutorialapp.designpattern.mvvm;

import android.view.View;

public interface ViewModel {
    void start(View view);
    void stop();
    void reset();
}
