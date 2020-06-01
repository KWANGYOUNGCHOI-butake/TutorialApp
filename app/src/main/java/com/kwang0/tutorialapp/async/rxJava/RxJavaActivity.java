package com.kwang0.tutorialapp.async.rxJava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kwang0.tutorialapp.ProgressDialog;
import com.kwang0.tutorialapp.R;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

//ReactiveX Java
public class RxJavaActivity extends AppCompatActivity {
    public static final String TAG = RxJavaActivity.class.getSimpleName();

    Disposable rxDisposable;
    enum RX_OPERATION {
        OBSERVABLE,
        FLOWABLE,
        SINGLE,
        MAYBE,
        COMPLETABLE
    }

    RX_OPERATION currentOperation;

    private Spinner spi;
    private Button btn;
    private TextView tv;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);

        spi = (Spinner) findViewById(R.id.rx_java_spi);
        btn = (Button) findViewById(R.id.rx_java_btn);
        tv = (TextView) findViewById(R.id.reuse_scroll_tv);
        setTVText("Hello RxJava!");

        final ArrayAdapter<RX_OPERATION> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, RX_OPERATION.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi.setAdapter(adapter);

        btn.setOnClickListener( (View v) -> {
            pd = new ProgressDialog(RxJavaActivity.this);
            pd.setText("잠시만 기다려주세요...");
            pd.openProgressDialog();
            try {
                this.currentOperation = (RX_OPERATION) spi.getSelectedItem();
                operateReactiveX(currentOperation);
            } catch (NullPointerException e) {
                Log.d(TAG, "Error -> " + e.getMessage());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        restoreData();
    }

    @Override
    protected void onStop() {
        super.onStop();
        tearDown();
    }

    private void restoreData() {
        if(currentOperation == null) return;
        operateReactiveX(currentOperation);
    }

    private void tearDown() {
        if(rxDisposable != null && !rxDisposable.isDisposed()) rxDisposable.dispose();
    }

    private void operateReactiveX(RX_OPERATION operation) {
        switch (operation) {
            case OBSERVABLE:
                runObservable();
                break;
            case FLOWABLE:
                runFlowable();
                break;
            case SINGLE:
                runSingle();
                break;
            case MAYBE:
                runMaybe();
                break;
            case COMPLETABLE:
                runCompletable();
                break;
        }
    }

    private void runObservable() {
        rxDisposable = Observable.just(true)
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
                    Log.d("rxjava", "observable result : " + result);
                    setTVText("Download OK!!!");
                }, error ->{
                    setTVText("error!!");
                });
    }

    private void runFlowable() {
        rxDisposable = Flowable.just(true)
                .observeOn(Schedulers.computation())
                .subscribeOn(AndroidSchedulers.mainThread())
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
                    Log.d("rxjava", "observable result : " + result);
                    setTVText("Download OK!!!");
                }, error ->{
                    setTVText("error!!");
                });
    }

    private void runSingle() {
        rxDisposable = Single.just(true)
                .observeOn(Schedulers.computation())
                .subscribeOn(AndroidSchedulers.mainThread())
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
                    Log.d("rxjava", "observable result : " + result);
                    setTVText("Download OK!!!");
                }, error ->{
                    setTVText("error!!");
                });
    }

    private void runMaybe() {
        rxDisposable = Maybe.just(true)
                .observeOn(Schedulers.computation())
                .subscribeOn(AndroidSchedulers.mainThread())
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
                    Log.d("rxjava", "observable result : " + result);
                    setTVText("Download OK!!!");
                }, error ->{
                    setTVText("error!!");
                });
    }

    private void runCompletable() {
        rxDisposable = Completable.complete()
                .observeOn(Schedulers.computation())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    for (int i = 0; i < 10; i++) {
                        pd.setText("다운로드 진행중 : " + i * 10);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    pd.dismissProgressDialog();
                    Log.d("rxjava", "completable result : ");
                    setTVText("Download OK!!!");
                }, error ->{
                    setTVText("error!!");
                });
    }

    private void setTVText(String s) {
        if(tv != null && s != null) tv.setText(s);
    }
}
