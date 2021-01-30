package cn.wgh.designpattern.behavioral.template;

/**
 * Created by wgh on 2021/1/30.
 */
public abstract class F {
    void m() {
        op1();
        op2();
    }

    abstract void op1();

    abstract void op2();
}
