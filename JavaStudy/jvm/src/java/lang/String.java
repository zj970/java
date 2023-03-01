package java.lang;


/**
 * 1. 类加载器收到类加载的请求!
 * 2. 将这个请求向上委托给富勒加载器去完成,一直向上委托,直到启动类加载器
 * 3. 启动加载器检查是否能够加载当前这个类,能加载就结束,使用当前的加载器,否则抛出异常,通知子加载器进行加载
 * 4. 重复步骤 3
 * Class Not Found
 *
 * null: java调用不到---C/C++ 没有
 *
 */

public class String {
    //双亲委派机制: 安全
    //1. APP--->EXC--->BOOT(最终执行)
    //优先级找寻
    //BOOT
    //EXC
    //APP

    public String toString() {
        return "hello";
    }


    public static void main(String[] argss){
        String s = new String();
        System.out.println(s.getClass().getClassLoader());
        s.toString();
    }
}
