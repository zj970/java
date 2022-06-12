package com.zj.lesson02;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务器
public class TcpServerDemo01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;

        //1. 我得有个地址
        try {
            serverSocket = new ServerSocket(9999);
            while(true){
                //2.等待客户端连接
                accept = serverSocket.accept();//监听
                //3.读取客户端的信息
                inputStream = accept.getInputStream();
            /*
            byte[] buffer = new byte[1024];//缓冲区
            int len;
            while((len=inputStream.read(buffer))!=-1){
                String s = new String(buffer,0,len);
                System.out.println("客户端信息"+s);
            }//会出现乱码
             */

                //管道流
                byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, len);
                }
                System.out.println("客户端信息：" + byteArrayOutputStream.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
