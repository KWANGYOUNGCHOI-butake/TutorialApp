package com.kwang0.tutorialapp.network.repository;

import android.net.Uri;

import com.kwang0.tutorialapp.network.entities.Weather;

// WeatherRepository.java
public interface WeatherRepository {
    // URL Const Vals
    String SCHEME = "http";
    String AUTHORITY = "weather.livedoor.com";
    String PATH = "/forecast/webservice/json/v1";
    // URI
    Uri uri = new Uri.Builder()
            .scheme(SCHEME)
            .authority(AUTHORITY)
            .path(PATH)
            .appendQueryParameter("city", "130010")
            .build();

    void getWeather(RequestCallback callback);

    interface RequestCallback {
        // 생성시의 Callback
        void success(Weather weather);

        // 실패시의 Callback
        void error(Throwable throwable);
    }

}