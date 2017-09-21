package com.mert.bounty.ui.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by Mert Kilic on 22.9.2017.
 */

public abstract class BountyActivity <B extends ViewDataBinding> extends DaggerAppCompatActivity {
    protected B binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState, persistentState);
    }

    protected void setAndBindContentView(@LayoutRes int layoutId) {
        binding = DataBindingUtil.setContentView(this, layoutId);
    }
}
