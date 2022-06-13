package com.zj.lesson02;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClientDeme02 {
    public static void main(String[] args) throws Exception {
        //1.创建一个 Socket
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9000);
        //2.创建一个输出流
        OutputStream outputStream = socket.getOutputStream();
        //3.文件流
        FileInputStream fileInputStream = new FileInputStream("zj.jpp");
    }
}
