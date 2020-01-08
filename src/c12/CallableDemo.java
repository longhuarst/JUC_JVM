package c12;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
* 多线程方法实现
* 1。继承Thread类
* 2。实现Runable方法
* 3。Callable
* 4。线程池
* */
/*
*
* 区别：
* 1。重写方法不一样
* 2。返回值不一样
* 3。是否抛出异常
*
* */

class MyThread implements Runnable
{

    @Override
    public void run() {

    }
}

//有返回值的线程
class MyThread2 implements Callable<Integer>
{

    @Override
    public Integer call() throws Exception {
        System.out.println("********in.....");
        return 1024;
    }
}



public class CallableDemo {





    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask(new MyThread2());


        new Thread(futureTask,"A").start();

        Integer result = futureTask.get();

        System.out.println(result);
    }
}
