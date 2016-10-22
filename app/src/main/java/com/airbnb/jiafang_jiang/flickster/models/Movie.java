package com.airbnb.jiafang_jiang.flickster.models;

import android.os.Parcel;
import android.os.Parcelable;


public class Movie extends GenMovie {

    private static final String PATH_PREFIX = "https://image.tmdb.org/t/p/w342/%s";

    @Override
    public String getPosterPath() {
        return String.format(PATH_PREFIX, super.getPosterPath());
    }

    @Override
    public String getBackdropPath() {
        return String.format(PATH_PREFIX, super.getBackdropPath());
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {

        public Movie[] newArray(int size) {
            return new Movie[size];
        }

        public Movie createFromParcel(Parcel source) {
            Movie object = new Movie();
            object.readFromParcel(source);
            return object;
        }
    };

}
