package cn.wgh.finaltest;

/**
 * 总结一下在程序中final数据可以出现的位置
 * Created by wgh on 2020/12/25.
 */
public class FinalDemon {
    //final成员变量不可改变
    final int VALUE_ONE = 6;

    //在声明final成员时没有赋值，称为空白final，需要在构造中为其赋值
    final int BLANK_FINALVALUE;

    public FinalDemon(int blank_finalvalue) {
        //在构造方法中为空白final赋值
        BLANK_FINALVALUE = blank_finalvalue;
    }

    //设置final参数，不可以改变参数x的值
    int doIt(final int x) {
        return x + 1;
    }

    void doSomething() {
        //局部变量定义为final，不可以改变i的值
        final int i = 7;
    }

}
