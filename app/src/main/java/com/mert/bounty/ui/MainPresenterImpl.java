package com.mert.bounty.ui;

import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;

import com.mert.bounty.data.api.BountyService;

import javax.inject.Inject;

/**
 * Created by Mert Kilic on 22.7.2017.
 */

public class MainPresenterImpl extends BaseObservable implements MainPresenter {

    private String TAG = MainPresenterImpl.class.getSimpleName();

    private MainView mainView;
    private BountyService service;
    private ObservableBoolean cameraOpen = new ObservableBoolean(false);

    @Inject
    MainPresenterImpl(MainView mainView, BountyService service) {
        this.mainView = mainView;
        this.service = service;
    }

    @Override
    public void onTakePictureRequested() {
        mainView.onTakePictureButtonClicked();
    }

    public void setCameraOpen(boolean cameraOpen) {
        this.cameraOpen.set(cameraOpen);
    }

    public ObservableBoolean getCameraOpen() {
        return cameraOpen;
    }
}
