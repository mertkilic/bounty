package com.mert.getty.util;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.mert.getty.R;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

/**
 * Created by Mert Kilic on 23.7.2017.
 */

public class GettyBindingAdapter {

    final Activity activity;

    @Inject
    public GettyBindingAdapter(Activity activity) {
        this.activity = activity;
    }

    @BindingAdapter("imageUrl")
    public void bindImage(ImageView imageView, String url) {
        Picasso.with(activity).load(url).placeholder(R.drawable.ic_placeholder).into(imageView);
    }

    @BindingAdapter("scrollListener")
    public void setScrollListener(RecyclerView recyclerView, RecyclerView.OnScrollListener listener) {
        recyclerView.clearOnScrollListeners();
        recyclerView.addOnScrollListener(listener);
    }

    @BindingConversion
    public static int getVisibility(boolean visible) {
        return visible ? View.VISIBLE : View.GONE;
    }
}
