package com.zj.lesson03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
//等待客户端的连接
public class UdpServiceDemo01 {
    public static void main(String[] args) throws Exception {
        //开发端口
        DatagramSocket socket = new DatagramSocket(9090);
        //接收数据包
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
        socket.receive(datagramPacket);//阻塞接收
        System.out.println(new String(datagramPacket.getData(),0, datagramPacket.getLength()));
        //关闭连接
        socket.close();

    }
}
