package com.mert.bounty.data.api;

import com.mert.bounty.data.BountyService;

import javax.inject.Inject;

/**
 * Created by Mert Kilic on 18.7.2017.
 */

public class BountyApiClient {

    private final BountyService service;

    @Inject
    public BountyApiClient(BountyService service) {
        this.service = service;
    }
}
