package org.example.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonFormatter {

    public static final ObjectMapper mapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    public static String format (String json){
        try {
            Object obj = mapper.readValue(json, Object.class);
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            return json;
        }
    }
}
