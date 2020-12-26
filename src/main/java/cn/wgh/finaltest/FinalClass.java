package cn.wgh.finaltest;

/**
 * 如果将类设置为final形式，则类中的所有方法都被隐式设置为final形式，
 * 但是final类中的成员变量可以被定义为final或非final形式
 * Created by wgh on 2020/12/25.
 */
public class FinalClass {
    int a = 3;

    void doit(int x) {
        int b = 1;
        b += x;
        System.out.println(b);
    }

    public static void main(String args[]) {
        FinalClass finalClass = new FinalClass();
        //f.a++; //不允许
        System.out.println(finalClass.a);
        finalClass.doit(10);
    }
}
