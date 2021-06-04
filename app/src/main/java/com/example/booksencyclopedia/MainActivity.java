package com.example.booksencyclopedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    List<BookDetailResponse> listBooks;
    RecyclerView rvBooks;
    BooksAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvBooks = findViewById(R.id.rvBooks);

        LinearLayoutManager llManager = new LinearLayoutManager(this);
        rvBooks.setLayoutManager(llManager);

        adapter = new BooksAdapter(this);
        rvBooks.setAdapter(adapter);

        Retrofit retrofit = ApiClient.getRetrofit();
        iTunesService service = retrofit.create(iTunesService.class);

        Call<BookListResponse> call = service.getBooks("harry potter");

        call.enqueue(new Callback<BookListResponse>() {
            @Override
            public void onResponse(Call<BookListResponse> call, Response<BookListResponse> response) {
                if(response.isSuccessful()) {
                    BookListResponse bookListResponse = response.body();
                    listBooks = bookListResponse.results;
                    adapter.setListBooks(listBooks);
                }
            }

            @Override
            public void onFailure(Call<BookListResponse> call, Throwable t) {

            }
        });

    }
}