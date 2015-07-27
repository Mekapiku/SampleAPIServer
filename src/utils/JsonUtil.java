package utils;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;

/**
 * Created by mitsuyasu on 2015/07/27.
 */
public class JsonUtil {

    private static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final GsonBuilder builder = new GsonBuilder().setDateFormat(DATE_FORMAT);

    private JsonUtil() {
    }

    public static <T> T fromJson(String json, Class<T> clazz) throws JsonParseException {
        return builder.create().fromJson(json, clazz);
    }

    public static <T> String toJson(T object) throws JsonIOException {
        return builder.create().toJson(object);
    }
}
