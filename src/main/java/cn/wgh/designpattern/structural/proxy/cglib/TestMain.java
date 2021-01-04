package cn.wgh.designpattern.structural.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

/**
 * Created by wgh on 2021/1/4.
 */
public class TestMain {
    @Test
    public void test1() throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TimeMethodInterceptor());
        Tank tank = (Tank) enhancer.create();
        tank.move();
    }
}
