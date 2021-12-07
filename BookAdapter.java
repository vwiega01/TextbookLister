package com.example.textbooklister;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.WordViewHolder>{
    private LayoutInflater mInflater;
    private LinkedList<BookObject> mBooks;
    private Context context;
    private OnBookListener mOnBookListener;

    public BookAdapter(Context context, LinkedList<BookObject> bookList, OnBookListener onBookListener) {
        mInflater = LayoutInflater.from(context);
        mBooks = bookList;
        this.context = context;
        this.mOnBookListener = onBookListener;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.book_item, parent, false);
        return new WordViewHolder(mItemView, this, mOnBookListener);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String mTitle = mBooks.get(position).title;
        String mAuthor = mBooks.get(position).author;
        holder.mTitleItemView.setText(mTitle);
        holder.mAuthorItemView.setText(mAuthor);

        BookObject book = mBooks.get(position);
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
        private TextView mTitleItemView;
        private TextView mAuthorItemView;
        private BookAdapter adapter;

        OnBookListener onBookListener;

        public WordViewHolder(View itemView, BookAdapter adapter, OnBookListener onBookListener){

            super(itemView);
            mTitleItemView = itemView.findViewById(R.id.title);
            mAuthorItemView = itemView.findViewById(R.id.author);
            this.adapter = adapter;
            this.onBookListener = onBookListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onBookListener.onBookClick(getAdapterPosition());
            Intent intent = new Intent(context, BookDetail.class);
            context.startActivity(intent);
        }
    }
    public interface OnBookListener {
        void onBookClick(int position);
    }
}
