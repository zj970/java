package state;

/**
 * <p>
 *  测试守护线程
 * </p>
 *
 * @author: zj970
 * @date: 2023/1/16
 */
public class TestDaemon {
    public static void main(String[] args) {
       God god = new God();
       You you = new You();

       Thread thread = new Thread(god);
       //默认值为false，表示是用户线程，正常的线程都是用户线程；true表示为守护线程
       thread.setDaemon(true);
       thread.start();

       //用户线程启动
       new Thread(you).start();

    }
}

class God implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("上帝守护你");
        }
    }
}

class You implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello, world");
        for (int i = 0; i < 36500; i++) {
            System.out.println("你活了 " + i + "天，都开心的活着");
        }
        System.out.println("goodBye ! world!");
    }
}