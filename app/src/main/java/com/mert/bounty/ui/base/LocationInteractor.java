package com.mert.bounty.ui.base;

import android.location.Location;

/**
 * Created by Mert Kilic on 23.9.2017.
 */

public interface LocationInteractor extends BountyView {
    void onLocationFound(Location location);
}
