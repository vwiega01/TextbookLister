package com.example.textbooklister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddBookActivity extends AppCompatActivity {
    EditText mEditTitle;
    EditText mEditAuthor;
    EditText mEditISBN;
    EditText mEditEmail;
    EditText mEditPrice;
    String mTitle;
    String mAuthor;
    String mISBN;
    String mEmail;
    String mPrice;
    Button buttonPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        buttonPost = (Button) findViewById(R.id.buttonPost);
        mEditTitle = (EditText) findViewById(R.id.bookTitle);
        mEditAuthor = (EditText) findViewById(R.id.bookAuthor);
        mEditISBN = findViewById(R.id.bookISBN);
        mEditPrice = findViewById(R.id.bookPrice);
        mEditEmail = findViewById(R.id.editEmail);
    }

    public void onClick(View v) {
        mTitle = mEditTitle.getText().toString();
        mAuthor = mEditAuthor.getText().toString();
        mISBN = mEditISBN.getText().toString();
        mPrice = mEditPrice.getText().toString();
        mEmail = mEditEmail.getText().toString();

        BookObject book = new BookObject(mTitle, mAuthor, mISBN, mPrice, mEmail);
        MainActivity.mBooks.addFirst(book);

        Toast toast = Toast.makeText(this, "Book Posted!", Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}