package com.mert.bounty.ui.camera;

import android.os.Handler;
import android.os.HandlerThread;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mert Kilic on 25.9.2017.
 */
@Module
public class CameraModule {

    @Provides
    Handler provideBackgroundHandler() {
        HandlerThread thread = new HandlerThread("background");
        thread.start();
        return new Handler(thread.getLooper());
    }

    @Provides
    CameraView provideCameraView(CameraFragment fragment) {
        return fragment;
    }

    @Provides
    CameraPresenter provideCameraPresenter(CameraView cameraView, Handler backgroundHandler) {
        return new CameraPresenterImpl(cameraView, backgroundHandler);
    }

}
