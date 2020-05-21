package com.kwang0.tutorialapp.database.room.persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Singleton
 * Users 테이블을 포함한 room 데이터베이스
 */
@Database(entities = {User.class}, version = 1)
public abstract class UsersDatabase extends RoomDatabase {

    // 멀티 쓰레드 환경에서 발생하는 문제를 해결하기 위해
    // volatile 을 사용해서 변수의 read와 write를 Main Memory에서 진행
    private static volatile UsersDatabase INSTANCE;

    public abstract UserDao userDao();

    public static UsersDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (UsersDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UsersDatabase.class, "Sample.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}