package com.shinntl.utils;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtil {
    private String stringJson;
    public HttpUtil(String stringJson) {
        this.stringJson = stringJson;
    }
    public <T> T toModel(Class<T> tClass) {
        try {
            return new ObjectMapper().readValue(stringJson, tClass);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static HttpUtil of(BufferedReader reader) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            String line;
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return new HttpUtil(stringBuilder.toString());
    }
}
