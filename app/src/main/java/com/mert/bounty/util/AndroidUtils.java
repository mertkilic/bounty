package com.mert.getty.util;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Mert Kilic on 23.7.2017.
 */

public class AndroidUtils {

    /**
     * Show keyboard of a View
     *
     * @param view    Edit text or another view that you want hide the keyboard
     */
    public static void showKeyboard(@NonNull View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getApplicationContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }


    /**
     * Hide keyboard of a View
     *
     * @param view    Edit text or another view that you want hide the keyboard
     */
    public static void hideKeyboard(@NonNull View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getApplicationContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * Hide keyboard
     *
     * @param activity Activity
     */
    public static void hideKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (null != view)
            hideKeyboard(view);
    }
}
