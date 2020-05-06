package com.socket.servcliclose;

import sun.awt.windows.ThemeReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @author ng
 * @date 2019/12/12-11:02
 */
public class ClientHander implements Runnable {
    Socket socket;
    InputStream in;
    OutputStream out;

    public ClientHander(Socket socket, InputStream in, OutputStream out) {
        this.socket = socket;
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        try {
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) != -1) {
                System.out.print(new String(buf, 0, len, Charset.forName("UTF-8")));
                out.write(buf, 0, len);
            }
            out.write("\n end \n".getBytes(Charset.forName("UTF-8")));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                socket.shutdownInput();
                socket.shutdownOutput();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
