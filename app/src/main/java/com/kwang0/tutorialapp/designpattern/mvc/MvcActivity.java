package com.kwang0.tutorialapp.designpattern.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kwang0.tutorialapp.R;
import com.kwang0.tutorialapp.async.asynctask.AsyncTaskActivity;
import com.kwang0.tutorialapp.designpattern.DPModel;

@SuppressLint("ClickableViewAccessibility")
public class MvcActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    public static final String TAG = MvcActivity.class.getSimpleName();

    private DPModel model;

    private TextView tv;
    private Button start, stop, reset;
    private RelativeLayout view;
    private View square_view;

    private int centerX, centerY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);

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

        model = new DPModel();

        startVISIBLE();
        setXYTextInit();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.d_p_linear_start:
                start();
                break;

            case R.id.d_p_linear_stop:
                stop();
                break;

            case R.id.d_p_linear_reset:
                reset();
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
                        event.getY() <= view.getHeight() - square_view.getHeight())
                    && model.isPlaying()) {
                move(event);
                return true;
            }
        }
        return true;
    }

    private void start() {
        getCenter();
        model.start();
        stopVISIBLE();
    }
    private void stop() {
        model.stop();
        startVISIBLE();
    }
    private void reset() {
        if(!model.isFinished()) {
            moveCenter();
            setXYTextInit();
            model.reset();
            startVISIBLE();
        }
    }
    private void move(MotionEvent event) {
        model.move((int) event.getX(), (int) event.getY());
        moveSquare();
        setXYText(model.getX(), model.getY());
    }
    private void moveCenter() {
        model.move(centerX, centerY);

        Log.d("work??", "x : " + centerX);
        Log.d("work??", "y : " + centerY);
        moveSquare();
    }

    private void moveSquare() {
        square_view.setX((float) model.getX());
        square_view.setY((float) model.getY());
    }

    private void getCenter() {
        centerX = (int) square_view.getX();
        centerY = (int) square_view.getY();
    }

    @SuppressLint("SetTextI18n")
    private void setXYTextInit() {
        tv.setText("START를 눌러주세요");
    }
    @SuppressLint("SetTextI18n")
    private void setXYText(int x, int y) {
        tv.setText("X : " + x + ", Y : " + y);
    }

    private void startVISIBLE() {
        start.setVisibility(View.VISIBLE);
        stop.setVisibility(View.GONE);
    }
    private void stopVISIBLE() {
        start.setVisibility(View.GONE);
        stop.setVisibility(View.VISIBLE);
    }
}
