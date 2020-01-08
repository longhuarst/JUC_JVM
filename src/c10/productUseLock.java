package c10;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/*
*
* 使用 Lock 替代 synchronized 实现 生产一个消费一个
*   生产者x2 消费者x2
*
* */
public class productUseLock {

    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increase(){
        lock.lock();

        try{
            while(number != 0){
                condition.await();
            }

            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);

            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public void decrease(){
        lock.lock();

        try{
            while(number != 1){
                condition.await();
            }

            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);

            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        productUseLock productUseLock = new productUseLock();

        new Thread(() -> {
            for (int i=0; i<10; ++i){
                productUseLock.increase();
            }
        },"A").start();

        new Thread(() -> {
            for (int i=0; i<10; ++i){
                productUseLock.increase();
            }
        },"B").start();

        new Thread(() -> {
            for (int i=0; i<10; ++i){
                productUseLock.decrease();
            }
        },"C").start();

        new Thread(() -> {
            for (int i=0; i<10; ++i){
                productUseLock.decrease();
            }
        },"D").start();



    }
}
