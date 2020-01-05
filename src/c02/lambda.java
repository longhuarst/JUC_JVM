package c02;

@FunctionalInterface //函数式接口 可以不写 自动识别
interface Foo{
    public int add(int a, int b);

    default int mul(int a, int b){
        return a*b;
    }

    public static int div(int a, int b){
        return a/b;
    }
}


/*
* 1。 lambda
* 2。 @FunctionalInterface 只能一个方法 但可以写 default 和 static
* 3。 default    可以写多个
* 4。 static     可以写多个
* */
public class lambda {




    public static void main(String[] args) {

        Foo f = (int a, int b) -> { return a+b; };

        System.out.println(f.add(3,5));
        System.out.println(f.mul(3,5));
        System.out.println(Foo.div(3,5));

    }
}
