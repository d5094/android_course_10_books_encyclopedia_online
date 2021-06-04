package com.example.booksencyclopedia;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface iTunesService {
    @GET("/search?media=ebook")
    Call<BookListResponse> getBooks(@Query("term") String keyword);
}
