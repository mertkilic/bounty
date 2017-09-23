package com.mert.getty.data.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.mert.getty.data.parser.ImageSkippingJsonDeserializer;

import java.util.List;

/**
 * Created by Mert Kilic on 19.7.2017.
 */

public class GettyResponse {
    @SerializedName("result_count")
    private int resultCount;
    private List<Image> images;

    public GettyResponse(int resultCount, List<Image> images) {
        this.resultCount = resultCount;
        this.images = images;
    }

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
