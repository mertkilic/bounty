package com.mert.bounty.ui.camera;

import com.mert.bounty.ui.base.BountyView;

/**
 * Created by Mert Kilic on 26.9.2017.
 */

public interface CameraView  extends BountyView{
    com.google.android.cameraview.CameraView getCamera();
    void showPicture(String path);
}
