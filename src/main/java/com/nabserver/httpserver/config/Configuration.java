package com.nabserver.httpserver.config;

public class Configuration {
    private int port;
    private String webroot;

    public Configuration() {
    }

    public String getWebroot() {
        return webroot;
    }

    public void setWebroot(String webroot) {
        this.webroot = webroot;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
