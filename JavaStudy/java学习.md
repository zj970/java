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

