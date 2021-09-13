# 学习准备：博客

- 博客，英文名为Blog,它的正式名称为网络日记
- 为什么要写博客？
  - 需要总结和思考。有时候我们一直在赶路，却忘了放慢脚步
  - 提升文笔组织能力
  - 提升学习总结能力
  - 提升逻辑思维能力
  - 帮助他人，结交朋友
- 冰冻三尺非一日之寒，写博客也是，短期内可能看不到效果，但是长期坚持，对自己的提升很有帮助



# MarkDown语法

## **标题**

==#＋空格== 设置为一级标题

==##+空格== 设置为二级标题

- 几个#代表几级标题，后面加空格，最多六级标题

- 也可以用ctrl+1/2/3/4快捷键设置标题



## 字体

**粗体**

两个**， 文字在中间 

快捷键 ctrl + B





*斜体*

两个*，文字在中间

快捷键，ctrl+i



~~删除线~~

两个~~, 文字在中间

快捷键 Alt+shift+5



<u>下划线</u>

快捷键 ctrl+U



## 引用

> 自信即巅峰

引用  ：开头输入 >





## 分割线

我是分割线

***



---

起始位置：输入3个  ==-==, 或者三个 ==*==



## 图片

![name](E:\学习资源\日系动漫.jpg)

![网络图片](https://tse1-mm.cn.bing.net/th/id/R-C.250f95855aec49c974acb36b3ed32571?rik=BgcOI1PX1fb%2bww&riu=http%3a%2f%2fwww.desktx.com%2fd%2ffile%2fwallpaper%2fscenery%2f20170120%2f387b1a5181ebeddbec90fd5f19e606ce.jpg&ehk=Feb%2bz1leZKOVuTS20av3z7LKELRP0HH277cc6aSrAeI%3d&risl=&pid=ImgRaw&r=0)

插入图片格式 ==英文感叹号! + 中括号[图片名字自定义]+(图片路径)== 可以是本地路径也可以是url路径

也可以 ctrl + C 、ctrl + V 



## 超链接

[点击跳转csdn](https://editor.csdn.net/md/?articleId=113530568)

**格式**：==英文中括号[name]+(超链接地址)== 或者==ctrl+K==

这里在网页里可以直接访问，在typora里面可以通过 ==ctrl+鼠标点击== 打开网站访问



## 列表

***有序列表*** ： 1. 加空格 或者 ==ctrl+shift+[== 二级 ==Tab== 一下

1. A
2. B
3. C

***无序列表***  *加空格 或者 ==ctrl+shift+]== 二级同上

* A
  * a



## 表格

1. ==ctrl+T==
2. 打开==源代码模式==--表头、数据

表头数据：|名字|性别|生日|

表中格式：|:----|:----:|----:|与上面一致，分别是居右，居中，居左

表中数据：|张三|男|1999.02.11|

|名字|性别|生日|
|:----|:----:|----:|
|张三|男|1999.02.11|



## 代码

三个==`==  然后选择语言

```java 
//支持很多语言
public class Hello{
  public static void main(String args[]){
    System.out.printf("Hello world");
  }
}
```





## 流程图

- 三个``` 然后选择flow

- 主要的语法为==name=>type:describe==,其中type主要有以下几种：(==英文冒号后面必须加空格==)

1. 开始和结束：start/end
2. 输入输出: inputoutput
3. 操作: operation
4. 条件: condition
5. 子程序：subroutine

示例：

```flow
st=>start: Start
io=>inputoutput: verification
op=>operation: Your Operation
cond=>condition: Yes or No?
sub=>subroutine: Your subroutine
e=>end: END
st->io->op->cond
cond(yes)->e
cond(no)->sub->io
```

​	

## 高亮

两个==,内容在中间 

参考文献：[markdown文档](https://markdown.com.cn/extended-syntax/tables.html)          [CSDN大佬博客](https://blog.csdn.net/afei__/article/details/80717153?ops_request_misc=&request_id=&biz_id=102&utm_term=makerdown%E8%AF%AD%E6%B3%95&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-2-80717153.pc_search_insert_download&spm=1018.2226.3001.4187)

---

# 什么是计算机？

- **Computer:全称电子计算机，俗称电脑**
- **能够按照程序运行，自动、高速处理海量数据的现代化智能电子设备。**
- **由==硬件==和==软件==所组成**
- **常见的形式有台式计算机、笔记本计算机、大型计算机等**
- **广泛应用在：科学计算，数据处理。自动控制，计算机辅助设计、人工智能、网络等领域**

## 计算机硬件

- 一些物理装置按系统结构的要求构成一个有机整体为计算机软件运行提供物质基础。

- 计算机硬件组成

  - CPU  Memory(内存) Motherboard(主板)
  - 主板 IO设备
  - 内存
  - 电源、主机箱
  - 硬盘
  - 显卡
  - 键盘、鼠标
  - 显示器
  - 等等.....

  ---

  

### 冯.诺依曼体系结构

冯·诺依曼结构也称[普林斯顿结构](https://baike.baidu.com/item/普林斯顿结构/6688362)，是一种将程序指令存储器和数据存储器合并在一起的存储器结构。程序指令存储地址和数据存储地址指向同一个存储器的不同物理位置，因此程序指令和数据的宽度相同，如英特尔公司的8086[中央处理器](https://baike.baidu.com/item/中央处理器/284033)的程序指令和数据都是16[位宽](https://baike.baidu.com/item/位宽/104377)。

数学家[冯·诺依曼](https://baike.baidu.com/item/冯·诺依曼/388909)提出了计算机制造的三个基本原则，即采用二进制逻辑、程序存储执行以及计算机由五个部分组成（[运算器](https://baike.baidu.com/item/运算器/2667320)、[控制器](https://baike.baidu.com/item/控制器/2206126)、[存储器](https://baike.baidu.com/item/存储器/1583185)、[输入设备](https://baike.baidu.com/item/输入设备/10823368)、[输出设备](https://baike.baidu.com/item/输出设备/10823333)），这套理论被称为冯·诺依曼体系结构。

![冯.诺依曼体系结构](C:\Users\zj\AppData\Roaming\Typora\typora-user-images\image-20210911220236205.png)

---



## 计算机软件

- 计算机软件可以使计算机按照事先预定好的顺序完成特定的功能
- 计算机软件按照其功能划分为==系统软件==与==应用软件==
- **系统软件**
  - DOS(Disk Operating System), Windows, Linux, Unix, Mac, Android, IOS,鸿蒙....
- **应用软件**
  - WPS 、QQ、微信、英雄联盟、绝地求生....
- 软件、开发。软件开发
- 人机交互（图形化界面，命令行）



## 常用的Dos命令

```bash
#盘符切换 
E:
#创建文件夹
md <name>
#删除文件夹
rd <name>
#删除文件
del <name>
#查看当前目录下的所有文件 
dir
#切换目录 cd 目录地址
cd ..
#清理屏幕 
cls (clear screen)
#退出终端
exit
#查看电脑的ip
ipconfig
/liunx ifconfig
#打开应用
	calc计算机
	mspaint画图
	notepad记事本
	
#Ping 命令
	ping www.baidu.com
	


```





----

## 计算机语言发展史

### 第一代语言

- 计算机的基本计算方式都是基于二级制的方式。
- 二进制：0101 1011 1001 0100 0111 0101 0101 1101 #include <stdio.h>
- 这种代码直接输入给计算机使用，不经过任何的转换

### 第二代语言

- **汇编语言**
  - 解决人类无法读懂机器语言的问题
  - 指令代替二进制
- 目前应用：
  - 逆向工程
  - 机器人
  - 病毒
  - .....

### 第三代语言

- 高级语言
- 大体分为： ==面向过程==和==面向对象==两大类
- C语言使经典的面向过程的语言。C++、JAVA是经典的面向对象的语言。
- 聊聊各种语言：
  - C语言
  - C++
  - JAVA
  - C#
  - Python,PHP,JavaScript
  - .....



----

# JAVA 发展与介绍

## C & C++

- 1972年C诞生
  - 贴近硬件，运行极快，效率极高
  - 操作系统，编译器，数据库，网络系统等
  - 指针和内存管理
- 1982年C++诞生
  - 面向对象
  - 兼容C
  - 图形领域、游戏等

## Java初生

- 1995年的网页简单而粗糙。缺乏互动性
- 图形界面的程序（Applet）
- Bill Gates说：这是至今为止设计最好能的语言



- Java 2标准版(**J2SE**)：去占领桌面
- Java 2移动版(**J2ME**)：去占领手机
- Java 2企业版(**J2EE**)：去占领服务器



- 他们基于Java开发了居多的平台、系统、工具
  - 构建工具:Ant ,Maven, Jekins
  - 应用服务器：Tomcat，Jetty, Jboss, Webshere,weblogic(三高：==高性能 高并发 高可用==)
  - Web开发：Struts, Spring, Hibernate, myBatis
  - 开发工具：Eclipse, Netbean, intellij idea, Jbuilder
  - ....
- 2006: Hadoop (大数据领域)
- 2008: Android (手机端)

## Java特性和优势

- 简单性
- 面向对象
- 可移植性
- 高性能
- 分布式
- 动态性
- 多线程
- 安全性
- 健壮性

---



## java三大版本

- Write Once,Run Anywhere
- JavaSE: 标准版（桌面程序，控制台开发...)
- JavaME:嵌入式开发(手机，小家电....)
- JavaEE:企业级开发(Web端，服务器开发....)



## Java程序运行机制

- 编译性
- 解释性

- 程序运行机制

  ![image-20210911233829318](C:\Users\zj\AppData\Roaming\Typora\typora-user-images\image-20210911233829318.png)

---

# Java基础语法

## 注释、标识符、关键字

### 注释

- ==书写注释是一个非常好的习惯==
- Java中的注释有三种：
  - 单行注释
  - 多行注释
  - 文档注释

---

### 关键字

| abstract   | assert       | boolean   | break      | byte   |
| ---------- | ------------ | --------- | ---------- | ------ |
| case       | catch        | char      | class      | const  |
| continue   | default      | do        | double     | else   |
| enum       | extends      | final     | finally    | float  |
| for        | goto         | if        | implements | import |
| instanceof | int          | interface | long       | native |
| new        | package      | private   | protected  | public |
| return     | strictfp     | short     | static     | supper |
| switch     | synchronized | this      | throw      | throws |
| transient  | try          | void      | volatile   | while  |

==Java 所有的组成部分都需要名字。类名、变量以及方法名都被称为标识符。==

### 标识符注意点

- 所有的标识符的首字符是字母(==A-Z==或者==a-z==),美元符(==$==)、或者下划线(==_==)

- 首字符之后可以是字母(==A-Z==或者==a-z==),美元符(==$==)、下划线(==_==)或者数字的任何字符组合

- 不能使用关键字作为变量名或者方法名

- 标识符是==大小写敏感==的

- 合法标识符举例：age、$salary、_value、__1_value

- 非法标识符举例:123Bc、-salary、#adc

  ```java
  public static void main(){
  	string 王者荣耀 = "最强王者“;
    System.out.println(王者荣耀);
  }
  ```

- 可以使用中文命名，但是一般不建议这样使用，也不建议使用拼音，很low(==C语言中不能以中文命名==)
