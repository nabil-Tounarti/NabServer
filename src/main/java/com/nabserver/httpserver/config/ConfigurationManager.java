package com.nabserver.httpserver.config;

import com.nabserver.httpserver.utils.Json;

import java.io.IOException;

public class ConfigurationManager {
    private static ConfigurationManager configurationManager;
    private Configuration configuration;

    private ConfigurationManager () throws IOException {
        configuration = Json.parseJsonToConfigurationObject("src/main/resources/httpServerConfig.json");
    }
    public static ConfigurationManager getInstance() {
        if(configurationManager==null){
            try {
                configurationManager = new ConfigurationManager();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return configurationManager;
    }
    public Configuration getConfiguration(){
        return this.configuration;
    }
}
