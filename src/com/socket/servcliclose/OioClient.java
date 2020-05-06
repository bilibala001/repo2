package com.socket.servcliclose;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.Charset;

/**
 * @author ng
 * @date 2019/12/12-9:52
 */
public class OioClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        new Thread(() -> {
            InputStream in = null;
            try {
                in = socket.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedInputStream bufferIn = new BufferedInputStream(in);
            byte[] buf = new byte[1024];
            try {

                System.out.println("---------" + Thread.currentThread().getName());
                Thread.sleep(1000);
                int len;
                while ((len = bufferIn.read(buf)) != -1) {
                    System.out.print(new String(buf, 0, len, Charset.forName("UTF-8")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                socket.shutdownInput();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }).start();
        OutputStream out = socket.getOutputStream();
        int cout = 10;
        while (cout-- > 0) {
            out.write(("this time is " + System.currentTimeMillis() + "\n").getBytes("UTF-8"));
        }
        socket.shutdownOutput();

    }
}
