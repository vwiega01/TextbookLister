package com.example.textbooklister;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BookDetail extends AppCompatActivity {
    TextView mViewTitle;
    TextView mViewAuthor;
    TextView mViewISBN;
    TextView mViewEmail;
    TextView mViewPrice;

    @SuppressLint("SetTextI18n")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        mViewTitle = (TextView) findViewById(R.id.bookTitle);
        mViewAuthor = (TextView) findViewById(R.id.bookAuthor);
        mViewISBN = (TextView) findViewById(R.id.bookISBN);
        mViewPrice = (TextView) findViewById(R.id.bookPrice);
        mViewEmail = (TextView) findViewById(R.id.userEmail);

        mViewTitle.setText("Title: " + MainActivity.selectedBook.title);
        mViewAuthor.setText("Author: " + MainActivity.selectedBook.author);
        mViewISBN.setText("ISBN: " + MainActivity.selectedBook.ISBN);
        mViewPrice.setText("Price: $" + MainActivity.selectedBook.price);
        mViewEmail.setText("Email " + MainActivity.selectedBook.email + " to purchase.");
    }

    public void goToAmazon(View view) {
        goToUrl ("https://www.amazon.com/s?k="+ MainActivity.selectedBook.ISBN + "&ref=nb_sb_noss");
    }

    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}