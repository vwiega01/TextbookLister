package com.example.textbooklister;

public class BookObject {

    public String title;
    public String author;
    public String ISBN;
    public String price;
    public String email;

    public BookObject(String title, String author, String ISBN, String price, String email) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
        this.email = email;
    }

}
