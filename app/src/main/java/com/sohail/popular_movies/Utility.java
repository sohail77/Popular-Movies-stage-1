package com.sohail.popular_movies;

import android.content.Context;
import android.database.Cursor;

import com.sohail.popular_movies.data.MovieContract;

/**
 * Created by sohail on 17/09/2016.
 */
public class Utility {

    public static int isFavorited(Context context, int id) {
        Cursor cursor = context.getContentResolver().query(
                MovieContract.MovieEntry.CONTENT_URI,
                null,   // projection
                MovieContract.MovieEntry.COLUMN_MOVIE_ID + " = ?", // selection
                new String[] { Integer.toString(id) },   // selectionArgs
                null    // sort order
        );
        int numRows = 0;
        if (cursor != null) {
            numRows = cursor.getCount();
            cursor.close();
        }

        return numRows;
    }

    public static String buildImageUrl(int width, String fileName) {
        return "http://image.tmdb.org/t/p/w" + Integer.toString(width) + fileName;
    }
}
