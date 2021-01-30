package cn.wgh.designpattern.behavioral.state.v2;

import org.junit.Test;

/**
 * 状态模式
 * <p>
 * 状态模式适用于方法比较固定，状态变化较大，而方法根据状态而不同的情况。
 * Created by wgh on 2021/1/30.
 */
public class TestMain {
    @Test
    public void test1() throws Exception {
        MM mm = new MM("静香", new HappyMMState());
        mm.smile();
        mm.cry();
        mm.say();

        System.out.println("--------------");
        mm.mmState = new SadMMState();
        mm.smile();
        mm.cry();
        mm.say();
    }
}
