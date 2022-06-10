package com.zj.lesson01;

import java.net.InetSocketAddress;

public class TestInetSocketAddress {

    public static void main(String[] args) {
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1",8080);
        InetSocketAddress socketAddress1 = new InetSocketAddress("localhost",8080);
        System.out.println(socketAddress);
        System.out.println(socketAddress1);

        System.out.println(socketAddress.getAddress());//ip地址
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress.getPort());
    }
}
