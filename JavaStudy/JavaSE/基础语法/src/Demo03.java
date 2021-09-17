public class Demo03 {
    public static void main(String[] args){
        //整数拓展： 进制 二进制ob 十进制 八进制0 十六进制0x

        int i = 10;
        int j = 010;//八进制0
        int k = 0x10;//十六进制0x 0~9 A~F 16

        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        System.out.println("=======================");
        /**************************************************************************************************
         *  浮点数拓展？应行业务怎么表示？钱                                                                     *
         *  银行业务最好完全避免使用浮点数进行比较                                                                *
         *  BigDecimal 数学工具类                                                                           *
         **************************************************************************************************/
        //float   有限 离散 舍入误差 大约 接近但不等于
        //double

        float a = 0.1f;
        double b = 1.0/10;
        System.out.println(a == b);
        System.out.println(a);
        System.out.println(b);

        float c = 231313131223212f;
        float d = c + 1;
        System.out.println(d == c);
        System.out.println(c);
        System.out.println(d);

        System.out.println("=======================");
        /**************************************************************************************************
         *  字符拓展？
         *  所有的字符本质还是数字
         *  编码 Unicode 占2个字节  0~65536 Excel 2 16 = 65536
         *  A~Z : 65~90 a~z: 97~122
         **************************************************************************************************/

        char c1 = 'z';
        char c2 = '中';

        System.out.println(c1);
        System.out.println((int)c1);//强制转换
        System.out.println(c2);
        System.out.println((int)c2);

        char c3 = '\u0061';
        System.out.println(c3);

        //转移字符
        // \t 制表符
        // \n 换行


        System.out.println("=======================");
        String sa = new String("Hello world");
        String sb = new String("Hello world");
        System.out.println(sa == sb);//false

        String SA = "Hello world";
        String SB = "Hello world";
        System.out.println(SA == SB);//true
        //对象 从内存分析

        //布尔值扩展
        boolean flag = true;

        if (flag==true){}//新手
        if (flag){}//老鸟
        //Less is More！代码要精简易读

    }
}
