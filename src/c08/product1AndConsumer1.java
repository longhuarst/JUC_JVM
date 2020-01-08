package c08;

/*
* 生产一个 消费一个 交替10次
* */

 /* <p>
* As in the one argument version, interrupts and spurious wakeups are
     * possible, and this method should always be used in a loop:
     * <pre>
     synchronized (obj) {
         while (&lt;condition does not hold&gt;)
             obj.wait();
         ... // Perform action appropriate to condition
     }
 </pre>
*/


public class product1AndConsumer1 {

    int number = 0;


    public synchronized void decrease() throws Exception{
        while (number != 1){    //多线程判断不能用if 必须用while  防止虚假唤醒
            this.wait();
        }

        number--;

        System.out.println(Thread.currentThread().getName()+"\t"+number);

        this.notifyAll();
    }

    public synchronized void increase() throws Exception{
        while (number != 0){    //多线程判断不能用if 必须用while  防止虚假唤醒
            this.wait();
        }

        number++;

        System.out.println(Thread.currentThread().getName()+"\t"+number);

        this.notifyAll();
    }





    public static void main(String[] args) {
        product1AndConsumer1 product1AndConsumer1 = new product1AndConsumer1();


        new Thread(() -> {
            for (int i=0; i<10; ++i){
                try {
                    product1AndConsumer1.increase();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(() -> {
            for (int i=0; i<10; ++i){
                try {
                    product1AndConsumer1.decrease();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();



    }

}
