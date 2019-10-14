package com.example.bookcatalogservice.models;
import java.util.List;

public class UserReaded {
    private List<Readed> userReaded;

    public List<Readed> getUserReaded() {
        return userReaded;
    }

    public void setUserReaded(List<Readed> userReaded) {
        this.userReaded = userReaded;
    }
}
