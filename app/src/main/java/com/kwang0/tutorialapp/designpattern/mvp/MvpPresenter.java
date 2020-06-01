package com.kwang0.tutorialapp.designpattern.mvp;

import android.view.MotionEvent;

import com.kwang0.tutorialapp.async.asynctask.AsyncTaskActivity;
import com.kwang0.tutorialapp.designpattern.DPModel;

public class MvpPresenter implements Presenter {
    public static final String TAG = MvpPresenter.class.getSimpleName();

    private MvpView view;
    private DPModel model;

    MvpPresenter(MvpView view) {
        this.view = view;
        this.model = new DPModel();
    }

    // 라이프 사이클

    public void onCreate() {
        model = new DPModel();
        view.startVISIBLE();
        view.setXYTextInit();
    }
    public void onPause() { }
    public void onResume() { }
    public void onDestroy() { }

    // 사각형 이동 관련 함수

    @Override
    public void start() {
        view.getCenter();
        model.start();
        view.stopVISIBLE();
    }

    @Override
    public void stop() {
        model.stop();
        view.startVISIBLE();
    }

    @Override
    public void reset(int centerX, int centerY) {
        if(!model.isFinished()) {
            moveCenter(centerX, centerY);
            view.setXYTextInit();
            model.reset();
            view.startVISIBLE();
        }
    }
    @Override
    public void move(int x , int y) {
        if(model.isPlaying()) {
            model.move(x, y);
            moveSquare();
            view.setXYText(model.getX(), model.getY());
        }
    }
    @Override
    public void moveCenter(int centerX, int centerY) {
        model.move(centerX, centerY);
        moveSquare();
    }

    @Override
    public void moveSquare() {
        view.setPosition(model.getX(), model.getY());
    }
}
