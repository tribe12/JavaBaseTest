package cn.wgh.finaltest;

/**
 * Created by wgh on 2020/12/25.
 */
public class Parents {

    private final void doit() {
        System.out.println("Parents.doit()");
    }

    final void doit2() {
        System.out.println("Parents.doit2()");
    }

    public void doit3() {
        System.out.println("Parents.doit3()");
    }
}
