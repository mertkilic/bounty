package com.mert.getty.ui;

import com.mert.getty.util.GettyBindingAdapter;

/**
 * Created by Mert Kilic on 24.7.2017.
 */

public class SearchDataBindingComponent implements android.databinding.DataBindingComponent {

    private final GettyBindingAdapter adapter;

    public SearchDataBindingComponent(MainActivity activity) {
        this.adapter = new GettyBindingAdapter(activity);
    }

    @Override
    public GettyBindingAdapter getGettyBindingAdapter() {
        return adapter;
    }
}
