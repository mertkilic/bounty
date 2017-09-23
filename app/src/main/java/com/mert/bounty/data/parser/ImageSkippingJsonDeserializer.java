package com.mert.getty.data.parser;

import com.google.gson.JsonElement;

/**
 * Created by Mert Kilic on 20.7.2017.
 */

public class ImageSkippingJsonDeserializer extends SkippingJsonDeserializer {

    private ImageSkippingJsonDeserializer() {
    }

    @Override
    JsonElement extract(JsonElement jsonElement) {
        return jsonElement
                .getAsJsonArray()
                .get(0).getAsJsonObject().get("uri");
    }
}
