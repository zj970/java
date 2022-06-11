package com.zj.lesson02;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务器
public class TcpServerDemo01 {
    public static void main(String[] args) {
        //1. 我得有个地址
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            //2.等待客户端连接
            Socket accept = serverSocket.accept();//监听
            //3.读取客户端的信息
            InputStream inputStream = accept.getInputStream();
            /*
            byte[] buffer = new byte[1024];//缓冲区
            int len;
            while((len=inputStream.read(buffer))!=-1){
                String s = new String(buffer,0,len);
                System.out.println("客户端信息"+s);
            }
             */

            //管道流
            new ByteArrayInputStream()

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
