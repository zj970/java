package demo02;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * 线程创建方式三 实现Callable
 * Callable的好处
 * 1. 可以有返回值
 * 2. 可以抛出异常
 */

public class TestCallable  implements Callable<Boolean> {
    /**
     * 网络图片地址
     */
    private String url;
    /**
     * 保存的文件名
     */
    private String name;

    /**
     * 有参构造
     * @param url {@link #url}
     * @param name {@link #name}
     */
    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为:"+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException,InterruptedException {
        TestCallable t1 = new TestCallable("https://tse2-mm.cn.bing.net/th/id/OIP-C.Oys8bCsp_ZYcIDUf82hZgwHaFm?pid=ImgDet&rs=1","4.jpg");
        TestCallable t2 = new TestCallable("https://www.helicopassion.com/images/RIAT15/ApacheUK/RIAT15334h.jpg","5.jpg");
        TestCallable t3 = new TestCallable("https://tse2-mm.cn.bing.net/th/id/OIP-C.Z3rqi4g44nA3RnjZRk-2GQHaE8?pid=ImgDet&w=5616&h=3744&rs=1","6.jpg");

        /**
         * 创建执行服务
         */
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        //获取结果
        Boolean rs1 = r1.get();
        Boolean rs2 = r2.get();
        Boolean rs3 = r3.get();

        //关闭服务
        ser.shutdownNow();
    }
}

/**
 * 下载器
 */
class WebDownloader{
    /**
     * 下载
     * @param url 网址
     * @param name 保存文件名
     */
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("IO异常，downloader 方法出现问题");
        }
    }
}