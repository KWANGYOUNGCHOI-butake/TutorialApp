package com.kwang0.tutorialapp.network.entities;

public class Description {
    public String text;
    public String publicTime;

    @Override
    public String toString() {
        return "Description{" +
                "publicTime='" + publicTime + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}