package com.socket;


import java.io.*;
import java.net.Socket;

/**
 * @author ng
 * @date 2019/11/10-21:25
 */
public class HelloSocket {
    public static void main(String[] args) throws IOException {
        sendRequest("localhost", 8080, "/hello");
    }

    private static void sendRequest(String host, int port, String url) throws IOException {
        Socket client = new Socket(host, port);
        StringBuffer sb = new StringBuffer("GET http://" + host + ":" + port + url + " HTTP/1.1\r\n");
        sb.append("Host:" + host + ":" + port + "\r\n");
        sb.append("User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:70.0) Gecko/20100101 Firefox/70.0\r\n");
        sb.append("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n");
        sb.append("Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2\r\n");
        sb.append("Accept-Encoding: \r\n");
        sb.append("DNT: 1\r\n");
        sb.append("Connection: keep-alive\r\n");
        sb.append("Upgrade-Insecure-Requests: 1\r\n");
        sb.append("Pragma: no-cache\r\n");
        sb.append("Cache-Control: no-cache\r\n");
        sb.append("\r\n");
        System.out.println(sb.toString());
        OutputStream os = client.getOutputStream();
        // 写给服务端 字节
        os.write(sb.toString().getBytes());
        BufferedInputStream buff = new BufferedInputStream(client.getInputStream());
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int len = -1;
        while ((len = buff.read(bytes)) != -1) {
            out.write(bytes, 0, len);
        }
        System.out.println(new String(out.toByteArray()));
        out.close();
        buff.close();
        client.close();
    }
}
