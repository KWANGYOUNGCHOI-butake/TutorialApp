package com.kwang0.tutorialapp.network.entities;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class User {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public List<UserInfo> data;

    public User() {
    }

    public User(int page, int per_page, int total, int total_pages, List<UserInfo> data) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
    }

    @NotNull
    @Override
    public String toString() {
        return "\nUser \n[" +
                "\npage='" + String.valueOf(page) + '\'' +
                "\nper_page='" + String.valueOf(per_page) + '\'' +
                "\ntotal='" + String.valueOf(total) + '\'' +
                "\ntotal_pages='" + String.valueOf(total_pages) + '\'' +
                "\nuser=" + data +
                "\n]";
    }
}