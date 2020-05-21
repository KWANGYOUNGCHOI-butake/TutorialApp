package com.kwang0.tutorialapp.database.room;

import com.kwang0.tutorialapp.database.room.persistence.User;

import io.reactivex.Completable;
import io.reactivex.Flowable;

/**
 * user 데이터를 관리하기 위한 접근 포인트
 */
public interface UserDataSource {

    /**
     * data에 source 에서 user 데이터를 가져옴
     *
     * @return User
     */
    Flowable<User> getUser();

    /**
     * data source 에 user 를 집어넣음,
     * 만약 user 가 존재한다면 업데이트 시킴
     *
     * @param user
     */
    Completable insertOrUpdateUser(User user);

    /**
     * data source 의 모든 유저를 지움
     */
    void deleteAllUsers();
}