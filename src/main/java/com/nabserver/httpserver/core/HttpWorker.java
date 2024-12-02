package com.nabserver.httpserver.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpWorker extends Thread{
    private static final Logger logger = LoggerFactory.getLogger(HttpWorker.class);
    private Socket socket;

    public HttpWorker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            logger.info("Running in thread: {}", Thread.currentThread().getName());
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println("the request message : " + reader.readLine());
            final String reponse = "HTTP/1.1 200 OK\n" +
                    "Content-Type: text/html\n" +
                    "Content-Length: 70\n" +
                    "\n" +
                    "<html>\n" +
                    "<head><title>Welcome</title></head>\n" +
                    "<body><h1>Hello, World!</h1></body>\n" +
                    "</html>";
            outputStream.write(reponse.getBytes());
            inputStream.close();
            outputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
