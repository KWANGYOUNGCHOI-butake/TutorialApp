package com.kwang0.tutorialapp.async.rxJava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.kwang0.tutorialapp.ProgressDialog;
import com.kwang0.tutorialapp.R;
import com.kwang0.tutorialapp.async.asynctask.AsyncTaskActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

//ReactiveX Java
public class RxJavaActivity extends AppCompatActivity {
    public static final String TAG = RxJavaActivity.class.getSimpleName();

    CompositeDisposable compositeDisposable = new CompositeDisposable();
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);

        tv = (TextView) findViewById(R.id.reuse_scroll_tv);
        setTVText("Hello RxJava!");

        ProgressDialog pd = new ProgressDialog(RxJavaActivity.this);
        pd.setText("잠시만 기다려주세요...");
        pd.openProgressDialog();

        Disposable disposable = Observable.just(true)
                .observeOn(Schedulers.computation())
                .subscribeOn(AndroidSchedulers.mainThread())
//                .delay(2, TimeUnit.SECONDS)
                .subscribe(result -> {
                    for (int i = 0; i < 10; i++) {
                        pd.setText("다운로드 진행중 : " + i * 10);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    pd.dismissProgressDialog();
                    Log.d("rxjava", "result : " + result);
                    setTVText("Download OK!!!");
                }, error ->{
                    setTVText("error!!");
                });

        compositeDisposable.add(disposable);
    }

    private void setTVText(String s) {
        if(tv != null && s != null) tv.setText(s);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}
