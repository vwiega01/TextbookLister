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
        //mEditTitle.setInputType(InputType.TYPE_CLASS_TEXT);

        mEditAuthor = (EditText) findViewById(R.id.bookAuthor);
        //mEditAuthor.setInputType(InputType.TYPE_CLASS_TEXT);

        mEditDescription = findViewById(R.id.bookDescription);
        //mEditDescription.setInputType(InputType.TYPE_CLASS_TEXT);

        mEditPrice = findViewById(R.id.bookPrice);
        //mEditPrice.setInputType(InputType.TYPE_CLASS_TEXT);

        mEditEmail = findViewById(R.id.editEmail);
        //mEditEmail.setInputType(InputType.TYPE_CLASS_TEXT);

        BookObject book = new BookObject(mTitle, mAuthor, mDescription, mPrice, mEmail);
        MainActivity.mBooks.add(book);

//        buttonPost.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mTitle = mEditTitle.getText().toString();
//                mAuthor = mEditAuthor.getText().toString();
//                mDescription = mEditDescription.getText().toString();
//                mPrice = mEditPrice.getText().toString();
//                mEmail = mEditEmail.getText().toString();
//
//                //for debugging
//                Log.d("ADebugTag", "Title: " + mTitle);
//                Log.d("ADebugTag", "Author: " + mAuthor);
//                Log.d("ADebugTag", "Description: " + mDescription);
//                Log.d("ADebugTag", "Description: " + mPrice);
//                Log.d("ADebugTag", "Description: " + mEmail);
//
//            }
//        });
    }

    public void onClick(View v) {
        mTitle = mEditTitle.getText().toString();
        mAuthor = mEditAuthor.getText().toString();
        mDescription = mEditDescription.getText().toString();
        mPrice = mEditPrice.getText().toString();
        mEmail = mEditEmail.getText().toString();

        //for debugging
        Log.d("ADebugTag", "Title: " + mTitle);
        Log.d("ADebugTag", "Author: " + mAuthor);
        Log.d("ADebugTag", "Description: " + mDescription);
        Log.d("ADebugTag", "Description: " + mPrice);
        Log.d("ADebugTag", "Description: " + mEmail);

        Toast toast = Toast.makeText(this, "Book Posted!", Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

//    public void makeToast(View view) {
//        Toast toast = Toast.makeText(this, "Book Posted!", Toast.LENGTH_SHORT);
//        toast.show();
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//    }
}