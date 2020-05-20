package com.kwang0.tutorialapp.database.room;

import android.content.Context;

import com.kwang0.tutorialapp.database.room.persistence.LocalUserDataSource;
import com.kwang0.tutorialapp.database.room.persistence.UsersDatabase;
import com.kwang0.tutorialapp.database.room.ui.ViewModelFactory;

/**
 * Enables injection of data sources.
 */
public class Injection {

    public static UserDataSource provideUserDataSource(Context context) {
        UsersDatabase database = UsersDatabase.getInstance(context);
        return new LocalUserDataSource(database.userDao());
    }

    public static ViewModelFactory provideViewModelFactory(Context context) {
        UserDataSource dataSource = provideUserDataSource(context);
        return new ViewModelFactory(dataSource);
    }
}