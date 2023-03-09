package java.demo;

public class Demo {
    public static void main(String[] args) {
        new Thread(() -> {

        }, "my Thread").start();

        //native:凡是带了native关键字的，说明java的作用范围达不到了，回去调用底层C语言的库！
        //会进入本地方法栈
        //调用本地方法接口，想要立足，必须要有调用c、c++的程序
        //他在内存区域中专门开辟了一块标记区域：Native Method Stack，标记native方法
        //Java程序驱动打印机，管理系统
    }

    private native void start0();
}