package com.zj.lesson03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

//不需要连接服务器
public class UdpClientDemo01 {
    public static void main(String[] args) throws Exception {
        //1.建立一个Socket
        DatagramSocket socket = new DatagramSocket();

        //2.建一个包
        String msg = "hello,你好啊";
        //发送给谁
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9090;
        //数据 数据的长度，要发送给谁
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(),0,msg.getBytes().length,localhost,port);
        //3.发送包
        socket.send(datagramPacket);

        //4.关闭流
        socket.close();
    }

}
