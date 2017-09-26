package com.mert.bounty.ui;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

import com.mert.bounty.R;
import com.mert.bounty.data.location.LocationService;
import com.mert.bounty.databinding.ActivityMainBinding;
import com.mert.bounty.ui.base.BountyActivity;
import com.mert.bounty.ui.camera.CameraFragment;
import com.mert.bounty.util.PermissionUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BountyActivity<ActivityMainBinding> implements MainView {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    MainPresenter presenter;

    @Inject
    LocationService locationService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAndBindContentView(R.layout.activity_main);
        binding.setPresenter(presenter);
        locationService.buildConnection();
    }

    @Override
    protected void onStart() {
        super.onStart();
        locationService.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        locationService.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        locationService.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        locationService.onPause();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onLocationFound(Location location) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            // Check for the integer request code originally supplied to startResolutionForResult().
            case LocationService.REQUEST_CHECK_SETTINGS:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        Log.i(TAG, "User agreed to make required location settings changes.");
                        locationService.startLocationUpdates();
                        break;
                    case Activity.RESULT_CANCELED:
                        Log.i(TAG, "User chose not to make required location settings changes.");
                        break;
                }
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PermissionUtils.PERMISSION_REQUEST_CODE:
                if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                        Manifest.permission.CAMERA)) {
                    if (PermissionUtils.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                        openCamera();
                    }
                }

                if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                        Manifest.permission.ACCESS_FINE_LOCATION)) {
                    locationService.startLocationUpdates();
                    if (PermissionUtils.checkSelfPermission(this, Manifest.permission.CAMERA)) {
                        openCamera();
                    } else showMissingPermissionError();
                }


                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onTakePictureButtonClicked() {
        boolean permissionRequested = false;
        List<String> permissions = new ArrayList<>();
        if (!PermissionUtils.checkSelfPermission(this, Manifest.permission.CAMERA)) {
            permissions.add(Manifest.permission.CAMERA);
            permissionRequested = true;
        }

        if (!PermissionUtils.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
            permissionRequested = true;
        }

        if (permissionRequested) {
            PermissionUtils.requestPermission(this, PermissionUtils.PERMISSION_REQUEST_CODE,
                    permissions.toArray(new String[permissions.size()]), false);
        } else {
            //locationService.startLocationUpdates();
            openCamera();
        }
    }

    private void showMissingPermissionError() {
        PermissionUtils.PermissionDeniedDialog
                .newInstance(false).show(getSupportFragmentManager(), "dialog");
    }

    private void openCamera(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager()
                        .beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.fragment_container,new CameraFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}
