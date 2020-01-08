package c11;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
*
* 多线程之间按照顺序调用，实现A->B->C
* 三个线程启动，要求如下：
*
* AA打印5次，BB打印10次，CC打印15次
* next
* AA打印5次，BB打印10次，CC打印15次
* 循环10次
*
* */
public class ConditionDemo {

    private int number = 1; //A:1 B:2 C:3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();


    public void print5(){
        lock.lock();

        try{
            while(number != 1){
                c1.await();
            }
            for (int i=0;i<5;++i){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }

            number=2;
            c2.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void print10(){
        lock.lock();

        try{
            while(number != 2){
                c2.await();
            }
            for (int i=0;i<10;++i){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }

            number=3;
            c3.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void print15(){
        lock.lock();

        try{
            while(number != 3){
                c3.await();
            }
            for (int i=0;i<15;++i){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }

            number=1;
            c1.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }




    public static void main(String[] args) {
        ConditionDemo conditionDemo = new ConditionDemo();

        new Thread(() -> {
            for (int i=0;i<10;++i){
                conditionDemo.print5();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i=0;i<10;++i){
                conditionDemo.print10();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i=0;i<10;++i){
                conditionDemo.print15();
            }
        }, "C").start();

    }
}






