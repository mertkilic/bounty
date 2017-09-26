package com.mert.bounty.ui.camera;

import com.google.android.cameraview.CameraView;

/**
 * Created by Mert Kilic on 25.9.2017.
 */

public class CameraCallback extends CameraView.Callback {

    @Override
    public void onCameraOpened(CameraView cameraView) {
        super.onCameraOpened(cameraView);
    }

    @Override
    public void onCameraClosed(CameraView cameraView) {
        super.onCameraClosed(cameraView);
    }

    @Override
    public void onPictureTaken(CameraView cameraView, byte[] data) {
        super.onPictureTaken(cameraView, data);
    }
}
