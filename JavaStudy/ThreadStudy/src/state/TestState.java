package state;

/**
 * <p>
 *  观察测试线程的状态
 * </p>
 *
 * @author: zj970
 * @date: 2023/1/16
 */
public class TestState {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("/////////");
        });
        //观察状态
        Thread.State state =  thread.getState();
        //NEW
        System.out.println(state);

        //观察启动后
        thread.start();
        //启动线程
        state =  thread.getState();
        //Run
        System.out.println(state);
        //只要线程不终止，就一直输出状态
        while (state != Thread.State.TERMINATED){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //更新线程状态
            state = thread.getState();
            //输出
            System.out.println(state);
        }
        //thread.start();//线程不能死而复生
    }
}
