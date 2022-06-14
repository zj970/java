package com.zj.lesson02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TcpServerDemo02 {
    public static void main(String[] args) throws Exception{
        //1.创建服务
        ServerSocket serverSocket = new ServerSocket(9000);
        //2.监听客户端的连接--阻塞式监听，会一直等待客户端连接
        Socket accept = serverSocket.accept();
        //3.获取输入流
        InputStream inputStream = accept.getInputStream();
        //4.文件输出
        FileOutputStream fileOutputStream = new FileOutputStream(new File("receive.png"));//默认放在项目根目录下
        byte[] buffer = new byte[1024];
        int len;
        while((len = inputStream.read())!=-1){
            fileOutputStream.write(buffer,0,len);
        }
        //通知客户端我接收完毕了
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("我接收完毕了，你可以断开了".getBytes());
        //5.关闭资源
        outputStream.close();
        fileOutputStream.close();
        inputStream.close();
        serverSocket.close();
        serverSocket.close();
    }
}
