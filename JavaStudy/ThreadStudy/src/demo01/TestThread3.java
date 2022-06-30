package demo01;

//创建线程方式2：实现runnable 接口，重写run方法，执行线程需要对如runnable接口实现类，调用start方法
public class TestThread3 implements Runnable {

    @Override
    public void run() {
        //run 方法线程体
        for (int i = 0; i < 200; i++) {
            System.out.println("我在看代码" + i);
        }
    }

    public static void main(String[] args) {
        //创建runnable对象
        TestThread3 testThread = new TestThread3();

        //创建线程对象，通过线程对象来开启我们的线程，代理模式
        new Thread(testThread).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("我在学习多线程====="+i);
        }
    }
}
