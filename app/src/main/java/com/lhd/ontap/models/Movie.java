package com.lhd.ontap.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("adult")
    @Expose
    private boolean adult;
    @SerializedName("backdrop_path")
    @Expose
    private String backDropPath;
    @SerializedName("genre_ids")
    @Expose
    private List<Integer> lsGenre;
    @SerializedName("original_language")
    @Expose
    private String originLanguage;
    @SerializedName("original_title")
    @Expose
    private String originTitle;
    @SerializedName("overview")
    @Expose
    private String overView;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("vote_average")
    @Expose
    private Float votePoint;
    @SerializedName("vote_count")
    @Expose
    private int voteCount;

    public Movie() {
    }

    public Movie(String id, boolean adult, String backDropPath, List<Integer> lsGenre, String originLanguage, String originTitle, String overView, String posterPath, String releaseDate, String title, Float votePoint, int voteCount) {
        this.id = id;
        this.adult = adult;
        this.backDropPath = backDropPath;
        this.lsGenre = lsGenre;
        this.originLanguage = originLanguage;
        this.originTitle = originTitle;
        this.overView = overView;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.title = title;
        this.votePoint = votePoint;
        this.voteCount = voteCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackDropPath() {
        return backDropPath;
    }

    public void setBackDropPath(String backDropPath) {
        this.backDropPath = backDropPath;
    }

    public List<Integer> getLsGenre() {
        return lsGenre;
    }

    public void setLsGenre(List<Integer> lsGenre) {
        this.lsGenre = lsGenre;
    }

    public String getOriginLanguage() {
        return originLanguage;
    }

    public void setOriginLanguage(String originLanguage) {
        this.originLanguage = originLanguage;
    }

    public String getOriginTitle() {
        return originTitle;
    }

    public void setOriginTitle(String originTitle) {
        this.originTitle = originTitle;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getVotePoint() {
        return votePoint;
    }

    public void setVotePoint(Float votePoint) {
        this.votePoint = votePoint;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}
