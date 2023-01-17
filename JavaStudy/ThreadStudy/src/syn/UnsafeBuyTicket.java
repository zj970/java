package syn;

/**
 * <p>
 *  不安全的买票
 *  多线程操作同一对象会导致出现负数
 * </p>
 *
 * @author: zj970
 * @date: 2023/1/16
 */
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();
        new Thread(station,"甲").start();
        new Thread(station,"乙").start();
        new Thread(station,"丙").start();
    }

}

class BuyTicket implements Runnable{

    //票
    private int ticketNums = 10;
    private boolean flag = true;//外部停止方式
    @Override
    public void run() {

        //买票
        while (flag){
            //模拟延时
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            buy();
        }
    }

    //synchronized 同步方法，锁的是this
    private synchronized void buy(){
        //判断是否有票
        if (ticketNums <= 0)
        {
            flag = false;
            return;
        }

        //买票
        System.out.println(Thread.currentThread().getName() + "拿到====" + ticketNums--);
    }
}
