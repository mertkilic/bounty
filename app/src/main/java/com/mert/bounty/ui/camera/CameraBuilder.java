package com.mert.bounty.ui.camera;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Mert Kilic on 25.9.2017.
 */
@Module
public abstract class CameraBuilder {
    @ContributesAndroidInjector(
            modules = {CameraModule.class})
    public abstract CameraFragment bindCameraFragment();
}
