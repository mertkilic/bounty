package com.mert.bounty.ui.camera;

import android.content.Context;
import android.os.Handler;
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
    private Handler backgroundHandler;
    private Context context;

    @Inject
    public CameraPresenterImpl(Context context, Handler backgroundHandler) {
        this.backgroundHandler = backgroundHandler;
        this.context = context;
    }

    @Override
    public void savePicture(final byte[] data) {
        backgroundHandler.post(new Runnable() {
            @Override
            public void run() {
                File file = new File(context.getFilesDir(), "picture.jpg");
                OutputStream os = null;
                try {
                    os = new FileOutputStream(file);
                    os.write(data);
                    os.close();
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
}
