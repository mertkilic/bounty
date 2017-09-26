package com.mert.bounty.ui;

import com.mert.bounty.ui.camera.CameraBuilder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Mert Kilic on 21.9.2017.
 */
@Module
public abstract class MainBuilder {
    @ContributesAndroidInjector(
            modules = {MainActivityModule.class, CameraBuilder.class})
    public abstract MainActivity bindMainActivity();
}
