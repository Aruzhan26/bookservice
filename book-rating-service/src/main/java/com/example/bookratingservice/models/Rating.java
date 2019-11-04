package com.example.bookratingservice.models;

public class Rating {
    private String bookId;
    private int rating;
    private String userId;

    public Rating(String s, int i) {
    }

    public Rating(String bookId, int rating,String userId) {
        this.bookId = bookId;
        this.rating = rating;
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
