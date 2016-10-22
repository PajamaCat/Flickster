package com.airbnb.jiafang_jiang.flickster.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** Automatically generated Parcelable implementation for GenMovieJsonResponse.
 *    DO NOT MODIFY THIS FILE MANUALLY! IT WILL BE OVERWRITTEN THE NEXT TIME
 *    GenMovieJsonResponse's PARCELABLE DESCRIPTION IS CHANGED.
 */
@JsonIgnoreProperties({ "dates" })

public abstract class GenMovieJsonResponse implements Parcelable {

    @JsonProperty("results") protected List<Movie> mResults;
    @JsonProperty("page") protected int mPage;
    @JsonProperty("total_pages") protected int mTotalPages;
    @JsonProperty("total_results") protected int mTotalResults;

    protected GenMovieJsonResponse(
            List<Movie> results,
            int page,
            int totalPages,
            int totalResults) {
        this();
        mResults = results;
        mPage = page;
        mTotalPages = totalPages;
        mTotalResults = totalResults;
    }

    protected GenMovieJsonResponse() {
    }

    public List<Movie> getResults() { return mResults; }

    @JsonProperty("results")
    public void setResults(List<Movie> value) { mResults = value; }

    public int getPage() { return mPage; }

    @JsonProperty("page")
    public void setPage(int value) { mPage = value; }

    public int getTotalPages() { return mTotalPages; }

    @JsonProperty("total_pages")
    public void setTotalPages(int value) { mTotalPages = value; }

    public int getTotalResults() { return mTotalResults; }

    @JsonProperty("total_results")
    public void setTotalResults(int value) { mTotalResults = value; }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeTypedList(mResults);
        parcel.writeInt(mPage);
        parcel.writeInt(mTotalPages);
        parcel.writeInt(mTotalResults);
    }

    public void readFromParcel(Parcel source) {
        mResults = source.createTypedArrayList(Movie.CREATOR);
        mPage = source.readInt();
        mTotalPages = source.readInt();
        mTotalResults = source.readInt();
    }

}
