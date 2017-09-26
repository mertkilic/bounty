package com.mert.bounty.ui.camera;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.cameraview.CameraView;
import com.mert.bounty.R;
import com.mert.bounty.databinding.FragmentCameraBinding;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * Created by Mert Kilic on 25.9.2017.
 */

public class CameraFragment extends Fragment implements com.mert.bounty.ui.camera.CameraView {

    FragmentCameraBinding binding;
    CameraInteractionListener listener;

    @Inject
    CameraPresenter cameraPresenter;

    private CameraView.Callback cameraCallback = new CameraView.Callback() {
        @Override
        public void onCameraOpened(CameraView cameraView) {
            listener.onCameraOpened();
        }

        @Override
        public void onCameraClosed(CameraView cameraView) {
            listener.onCameraClosed();
        }

        @Override
        public void onPictureTaken(CameraView cameraView, byte[] data) {
            cameraPresenter.savePicture(data);
        }
    };

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        if (context instanceof CameraInteractionListener) {
            listener = (CameraInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_camera, container, false);
        binding.setPresenter(cameraPresenter);
        binding.camera.addCallback(cameraCallback);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.camera.start();
    }

    @Override
    public void onPause() {
        binding.camera.stop();
        super.onPause();
    }

    @Override
    public CameraView getCamera() {
        return binding.camera;
    }

    @Override
    public void showPicture(String path) {
//TODO show picture to user with send to the server option
    }

    public interface CameraInteractionListener{
        void onCameraOpened();
        void onCameraClosed();
    }
}
