package c14;



/*
*
* 虚拟机自带加载器
*   1。启动类加载器  Bootstrap c++
*   2。拓展类加载器  Extension Java
*   3。应用程序类加载器 AppClassLoader
*
* 用户自定义加载器
* Java.lang.ClassLoader的子类，用户可以自己定制
* */
public class ClassLoader1 {


    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(object.getClass().getClassLoader()); //bootstap 获取为null
//        System.out.println(object.getClass().getClassLoader().getParent());
//        System.out.println(object.getClass().getClassLoader().getParent().getParent());

        //AppClassLoader
        ClassLoader1 classLoader1 = new ClassLoader1();
        System.out.println(classLoader1.getClass().getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(classLoader1.getClass().getClassLoader().getParent());
        System.out.println(classLoader1.getClass().getClassLoader().getParent().getParent());
    }
}
