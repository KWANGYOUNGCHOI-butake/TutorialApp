package com.kwang0.tutorialapp.network.repository;

import android.net.Uri;

import com.kwang0.tutorialapp.network.entity.User;


// WeatherRepository.java
public interface UserRepository {
    // URL Const Vals
    String SCHEME = "https";
    String AUTHORITY = "reqres.in";
    String PATH = "/api/users";
    // URI
    Uri uri = new Uri.Builder()
            .scheme(SCHEME)
            .authority(AUTHORITY)
            .path(PATH)
            .appendQueryParameter("page", "2")
            .build();

    void getUser(RequestCallback callback);

    interface RequestCallback {
        // 생성시의 Callback
        void success(User user);

        // 실패시의 Callback
        void error(Throwable throwable);
    }

}