package com.kwang0.tutorialapp.network.entity;

import org.jetbrains.annotations.NotNull;

public class UserInfo {
    public int id;
    public String email;
    public String first_name;
    public String last_name;
    public String avatar;

    @NotNull
    @Override
    public String toString() {
        return "\n{" +
                "id='" + String.valueOf(id) + '\'' +
                ", email='" + email + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
