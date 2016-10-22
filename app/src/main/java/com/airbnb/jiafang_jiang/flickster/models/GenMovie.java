package com.airbnb.jiafang_jiang.flickster.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;

/** Automatically generated Parcelable implementation for GenMovie.
 *    DO NOT MODIFY THIS FILE MANUALLY! IT WILL BE OVERWRITTEN THE NEXT TIME
 *    GenMovie's PARCELABLE DESCRIPTION IS CHANGED.
 */
public abstract class GenMovie implements Parcelable {

    @JsonProperty("release_date") protected Date mReleaseDate;
    @JsonProperty("genre_ids") protected List<Integer> mGenreIds;
    @JsonProperty("poster_path") protected String mPosterPath;
    @JsonProperty("backdrop_path") protected String mBackdropPath;
    @JsonProperty("overview") protected String mOverview;
    @JsonProperty("original_title") protected String mOriginalTitle;
    @JsonProperty("original_language") protected String mOriginalLanguage;
    @JsonProperty("title") protected String mTitle;
    @JsonProperty("snippet_text") protected String mSnippetText;
    @JsonProperty("snippet_image_url") protected String mSnippetImageUrl;
    @JsonProperty("adult") protected boolean mAdult;
    @JsonProperty("video") protected boolean mVideo;
    @JsonProperty("popularity") protected double mPopularity;
    @JsonProperty("vote_average") protected double mVoteAverage;
    @JsonProperty("id") protected int mId;
    @JsonProperty("vote_count") protected int mVoteCount;

    protected GenMovie(
            Date releaseDate,
            List<Integer> genreIds,
            String posterPath,
            String backdropPath,
            String overview,
            String originalTitle,
            String originalLanguage,
            String title,
            String snippetText,
            String snippetImageUrl,
            boolean adult,
            boolean video,
            double popularity,
            double voteAverage,
            int id,
            int voteCount) {
        this();
        mReleaseDate = releaseDate;
        mGenreIds = genreIds;
        mPosterPath = posterPath;
        mBackdropPath = backdropPath;
        mOverview = overview;
        mOriginalTitle = originalTitle;
        mOriginalLanguage = originalLanguage;
        mTitle = title;
        mSnippetText = snippetText;
        mSnippetImageUrl = snippetImageUrl;
        mAdult = adult;
        mVideo = video;
        mPopularity = popularity;
        mVoteAverage = voteAverage;
        mId = id;
        mVoteCount = voteCount;
    }

    protected GenMovie() {
    }

    public Date getReleaseDate() { return mReleaseDate; }

    @JsonProperty("release_date")
    public void setReleaseDate(Date value) { mReleaseDate = value; }

    public List<Integer> getGenreIds() { return mGenreIds; }

    @JsonProperty("genre_ids")
    public void setGenreIds(List<Integer> value) { mGenreIds = value; }

    public String getPosterPath() { return mPosterPath; }

    @JsonProperty("poster_path")
    public void setPosterPath(String value) { mPosterPath = value; }

    public String getBackdropPath() { return mBackdropPath; }

    @JsonProperty("backdrop_path")
    public void setBackdropPath(String value) { mBackdropPath = value; }

    public String getOverview() { return mOverview; }

    @JsonProperty("overview")
    public void setOverview(String value) { mOverview = value; }

    public String getOriginalTitle() { return mOriginalTitle; }

    @JsonProperty("original_title")
    public void setOriginalTitle(String value) { mOriginalTitle = value; }

    public String getOriginalLanguage() { return mOriginalLanguage; }

    @JsonProperty("original_language")
    public void setOriginalLanguage(String value) { mOriginalLanguage = value; }

    public String getTitle() { return mTitle; }

    @JsonProperty("title")
    public void setTitle(String value) { mTitle = value; }

    public String getSnippetText() { return mSnippetText; }

    @JsonProperty("snippet_text")
    public void setSnippetText(String value) { mSnippetText = value; }

    public String getSnippetImageUrl() { return mSnippetImageUrl; }

    @JsonProperty("snippet_image_url")
    public void setSnippetImageUrl(String value) { mSnippetImageUrl = value; }

    public boolean isAdult() { return mAdult; }

    @JsonProperty("adult")
    public void setAdult(boolean value) { mAdult = value; }

    public boolean isVideo() { return mVideo; }

    @JsonProperty("video")
    public void setVideo(boolean value) { mVideo = value; }

    public double getPopularity() { return mPopularity; }

    @JsonProperty("popularity")
    public void setPopularity(double value) { mPopularity = value; }

    public double getVoteAverage() { return mVoteAverage; }

    @JsonProperty("vote_average")
    public void setVoteAverage(double value) { mVoteAverage = value; }

    public int getId() { return mId; }

    @JsonProperty("id")
    public void setId(int value) { mId = value; }

    public int getVoteCount() { return mVoteCount; }

    @JsonProperty("vote_count")
    public void setVoteCount(int value) { mVoteCount = value; }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeLong(mReleaseDate == null ? Integer.MIN_VALUE : mReleaseDate.getTime());
        parcel.writeValue(mGenreIds);
        parcel.writeString(mPosterPath);
        parcel.writeString(mBackdropPath);
        parcel.writeString(mOverview);
        parcel.writeString(mOriginalTitle);
        parcel.writeString(mOriginalLanguage);
        parcel.writeString(mTitle);
        parcel.writeString(mSnippetText);
        parcel.writeString(mSnippetImageUrl);
        parcel.writeBooleanArray(new boolean[] {mAdult, mVideo});
        parcel.writeDouble(mPopularity);
        parcel.writeDouble(mVoteAverage);
        parcel.writeInt(mId);
        parcel.writeInt(mVoteCount);
    }

    public void readFromParcel(Parcel source) {
        long date0 = source.readLong();
        if (date0 != Integer.MIN_VALUE) {
            mReleaseDate = new Date(date0);
        }
        mGenreIds = (List<Integer>) source.readValue(null);
        mPosterPath = source.readString();
        mBackdropPath = source.readString();
        mOverview = source.readString();
        mOriginalTitle = source.readString();
        mOriginalLanguage = source.readString();
        mTitle = source.readString();
        mSnippetText = source.readString();
        mSnippetImageUrl = source.readString();
        boolean[] bools = source.createBooleanArray();
        mAdult = bools[0];
        mVideo = bools[1];
        mPopularity = source.readDouble();
        mVoteAverage = source.readDouble();
        mId = source.readInt();
        mVoteCount = source.readInt();
    }

}
