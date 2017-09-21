package com.mert.bounty.ui;

import android.os.Bundle;

import com.mert.bounty.R;
import com.mert.bounty.databinding.ActivityMainBinding;
import com.mert.bounty.ui.base.BountyActivity;

import javax.inject.Inject;

public class MainActivity extends BountyActivity<ActivityMainBinding> implements MainView {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAndBindContentView(R.layout.activity_main);
    }


}
