package cn.wgh.designpattern.behavioral.state.v1;


import org.junit.Test;

/**
 * Created by wgh on 2021/1/30.
 */
public class TestMain {
    @Test
    public void test1() throws Exception {
        MM mm = new MM("静香", MM.MMState.HAPPY);
        mm.smile();
        mm.cry();
        mm.say();

        System.out.println("--------------");
        mm.mmState = MM.MMState.SAD;
        mm.smile();
        mm.cry();
        mm.say();
    }
}
