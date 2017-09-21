package com.mert.bounty.ui;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Mert Kilic on 21.9.2017.
 */
@Module
public abstract class MainBuilder {
    @ContributesAndroidInjector(
            modules = {MainActivityModule.class})
    public abstract MainActivity bindMainActivity();
}
