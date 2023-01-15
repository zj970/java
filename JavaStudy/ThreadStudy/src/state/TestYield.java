package state;

/**
 * <p>
 * 测试礼让线程
 * 礼让不一定成功，看CPU心情
 * </p>
 *
 * @author: zj970
 * @date: 2023/1/15
 */
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield, "a").start();
        new Thread(myYield, "b").start();
    }
}

class MyYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--------线程开始执行");
        if (Thread.currentThread().getName().equals("a")){
            Thread.yield();//礼让
        }
        System.out.println(Thread.currentThread().getName() + "--------线程开始停止");

    }
}
