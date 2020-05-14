package com.kwang0.tutorialapp.designpattern.mvp;

public interface MvpView {
    void getCenter();
    void setPosition(int x, int y);
    void setXYTextInit();
    void setXYText(int x, int y);
    void startVISIBLE();
    void stopVISIBLE();
}
