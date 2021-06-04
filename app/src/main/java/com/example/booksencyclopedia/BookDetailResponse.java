package com.example.booksencyclopedia;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookDetailResponse {

    @SerializedName("artworkUrl60")
    @Expose
    public String artworkUrl60;
    @SerializedName("artworkUrl100")
    @Expose
    public String artworkUrl100;
    @SerializedName("artistViewUrl")
    @Expose
    public String artistViewUrl;
    @SerializedName("trackCensoredName")
    @Expose
    public String trackCensoredName;
    @SerializedName("fileSizeBytes")
    @Expose
    public Integer fileSizeBytes;
    @SerializedName("formattedPrice")
    @Expose
    public String formattedPrice;
    @SerializedName("trackViewUrl")
    @Expose
    public String trackViewUrl;
    @SerializedName("artistIds")
    @Expose
    public List<Integer> artistIds = null;
    @SerializedName("genreIds")
    @Expose
    public List<String> genreIds = null;
    @SerializedName("releaseDate")
    @Expose
    public String releaseDate;
    @SerializedName("trackId")
    @Expose
    public Integer trackId;
    @SerializedName("trackName")
    @Expose
    public String trackName;
    @SerializedName("currency")
    @Expose
    public String currency;
    @SerializedName("kind")
    @Expose
    public String kind;
    @SerializedName("artistId")
    @Expose
    public Integer artistId;
    @SerializedName("artistName")
    @Expose
    public String artistName;
    @SerializedName("genres")
    @Expose
    public List<String> genres = null;
    @SerializedName("price")
    @Expose
    public Double price;
    @SerializedName("description")
    @Expose
    public String description;

}
