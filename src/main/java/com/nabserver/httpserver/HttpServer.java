package com.nabserver.httpserver;

import com.nabserver.httpserver.config.Configuration;
import com.nabserver.httpserver.config.ConfigurationManager;
import com.nabserver.httpserver.core.HttpListener;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public static void main(String[] args) {
        System.out.println("Server Starting ...");
        ConfigurationManager configurationManager = ConfigurationManager.getInstance();
        Configuration configuration = configurationManager.getConfiguration();
        System.out.println("port : " + configuration.getPort());
        System.out.println("web Root : " + configuration.getWebroot());

        HttpListener httpListener = new HttpListener(configuration.getPort(),configuration.getWebroot());
        httpListener.start();

    }
}
