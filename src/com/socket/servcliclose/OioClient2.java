package com.socket.servcliclose;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
 * @author ng
 * @date 2019/12/12-9:52
 */
public class OioClient2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 8080);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                BufferedInputStream bufferIn = null;
                OutputStream out = null;
                try {
                    out = socket.getOutputStream();
                    bufferIn = new BufferedInputStream(socket.getInputStream());
                    int cout = 2;
                    while (cout-- > 0) {
                        out.write((Thread.currentThread().getName() + "this time is " + System.currentTimeMillis() + "\n").getBytes("UTF-8"));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                byte[] buf = new byte[1024];
                try {

                    int len;
                    while ((len = bufferIn.read(buf)) != -1) {
                        System.out.print(new String(buf, 0, len, Charset.forName("UTF-8")));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }).start();
        }
    }
}
