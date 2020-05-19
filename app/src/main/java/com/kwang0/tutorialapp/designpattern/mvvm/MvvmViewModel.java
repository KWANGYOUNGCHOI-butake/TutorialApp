package com.kwang0.tutorialapp.designpattern.mvvm;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.kwang0.tutorialapp.BR;
import com.kwang0.tutorialapp.R;
import com.kwang0.tutorialapp.async.asynctask.AsyncTaskActivity;
import com.kwang0.tutorialapp.databinding.ActivityMvvmBinding;
import com.kwang0.tutorialapp.designpattern.DPModel;
import com.kwang0.tutorialapp.designpattern.mvp.MvpView;

import kotlin.jvm.JvmStatic;

@SuppressLint("ClickableViewAccessibility")
public class MvvmViewModel extends BaseObservable implements ViewModel {
    public static final String TAG = MvvmViewModel.class.getSimpleName();

    @Bindable
    public DPModel model = null;

    public int centerX = 0, centerY = 0;

    @Bindable
    public SquareParams squareParams = null;

    public MvvmViewModel() {
        this.model = new DPModel();
        this.squareParams = new SquareParams(-1, -1, -1, -1);
    }

    // Here we implement delegate methods for the standard Android Activity Lifecycle.
    // These methods are defined in the Presenter interface that we are implementing.
    public void onCreate() { }
    public void onPause() { }
    public void onResume() { }
    public void onDestroy() { }

    @Override
    public void start(View view) {
        setParams(view);
        getCenter();
        model.start();
        setOnTouchListener(moveTouchListener);
        notifyPropertyChanged(BR.model);
    }
    @Override
    public void stop() {
        model.stop();
        setOnTouchListener(emptyTouchListener);
        notifyPropertyChanged(BR.model);
    }
    @Override
    public void reset() {
        if(!model.isFinished()) {
            moveCenter(centerX, centerY);
            model.reset();
            setOnTouchListener(emptyTouchListener);
            notifyPropertyChanged(BR.model);
        }
    }

    private void setParams(View view) {
        if(squareParams.getX() == -1 && squareParams.getY() == -1) {
            squareParams.setX((int) view.getX());
            squareParams.setY((int) view.getY());
            squareParams.setW(view.getWidth());
            squareParams.setH(view.getHeight());
            notifyPropertyChanged(BR.squareParams);

            model.setX(squareParams.getX());
            model.setY(squareParams.getY());
        }
    }

    private void getCenter() {
        centerX = (int) squareParams.getX();
        centerY = (int) squareParams.getY();
    }

    private void moveCenter(int centerX, int centerY) {
        model.move(centerX, centerY);
        notifyPropertyChanged(BR.model);
    }

    @Bindable
    public View.OnTouchListener onTouchListener;
    private View.OnTouchListener emptyTouchListener = null;
    private View.OnTouchListener moveTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if((event.getX() >= 0 &&
                    event.getX() <= v.getWidth() - squareParams.getW())
                    && (event.getY() >= 0 &&
                    event.getY() <= v.getHeight() - squareParams.getH())) {
                if(model.isPlaying()) {
                    model.move((int) event.getX(), (int) event.getY());
                }
                notifyPropertyChanged(BR.model);
                return true;
            }
            return true;
        }
    };
    private void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.onTouchListener = onTouchListener;
        notifyPropertyChanged(BR.onTouchListener);
    }
}
