package com.example.booksencyclopedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    Context ctx;
    List<BookDetailResponse> listBooks;

    public BooksAdapter(Context ctx) {
        this.ctx = ctx;
        this.listBooks = new ArrayList<>();
    }

    public void setListBooks(List<BookDetailResponse> listBooks) {
        this.listBooks = listBooks;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_row_book, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BookDetailResponse book = listBooks.get(position);
        holder.tvTitle.setText(book.trackName);

        Glide.with(ctx)
                .load(book.artworkUrl60)
                .into(holder.ivThumbnail);
    }

    @Override
    public int getItemCount() {
        return listBooks.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ivThumbnail;
        TextView tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.ivThumbnail);
            tvTitle = itemView.findViewById(R.id.tvTitle);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            BookDetailResponse book = listBooks.get(position);

            String info = "Author: " + book.artistName + ", Price: " + book.price;
            Toast.makeText(ctx, info, Toast.LENGTH_LONG).show();
        }
    }
}
