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

public class CameraFragment extends Fragment {

    FragmentCameraBinding binding;

    @Inject
    CameraPresenter cameraPresenter;

    private CameraView.Callback cameraCallback = new CameraView.Callback() {
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
            cameraPresenter.savePicture(data);
        }
    };

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_camera, container, false);
        binding.camera.addCallback(cameraCallback);
        binding.btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.camera.takePicture();
            }
        });
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
}
