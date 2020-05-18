package com.kwang0.tutorialapp.network.okHttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.kwang0.tutorialapp.R;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.kwang0.tutorialapp.network.NetworkActivity.POST_URL;

public class OkHttpActivity extends AppCompatActivity {

//    private OkHttpClient client = new OkHttpClient();

    private TextView tv;

    public String postUrl= POST_URL;
    public String postBody="{\n" +
            "    \"name\": \"morpheus\",\n" +
            "    \"job\": \"leader\"\n" +
            "}";

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);

        tv = (TextView) findViewById(R.id.reuse_scroll_tv);

        OkHttpHandler okHttpHandler= new OkHttpHandler();
        okHttpHandler.execute(postUrl);
    }

    public class OkHttpHandler extends AsyncTask<String, Void, String> {

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, postBody);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String...params) {

            Request request = new Request.Builder()
                    .url(postUrl)
                    .post(body)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                if(response.body() != null) return response.body().string();
            }catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tv.setText(s);
        }
    }
}
