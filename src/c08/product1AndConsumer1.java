package c08;

/*
* 生产一个 消费一个 交替10次
* */


public class product1AndConsumer1 {

    int number = 0;


    public synchronized void decrease() throws Exception{
        if (number != 1){
            this.wait();
        }

        number--;

        System.out.println(Thread.currentThread().getName()+"\t"+number);

        this.notifyAll();
    }

    public synchronized void increase() throws Exception{
        if (number != 0){
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
