package syn;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>
 *  测试JUC安全类型的集合
 * </p>
 *
 * @author: zj970
 * @date: 2023/1/18
 */
public class TestJUC {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
