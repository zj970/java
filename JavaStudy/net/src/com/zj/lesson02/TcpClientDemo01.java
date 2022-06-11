package com.zj.lesson02;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

//客户端
public class TcpClientDemo01 {
    public static void main(String[] args) {
        //1. 要知道服务器地址
        try{
            InetAddress serverIP = InetAddress.getByName("localhost");
            //2.端口号
            int port = 9999;
            //3.创建一个socket连接
            Socket socket = new Socket(serverIP,port);
            //4.发送消息IO流
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("你好，服务器".getBytes(StandardCharsets.UTF_8));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
