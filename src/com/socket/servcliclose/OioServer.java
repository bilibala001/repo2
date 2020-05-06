package com.socket.servcliclose;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ng
 * @date 2019/12/12-9:51
 */
public class OioServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client is connected socket = " + socket);
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            System.out.println("为这个client创建一个线程 ");

            ExecutorService pool = Executors.newFixedThreadPool(10);
            pool.execute(new ClientHander(socket,in,out));
        }
    }
}

