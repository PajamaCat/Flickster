package com.airbnb.jiafang_jiang.flickster;

import android.os.Parcel;
import android.os.Parcelable;
import com.airbnb.jiafang_jiang.flickster.models.GenMovieJsonResponse;


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
