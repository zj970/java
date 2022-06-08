package com.zj.lesson01;

import java.net.InetAddress;
import java.net.UnknownHostException;

//测试ip
public class TestIntAddress {

    public static void main(String[] args) {
        try {
            //查询本机地址
            InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress1);
            InetAddress inetAddress2 = InetAddress.getByName("localhost");
            System.out.println(inetAddress2);
            InetAddress inetAddress3 = InetAddress.getLocalHost();
            System.out.println(inetAddress3);
            //查询网站ip地址  -- 原理跟ping一样
            InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress);

            //常用方法
            System.out.println(inetAddress.getAddress());
            System.out.println(inetAddress.getHostAddress());
            System.out.println(inetAddress.getCanonicalHostName());//规范的名字
            System.out.println(inetAddress.getHostName());

        } catch (UnknownHostException e){
            e.printStackTrace();
        }

    }
}
