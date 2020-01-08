package c24;



/*
*
*                           1。1 伊甸区
*               1。新生区   1。2 幸存0区
*                           1。3幸存1区
*
*
*
*               2。老年区
*       堆
*
*
*               3。元空间 永久区
*
* */

public class Heap {


    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());


        System.gc();
    }
}
