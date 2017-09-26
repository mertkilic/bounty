package com.mert.bounty.ui.camera;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.inject.Inject;

/**
 * Created by Mert Kilic on 25.9.2017.
 */

public class CameraPresenterImpl implements CameraPresenter {

    private static final String TAG = CameraPresenterImpl.class.getSimpleName();
    private static final String PICTURE_NAME = "bounty.jpg";
    private Handler backgroundHandler;
    private Handler mainHandler = new Handler(Looper.getMainLooper());
    private CameraView cameraView;

    @Inject
    public CameraPresenterImpl(CameraView cameraView, Handler backgroundHandler) {
        this.backgroundHandler = backgroundHandler;
        this.cameraView = cameraView;
    }

    @Override
    public void savePicture(final byte[] data) {
        backgroundHandler.post(new Runnable() {
            @Override
            public void run() {
                File file = new File(cameraView.getContext().getFilesDir(), PICTURE_NAME);
                //TODO add location coordinates to ExifInterface
                OutputStream os = null;
                try {
                    os = new FileOutputStream(file);
                    os.write(data);
                    os.close();
                    onPictureSaved(file.getAbsolutePath());
                } catch (IOException e) {
                    Log.w(TAG, "Cannot write to " + file, e);
                } finally {
                    if (os != null) {
                        try {
                            os.close();
                        } catch (IOException e) {
                            // Ignore
                        }
                    }
                }
            }
        });
    }

    @Override
    public void onPictureCaptureClicked() {
        cameraView.getCamera().takePicture();
    }

    private void onPictureSaved(final String path){
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                cameraView.showPicture(path);
            }
        });
    }
}
