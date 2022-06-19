package com.zj.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UpdReceiveDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);


        while (true){
            //准备接收包裹
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container,0,container.length);
            byte[] data = packet.getData();

            socket.receive(packet);//阻塞式接收包裹
            //断开连接
            String receiceData = new String(data,0, packet.getLength());

            System.out.println(receiceData);
            if (receiceData.equals("bye")){
                break;
            }

        }
        socket.close();
    }
}
