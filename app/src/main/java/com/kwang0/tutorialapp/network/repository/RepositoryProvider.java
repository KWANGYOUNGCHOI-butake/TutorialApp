package com.kwang0.tutorialapp.network.repository;

import android.content.Context;

import androidx.annotation.Nullable;

import java.util.HashMap;

/**
 * Provider for repository
 */
public class RepositoryProvider {

    private static HashMap<Client, WeatherRepository> repositories;

    public static void initialize(Context context) {
        repositories = new HashMap<>();
        for (Client client : Client.values()) {
            repositories.put(client, client.createClient(context));
        }
    }

    @Nullable
    public static WeatherRepository provideWeatherRepository(Client client) {
        return repositories.get(client);
    }

    // Network Libraries
    public enum Client {
        Volley {
            @Override
            public WeatherRepository createClient(Context context) {
                return new WeatherRepositoryVolley(context);
            }
        },
        OkHttp3 {
            @Override
            public WeatherRepository createClient(Context context) {
                return new WeatherRepositoryOkHttp3();
            }
        },
        Retrofit2 {
            @Override
            public WeatherRepository createClient(Context context) {
                return new WeatherRepositoryRetrofit2();
            }
        },
        ;

        public abstract WeatherRepository createClient(Context context);

        @Override
        public String toString() {
            return name();
        }
    }


}