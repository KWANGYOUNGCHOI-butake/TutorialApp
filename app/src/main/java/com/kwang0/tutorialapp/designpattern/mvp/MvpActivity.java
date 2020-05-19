package com.kwang0.tutorialapp.designpattern.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kwang0.tutorialapp.R;
import com.kwang0.tutorialapp.async.asynctask.AsyncTaskActivity;
import com.kwang0.tutorialapp.designpattern.DPModel;

@SuppressLint("ClickableViewAccessibility")
public class MvpActivity extends AppCompatActivity implements MvpView, View.OnClickListener, View.OnTouchListener {
    public static final String TAG = MvpActivity.class.getSimpleName();

    private TextView tv;
    private Button start, stop, reset;
    private RelativeLayout view;
    private View square_view;

    private int centerX, centerY;

    private MvpPresenter mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);

        tv = (TextView) findViewById(R.id.d_p_tv);
        start = (Button) findViewById(R.id.d_p_linear_start);
        stop = (Button) findViewById(R.id.d_p_linear_stop);
        reset = (Button) findViewById(R.id.d_p_linear_reset);
        view = (RelativeLayout) findViewById(R.id.d_p_view);
        square_view = (View) findViewById(R.id.d_p_square_view);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        reset.setOnClickListener(this);
        view.setOnTouchListener(this);

        mvpPresenter = new MvpPresenter(this);
        mvpPresenter.onCreate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mvpPresenter.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        mvpPresenter.onPause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mvpPresenter.onDestroy();
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.d_p_linear_start:
                mvpPresenter.start();
                break;

            case R.id.d_p_linear_stop:
                mvpPresenter.stop();
                break;

            case R.id.d_p_linear_reset:
                mvpPresenter.reset(centerX, centerY);
                break;

            default:
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(v.getId() == R.id.d_p_view) {
            if((event.getX() >= 0 &&
                    event.getX() <= view.getWidth() - square_view.getWidth())
                    && (event.getY() >= 0 &&
                    event.getY() <= view.getHeight() - square_view.getHeight())) {
                mvpPresenter.move((int) event.getX(), (int) event.getY());
                return true;
            }
        }
        return true;
    }

    @Override
    public void getCenter() {
        centerX = (int) square_view.getX();
        centerY = (int) square_view.getY();
    }

    @Override
    public void setPosition(int x, int y) {
        square_view.setX((float) x);
        square_view.setY((float) y);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setXYTextInit() {
        tv.setText("START를 눌러주세요");
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setXYText(int x, int y) {
        tv.setText("X : " + x + ", Y : " + y);
    }

    @Override
    public void startVISIBLE() {
        start.setVisibility(View.VISIBLE);
        stop.setVisibility(View.GONE);
    }

    @Override
    public void stopVISIBLE() {
        start.setVisibility(View.GONE);
        stop.setVisibility(View.VISIBLE);
    }
}
