package com.airbnb.jiafang_jiang.flickster.models;

import android.os.Parcel;
import android.os.Parcelable;


public class MovieJsonResponse extends GenMovieJsonResponse {

    public static final Parcelable.Creator<MovieJsonResponse> CREATOR = new Parcelable.Creator<MovieJsonResponse>() {

        public MovieJsonResponse[] newArray(int size) {
            return new MovieJsonResponse[size];
        }

        public MovieJsonResponse createFromParcel(Parcel source) {
            MovieJsonResponse object = new MovieJsonResponse();
            object.readFromParcel(source);
            return object;
        }
    };

}
