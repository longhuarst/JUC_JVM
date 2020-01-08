package c16;




/*
*
* 进程线程是操作系统的特性 和语言没关系
*
*
* Java 多线程只能start一次    start 内部调用start0();
* java.lang.Thread 是类 不是接口
*
* private native void start0();     //native 表示 这是系统语言提供   放在Native Method Stack 本地方法栈 中  执行native方法时 PC为空
*
* native 是一个关键字  有声明 无实现
*
*
*
* 方法区： 储存每一个类的结构信息
*           方法区是规范，在不同虚拟机中实现是不一样的，最典型的就是永久代（PermGen space）和元空间（MetaSpace）
*
*               空调 k1 = new 格里();
*               List list = new ArrayList();
*
*               方法区 f = new 永久代
*               方法区 f = new 元空间
*
*   栈管运行，堆管存储
*
* 栈：
*   存储：8种基本类型+对象的引用变量+实例方法
*
* 堆：
*
*
* java方法=栈帧
*
*
* java.lang.StackOverFlowError  栈溢出     是错误不是异常
*
*
* HotSpot 是使用指针的方法来访问对象
* Java堆中会存放访问 类元数据 的地址
* reference 存储的就直接是对象地址
*
*
*
*
* */

public class LocalInterface {

    public void sayHello()
    {

    }

    public static  void air()
    {

    }

    public static void main(String[] args) {
        Thread t1 = new Thread();

        t1.start();
        t1.start();//java.lang.IllegalThreadStateException
    }
}
