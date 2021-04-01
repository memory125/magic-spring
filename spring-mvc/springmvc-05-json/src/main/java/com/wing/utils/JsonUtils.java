package com.wing.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * @author memory125
 */
public class JsonUtils {
    public static String jsonFormat(Object object, String dataFormat) {
        ObjectMapper mapper = new ObjectMapper();

        SimpleDateFormat sdf = new SimpleDateFormat(dataFormat);

        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.setDateFormat(sdf);

        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String jsonFormat(Object object) {
        return jsonFormat(object, "yyyy-MM-dd HH:mm:ss");
    }
}
