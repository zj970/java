package state;

/**
 * <p>
 * 测试线程Join方法
 * 它使主线程进行等待，被插入的线程执行结束后才执行
 * join就是阻塞当前线程，等join的线程执行完毕后，被阻塞的线程才执行
 * </p>
 *
 * @author: zj970
 * @date: 2023/1/15
 */
public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程vip来了=================" + i);
        }
    }

    public static void main(String[] args) {
        //启动我们的线程
        TestJoin testJoin = new TestJoin();
        //静态代理模式
        Thread thread = new Thread(testJoin);
        //主线程
        for (int i = 0; i < 500; i++) {
            if (i == 200){
                //插队
                try {
                    thread.start();
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("main====" + i);
        }
    }
}
