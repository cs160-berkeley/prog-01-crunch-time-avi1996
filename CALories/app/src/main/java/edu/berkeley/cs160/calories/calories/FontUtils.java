package edu.berkeley.cs160.calories.calories;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Avi on 2/4/16.
 */
public class FontUtils {

    public static Typeface yorkTenNormBold;
    public static Typeface yorkTenNormBook;

    public static Typeface getYorkTenNormBold(Context context) {
        if (yorkTenNormBold == null) {
            Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/yorktennormbold.otf");
            yorkTenNormBold = face;
            return yorkTenNormBold;
        } else {
            return yorkTenNormBold;
        }
    }

    public static Typeface getYorkTenNormBook(Context context) {
        if (yorkTenNormBook == null) {
            Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/yorktennormbook.otf");
            yorkTenNormBook = face;
            return yorkTenNormBook;
        } else {
            return yorkTenNormBook;
        }
    }


}
