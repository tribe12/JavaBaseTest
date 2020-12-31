package cn.wgh.designpattern.structural.proxy.v2;


import org.junit.Test;
import sun.misc.ProxyGenerator;


import java.lang.reflect.Proxy;

/**
 * Created by wgh on 2020/12/30.
 */
public class TestMain {

    /**
     * 利用JDK的动态代理
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        //将代理类生成出来保存至工程里，方便查看源码
//        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Movable movable = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class},
                new LogHander(new Tank())
        );
        movable.move();
    }
}
