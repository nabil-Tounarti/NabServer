package com.nabserver.httpserver.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpListener extends Thread {
    private int port;
    private String webroot;
    private ServerSocket serverSocket;

    public HttpListener(int port , String webroot) {
        this.webroot = webroot;
        this.port = port;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println(getAllStackTraces());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while(serverSocket != null && !serverSocket.isClosed()){
            try {
                Socket socket = serverSocket.accept();
                HttpWorker httpWorker = new HttpWorker(socket) ;
                httpWorker.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
