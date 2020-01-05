package c01;

//3 个售票员 卖 40 张票。

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicket {

    int number = 40;
    Lock l = new ReentrantLock();//可重入锁

    void sale(){


        l.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出的最后第" + number + "张票");
                number--;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            l.unlock();
        }


    }


    public static void main(String[] args) {
        SaleTicket st = new SaleTicket();

        new Thread(() -> { for (int i=0; i<40; ++i) { st.sale(); } }, "A").start();
        new Thread(() -> { for (int i=0; i<40; ++i) { st.sale(); } }, "B").start();
        new Thread(() -> { for (int i=0; i<40; ++i) { st.sale(); } }, "C").start();



    }
}
