package c15;





/*
*
*   1。双亲委派机制
*      从根装载器（Bootstrap）开始找加载，保证自己写的代码不污染java原生的代码，只有没找的时候才会找下一层，最终没找到返回ClassNotFound
*       自己实现java.lang.String 执行会 执行java默认的String 而失败
*   2。沙箱安全
*
* */

public class ClassLoader2 {


    public static void main(String[] args) {


    }
}
