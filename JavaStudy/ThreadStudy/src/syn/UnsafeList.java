package syn;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  线程不安全的集合
 * </p>
 *
 * @author: zj970
 * @date: 2023/1/16
 */
public class UnsafeList {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(list.size());

    }
}
