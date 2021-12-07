package com.example.textbooklister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddBookActivity extends AppCompatActivity {
    EditText mEditTitle;
    EditText mEditAuthor;
    EditText mEditDescription;
    EditText mEditEmail;
    EditText mEditPrice;
    String mTitle;
    String mAuthor;
    String mDescription;
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
        mEditDescription = findViewById(R.id.bookDescription);
        mEditPrice = findViewById(R.id.bookPrice);
        mEditEmail = findViewById(R.id.editEmail);
    }

    public void onClick(View v) {
        mTitle = mEditTitle.getText().toString();
        mAuthor = mEditAuthor.getText().toString();
        mDescription = mEditDescription.getText().toString();
        mPrice = mEditPrice.getText().toString();
        mEmail = mEditEmail.getText().toString();

        BookObject book = new BookObject(mTitle, mAuthor, mDescription, mPrice, mEmail);
        MainActivity.mBooks.addFirst(book);

        //for debugging
//        Log.d("ADebugTag", "Title: " + mTitle);
//        Log.d("ADebugTag", "Author: " + mAuthor);
//        Log.d("ADebugTag", "Description: " + mDescription);
//        Log.d("ADebugTag", "Description: " + mPrice);
//        Log.d("ADebugTag", "Description: " + mEmail);

        Toast toast = Toast.makeText(this, "Book Posted!", Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}