package com.zj970.reflection;

/**
 * <p>
 *  类加载器
 * </p>
 *
 * @author: zj970
 * @date: 2023/2/6
 */
public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的高一级加载器-->拓展类的加载器
        ClassLoader classLoader = systemClassLoader.getParent();
        System.out.println(classLoader);

        //获取拓展类加载器的高一级加载器-->根加载器(C/C++) --- NULL
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        //获得当前类是哪个加载器加载的
        ClassLoader classLoader2 = Class.forName("com.zj970.reflection.Test07").getClassLoader();
        System.out.println(classLoader2);

        //测试JDK内置的类是谁加载的
        ClassLoader classLoader3 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader3);

        //双亲委派机制----> 沙盒 保护核心代码不被重写
        //比如你自己写的 java.lang.String 不能使用

        //如何获得系统类加载器可以加载的路径
        /*String[] strings =  System.getProperty("java.class.path").split(":");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }*/
        System.out.println(System.getProperty("java.class.path"));
        /**
         * /home/zj970/environment/jdk1.8.0_202/jre/lib/charsets.jar
         * /home/zj970/environment/jdk1.8.0_202/jre/lib/deploy.jar
         * /home/zj970/environment/jdk1.8.0_202/jre/lib/ext/cldrdata.jar
         * /home/zj970/environment/jdk1.8.0_202/jre/lib/ext/dnsns.jar
         * /home/zj970/environment/jdk1.8.0_202/jre/lib/ext/jaccess.jar
         * /home/zj970/environment/jdk1.8.0_202/jre/lib/ext/jfxrt.jar
         * /home/zj970/environment/jdk1.8.0_202/jre/lib/ext/localedata.jar
         * /home/zj970/environment/jdk1.8.0_202/jre/lib/ext/nashorn.jar
         * /home/zj970/environment/jdk1.8.0_202/jre/lib/ext/sunec.jar
         * /home/zj970/environment/jdk1.8.0_202/jre/lib/ext/sunjce_provider.jar
         * /home/zj970/environment/jdk1.8.0_202/jre/lib/ext/sunpkcs11.jar
         * /home/zj970/environment/jdk1.8.0_202/jre/lib/ext/zipfs.jar
         * /home/zj970/environment/jdk1.8.0_202/jre/lib/javaws.jar
         * /home/zj970/environment/jdk1.8.0_202/jre/lib/jce.jar
         * /home/zj970/environment/jdk1.8.0_202/jre/lib/jfr.jar
         * /home/zj970/environment/jdk1.8.0_202/jre/lib/jfxswt.jar
         * /home/zj970/environment/jdk1.8.0_202/jre/lib/jsse.jar
         * /home/zj970/environment/jdk1.8.0_202/jre/lib/management-agent.jar
         * /home/zj970/environment/jdk1.8.0_202/jre/lib/plugin.jar
         * /home/zj970/environment/jdk1.8.0_202/jre/lib/resources.jar
         * /home/zj970/environment/jdk1.8.0_202/jre/lib/rt.jar
         * /home/zj970/data/github/JavaWorkpase/JavaStudy/out/production/annotation
         * /home/zj970/data/software/IDEA_2021_1_3/idea-IU-211.7628.21/lib/idea_rt.jar
         */
    }
}
