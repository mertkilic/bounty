package com.mert.bounty.ui.camera;

import com.mert.bounty.ui.base.BountyPresenter;

/**
 * Created by Mert Kilic on 25.9.2017.
 */

public interface CameraPresenter extends BountyPresenter{
    void savePicture(byte[] data);
    void onPictureCaptureClicked();
}
