package com.example.textbooklister;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.textbooklister.R;

import java.util.LinkedList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.WordViewHolder>{
    //the inflater creates the single item layout
    //see it used in onCreateViewHolder below
    private LayoutInflater mInflater;
    private LinkedList<String> mTitles;
    private LinkedList<String> mAuthors;
    private Context context;

    //the constructor can take any parameters we need
    public BookAdapter(Context context, LinkedList<String> titleList,
                         LinkedList<String> authorList) {
        //use this to create the layout
        mInflater = LayoutInflater.from(context);
        mTitles = titleList;
        mAuthors = authorList;
        this.context = context;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.book_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String mTitle = mTitles.get(position);
        String mDescription = mAuthors.get(position);
        holder.mTitleItemView.setText(mTitle);
        holder.mAuthorItemView.setText(mDescription);
    }

    @Override
    public int getItemCount() {
        return mTitles.size();
    }

    //The RecyclerView.ViewHolder class must be an inner class
    //of the adapter class.
    //WordViewHolder is the Java class that represents the wordlist_item.xml layout
    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //instantiate any views used in the item layout here
        private TextView mTitleItemView;
        private TextView mAuthorItemView;
        private BookAdapter adapter;

        public WordViewHolder(View itemView, BookAdapter adapter) {
            super(itemView);
            mTitleItemView = itemView.findViewById(R.id.title);
            mAuthorItemView = itemView.findViewById(R.id.author);
            this.adapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, BookDetail.class);
            context.startActivity(intent);
        }
    }

}
