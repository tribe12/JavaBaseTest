package cn.wgh.designpattern.structural.proxy.v1;

import org.junit.Test;

/**
 * Created by wgh on 2020/12/30.
 */
public class TestMain {

    /**
     * 最基础的静态代理
     * 通过代理，完成核心动作的同时完成自己想增加得步骤；
     * 各代理之间可以随意嵌套；
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        System.out.println("---------------------");
        new TankLogProxy(new TankTimeProxy(new Tank())).move();
        System.out.println("---------------------");
        new TankTimeProxy(new TankLogProxy(new Tank())).move();
    }
}
