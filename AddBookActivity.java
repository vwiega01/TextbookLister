package com.example.textbooklister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddBookActivity extends AppCompatActivity {
    private EditText mEditTitle;
    private EditText mEditAuthor;
    private EditText mEditDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        mEditTitle = findViewById(R.id.bookTitle);
        mEditAuthor = findViewById(R.id.bookAuthor);
        mEditDescription = findViewById(R.id.bookDescription);

    }
    public void makeToast(View view) {
        Toast toast = Toast.makeText(this, "Book Posted!", Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}