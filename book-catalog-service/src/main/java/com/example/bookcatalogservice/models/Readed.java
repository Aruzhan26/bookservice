package com.example.bookcatalogservice.models;

public class Readed {
    private String bookId;
    private String readed;

    public Readed() {
    }

    public Readed(String bookId, String readed) {
        this.bookId = bookId;
        this.readed = readed;
    }

    public String getReaded() {
        return readed;
    }

    public void setReaded(String readed) {
        this.readed = readed;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
