package com.kwang0.tutorialapp.network.repository;

import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;
import com.kwang0.tutorialapp.network.entity.User;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class UserRepositoryOkHttp3 implements UserRepository {
    public static final String TAG = UserRepositoryOkHttp3.class.getSimpleName();

    private Handler handler = new Handler();

    @Override
    public void getUser(final RequestCallback callback) {
        final Request request = new Request.Builder()
                .url(uri.toString())
                .get()
                .build();
        final OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String responseBody = response.body().string();
                Log.d(TAG, "result: " + responseBody);
                final User user = new Gson().fromJson(responseBody, User.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(user);
                    }
                });
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.error(e);
                    }
                });
            }
        });
    }
}