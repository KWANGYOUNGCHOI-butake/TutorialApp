package com.kwang0.tutorialapp.network.repository;

import android.content.Context;

import androidx.annotation.Nullable;

import java.util.HashMap;

/**
 * Provider for repository
 */
public class RepositoryProvider {

    private static HashMap<Client, UserRepository> repositories;

    public static void initialize(Context context) {
        repositories = new HashMap<>();
        for (Client client : Client.values()) {
            repositories.put(client, client.createClient(context));
        }
    }

    @Nullable
    public static UserRepository provideWeatherRepository(Client client) {
        return repositories.get(client);
    }

    // Network Libraries
    public enum Client {
        Volley {
            @Override
            public UserRepository createClient(Context context) {
                return new UserRepositoryVolley(context);
            }
        },
        OkHttp3 {
            @Override
            public UserRepository createClient(Context context) {
                return new UserRepositoryOkHttp3();
            }
        },
        Retrofit2 {
            @Override
            public UserRepository createClient(Context context) {
                return new UserRepositoryRetrofit2();
            }
        },
        ;

        public abstract UserRepository createClient(Context context);
    }


}