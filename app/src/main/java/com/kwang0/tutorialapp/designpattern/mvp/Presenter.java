package com.kwang0.tutorialapp.designpattern.mvp;

import android.view.MotionEvent;

public interface Presenter {
    void start();
    void stop();
    void reset(int centerX, int centerY);
    void move(int x, int y);
    void moveCenter(int centerX, int centerY);
    void moveSquare();
}
