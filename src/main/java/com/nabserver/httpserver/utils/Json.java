package com.nabserver.httpserver.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nabserver.httpserver.config.Configuration;

import java.io.File;
import java.io.IOException;

public class Json {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static Configuration parseJsonToConfigurationObject(String filePath)  {
        try {
            return objectMapper.readValue(new File(filePath), Configuration.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
