package com.mert.getty.data.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.mert.getty.data.parser.ImageSkippingJsonDeserializer;

/**
 * Created by Mert Kilic on 18.7.2017.
 */
public class Image {
    private String id;
    private String title;
    private String caption;

    @SerializedName("display_sizes")
    @JsonAdapter(ImageSkippingJsonDeserializer.class)
    private String url;

    public Image(String id, String title, String caption, String url) {
        this.id = id;
        this.title = title;
        this.caption = caption;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
