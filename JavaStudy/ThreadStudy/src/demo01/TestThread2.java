package demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习Thread,实现多线程同步下载图片
public class TestThread2  implements Runnable{
    private String url;//网络图片地址
    private String name;//保存的文件名

    public TestThread2(String url, String name){
        this.name = name;
        this.url = url;
    }


    //下载图片的执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为:"+name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://tse2-mm.cn.bing.net/th/id/OIP-C.Oys8bCsp_ZYcIDUf82hZgwHaFm?pid=ImgDet&rs=1","1.jpg");
        TestThread2 t2 = new TestThread2("https://www.helicopassion.com/images/RIAT15/ApacheUK/RIAT15334h.jpg","2.jpg");
        TestThread2 t3 = new TestThread2("https://tse2-mm.cn.bing.net/th/id/OIP-C.Z3rqi4g44nA3RnjZRk-2GQHaE8?pid=ImgDet&w=5616&h=3744&rs=1","3.jpg");

        //线程的结束不是顺序，同时执行
//        t1.start();
//        t2.start();
//        t3.start();

        //采取代理模式
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}

//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("IO异常，downloader 方法出现问题");
        }
    }
}
