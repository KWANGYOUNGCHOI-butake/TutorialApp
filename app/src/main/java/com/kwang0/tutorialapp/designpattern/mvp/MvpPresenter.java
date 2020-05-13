package com.kwang0.tutorialapp.designpattern.mvp;

import com.kwang0.tutorialapp.designpattern.DPModel;

public class MvpPresenter implements Presenter {

    private MvpView view;
    private DPModel model;

    public MvpPresenter(MvpView view, DPModel model) {
        this.view = view;
        this.model = model;
    }
}
