package c04;




//1.ArrayList 数组 默认大小 10
// 不指定类型就是 Object
// 扩容：第一次1。5倍 拷贝到新数组 第二扩容 1。5倍， 不是整数则取整【向下】
// 线程不安全
//1。故障现象：java.util.ConcurrentModificationException
//2。导致原因: 没有加锁
//3。解决办法
//  1。vector 线程安全  add方法 加锁了 【不许用vector】
//  2。List<String> list = Collections.synchronizedList(new ArrayList<>());
//  3。写时复制 new CopyOnWriteArrayList<>();
//4。优化建议（同样错误不犯第2次）

//HashSet 底层是 HashMap   也是不安全的 new CopyOnWriteArraySet<>();
//Key 是E Value是 一个常量Object


//HashMap 也是线程不安全的   用 ConcurrentHashMap




//2.HashMap 默认大小 16  扩容是原值的一倍

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionNotSafe {


    public static void main(String[] args) {

        //List<String> list = new ArrayList<>();
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();

//        list.add("a");
//        list.add("a");
//        list.add("a");
//        list.forEach(System.out::println);

        for (int i=0;i<30;++i){
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

        //输出1
        //[null, b9921947, d30894d7]
        //[null, b9921947, d30894d7]
        //[null, b9921947, d30894d7]

        //输出2
        //[ebb2d0d9, d56ad7b0, 94fcbf81]
        //[ebb2d0d9, d56ad7b0, 94fcbf81]
        //[ebb2d0d9, d56ad7b0, 94fcbf81]

        //输出3
        //java.util.ConcurrentModificationException


    }
}
