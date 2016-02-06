package edu.berkeley.cs160.calories.calories;


import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by Avi on 10/10/15.
 */
public class ImageUtils {

    private static final String TAG = "ImageUtils";

    public static void loadImage(Context context, File file, ImageView target) {
        Picasso.with(context)
                .load(file)
                .fit()
                .centerCrop()
                .into(target);
    }

    public static void loadImageFromUrl(Context context, String url, ImageView target) {
        Picasso.with(context)
                .load(url)
                .fit()
                .into(target);
    }

    public static void loadImageFromUrlWithoutFitting(Context context, String url, ImageView target) {
        Picasso.with(context)
                .load(url)
                .into(target);
    }

    public static void loadImage(Context context, int resId, ImageView target) {
        Picasso.with(context)
                .load(resId)
                .fit()
                .centerCrop()
                .into(target);
    }

}
