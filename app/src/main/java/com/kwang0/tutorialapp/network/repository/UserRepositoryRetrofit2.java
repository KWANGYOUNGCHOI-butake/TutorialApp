package com.kwang0.tutorialapp.network.repository;

import android.net.Uri;
import android.util.Log;

import com.kwang0.tutorialapp.network.entities.User;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class UserRepositoryRetrofit2 implements UserRepository {
    public static final String TAG = UserRepositoryRetrofit2.class.getSimpleName();

    private final WeatherService service;

    public UserRepositoryRetrofit2() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(new Uri.Builder().scheme(SCHEME).authority(AUTHORITY).build().toString())
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(WeatherService.class);
    }

    @Override
    public void getUser(final RequestCallback callback) {
        service.getPage(2).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d(TAG, "result: " + response.body().toString());
                callback.success(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable error) {
                callback.error(error);
            }
        });
    }

    private interface WeatherService {
        @GET(PATH)
        Call<User> getPage(@Query("page") int page);
    }

}