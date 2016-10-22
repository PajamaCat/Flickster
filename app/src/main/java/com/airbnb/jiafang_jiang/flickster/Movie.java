package com.airbnb.jiafang_jiang.flickster;

import android.os.Parcel;
import android.os.Parcelable;
import com.airbnb.jiafang_jiang.flickster.models.GenMovie;


public class Movie extends GenMovie {

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
