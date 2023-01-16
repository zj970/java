package state;

/**
 * <p>
 *  测试线程的优先级
 *  由于本机是多线程CPU，这里并不是可以很直观的看到效果
 *  不过线程的优先级是可以设置的，但是要看CPU实际调度
 * </p>
 *
 * @author: zj970
 * @date: 2023/1/16
 */
public class TestPriority {
    public static void main(String[] args) {
        //打印主线程默认优先级
        System.out.println(Thread.currentThread().getName() + "------------------>" + Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();

        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);
        Thread t6 = new Thread(myPriority);

        //先设置优先级再启动
        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();

        t5.setPriority(2);
        t5.start();

        t6.setPriority(9);
        t6.start();

    }
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "----> " + Thread.currentThread().getPriority());
    }
}