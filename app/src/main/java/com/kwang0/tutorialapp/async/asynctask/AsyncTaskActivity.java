package com.kwang0.tutorialapp.async.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.kwang0.tutorialapp.ProgressDialog;
import com.kwang0.tutorialapp.R;

public class AsyncTaskActivity extends AppCompatActivity implements AsyncTaskInterface {
    public static final String TAG = AsyncTaskActivity.class.getSimpleName();

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        tv = (TextView) findViewById(R.id.reuse_scroll_tv);
        tv.setText("Hello AsyncTask!");

        AsyncDownload asyncDownload = new AsyncDownload();
        asyncDownload.taskInterface = this;
        asyncDownload.execute("");
    }

    @Override
    public void taskFinished(String output) {
        if(tv != null) tv.setText(output);
    }


    private class AsyncDownload extends AsyncTask<String, Void, String> {

        ProgressDialog dialog = new ProgressDialog(AsyncTaskActivity.this);
        AsyncTaskInterface taskInterface = null;

        @Override
        protected void onPreExecute() {
            dialog.setText("잠시만 기다려주세요...");
            dialog.openProgressDialog();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

            for (int i = 0; i < 10; i++) {
                dialog.setText("다운로드 진행중 : " + i * 10);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return "Download OK!!!";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(taskInterface != null) taskInterface.taskFinished(s);
            dialog.dismissProgressDialog();
        }
    }
}
