package com.mert.getty.data.parser;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Mert Kilic on 20.7.2017.
 */

abstract class SkippingJsonDeserializer<T> implements JsonDeserializer<T> {
    abstract JsonElement extract(JsonElement jsonElement);

    @Override
    public final T deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext context)
            throws JsonParseException {
        return context.deserialize(extract(jsonElement), type);
    }
}
