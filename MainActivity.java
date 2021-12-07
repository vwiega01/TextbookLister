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
    public static final LinkedList<BookObject> mBooks = new LinkedList<>();
    private final LinkedList<String> mTitles = new LinkedList<>();
    private final LinkedList<String> mAuthors= new LinkedList<>();
    private RecyclerView mRecyclerView;
    private BookAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < mBooks.size(); i++) {
            BookObject obj = mBooks.get(i);
            mTitles.add(obj.title);
            mAuthors.add(obj.author);
        }

        mAdapter = new BookAdapter(this, mTitles, mAuthors);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void launchAddBookActivity(View view) {
        Intent intent = new Intent(this, AddBookActivity.class);
        startActivity(intent);
    }
}
