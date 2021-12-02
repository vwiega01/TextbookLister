package com.example.textbooklister;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<String> mBooks = new LinkedList<>();
    private final LinkedList<String> mDescriptions= new LinkedList<>();
    private RecyclerView mRecyclerView;
    private BookAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add list of books
        mBooks.add("Book1");
        mDescriptions.add("d1");
        mBooks.add("Book2");
        mDescriptions.add("d2");
        mBooks.add("Book3");
        mDescriptions.add("d3");

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new BookAdapter(this, mBooks, mDescriptions);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void launchAddBookActivity(View view) {
        Intent intent = new Intent(this, AddBookActivity.class);
        startActivity(intent);
    }
}