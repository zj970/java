package com.zj.lesson04;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLDown {
    public static void main(String[] args) throws Exception {
        //1. 下载地址
        URL url = new URL("http://m701.music.126.net/20220621231213/b1089356069f998e45dcdd5327352191/jdyyaac/obj/w5rDlsOJwrLDjj7CmsOj/14960576886/cfd4/fb18/3885/f23678ff0e30fbda7924d2957acccb57.m4a");

        //2. 连接这个资源 HTTP
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("ss.m4a");
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1){
            fos.write(buffer,0,len);//写出这个数据
        }

        fos.close();
        inputStream.close();
        urlConnection.connect();//断开连接
    }
}
