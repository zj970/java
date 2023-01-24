package senior;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.*;

/**
 * <p>
 * 测试线程池用例
 * </p>
 *
 * @author: zj970
 * @date: 2023/1/24
 */
public class TestPool {
    public static void main(String[] args) {
        //1.创建服务，创建线程池
        ExecutorService service = newFixedThreadPool(10);

        //执行
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        //2.关闭连接
        service.shutdown();
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());
    }
}
