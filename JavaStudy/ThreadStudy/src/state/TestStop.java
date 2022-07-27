package state;

/**
 *测试停止线程
 * 1.建议线程正常停止---》使用次数，不建议死循环
 * 2.建议使用标志位---》设置一个标志位
 * 3. 不要使用stop或者destroy等过时或者JDK不建议使用的方法
 */
public class TestStop implements Runnable{
    //1.设置一个标识位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println("run........Tnread ---- " + ++i);
        }
    }

    //2.设置公开的方法停止，转换位
    public void stop(){
        this.flag = false;
        System.out.println("线程停止了");
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main---" + i);
            if (i ==900){
                //调用stop方法切换标志位让线程停止
                testStop.stop();
            }
        }
    }
}
