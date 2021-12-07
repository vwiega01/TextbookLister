package com.example.textbooklister;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements BookAdapter.OnBookListener {
    public static LinkedList<BookObject> mBooks = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private BookAdapter mAdapter;
    public static BookObject selectedBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new BookAdapter(this, mBooks, this);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void launchAddBookActivity(View view) {
        Intent intent = new Intent(this, AddBookActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBookClick(int position) {
        selectedBook = mBooks.get(position);
        Intent intent = new Intent(this, BookDetail.class);
        startActivity(intent);
    }
}
