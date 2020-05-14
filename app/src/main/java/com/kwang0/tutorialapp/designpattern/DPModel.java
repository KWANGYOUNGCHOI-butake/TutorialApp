package com.kwang0.tutorialapp.designpattern;

public class DPModel {
    private int x, y;
    private boolean isPlaying;
    private boolean isFinished;

    public DPModel() {
        isPlaying = false;
        isFinished = true;
    }

    public void start() {
        isPlaying = true;
        isFinished = false;
    }
    public void stop() {
        isPlaying = false;
        isFinished = false;
    }
    public void reset() {
        isPlaying = false;
        isFinished = true;
    }
    public void move(int x, int y) {
        if(!isFinished) {
            this.x = x;
            this.y = y;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}
