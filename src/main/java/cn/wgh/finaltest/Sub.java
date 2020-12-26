package cn.wgh.finaltest;

/**
 * Created by wgh on 2020/12/25.
 */
public class Sub extends Parents {

    //在子类中定义一个doit()方法
    public final void doit() {
        System.out.println("Sub.doit()");
    }

    // final方法不能覆盖
/*
    final void doit2(){
        System.out.println("Sub.doit2()");
    }
*/

    public void doit3() {
        System.out.println("Sub.doit3()");
    }

}
