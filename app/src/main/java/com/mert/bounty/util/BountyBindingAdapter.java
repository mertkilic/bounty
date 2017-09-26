package com.mert.bounty.util;

import android.databinding.BindingConversion;
import android.view.View;

/**
 * Created by Mert Kilic on 26.9.2017.
 */

public class BountyBindingAdapter {
    @BindingConversion
    public static int getVisibility(boolean visible) {
        return visible ? View.VISIBLE : View.GONE;
    }
}
