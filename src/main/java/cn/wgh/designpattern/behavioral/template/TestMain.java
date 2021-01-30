package cn.wgh.designpattern.behavioral.template;

import org.junit.Test;

/**
 * 模板方法模式也叫沟子函数
 * <p>
 * 其实我们经常都在用
 * <p>
 * Created by wgh on 2021/1/30.
 */
public class TestMain {

    @Test
    public void test1() throws Exception {
        F f = new C1();
        f.m();

        f = new C2();
        f.m();
    }
}
