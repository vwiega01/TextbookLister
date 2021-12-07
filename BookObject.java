package com.example.textbooklister;

import android.widget.EditText;

public class BookObject {

    public String title;
    public String author;
    public String description;
    public String price;
    public String email;

    public BookObject(String title, String author, String description, String price, String email) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
        this.email = email;
    }
}
