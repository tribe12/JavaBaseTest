package cn.wgh.designpattern.structural.proxy.spring.v1;

/**
 * Created by wgh on 2021/3/19.
 */
public class TimeProxy {
    public void before() {
        System.out.println("TimeProxy.method start" + System.currentTimeMillis());
    }

    public void after() {
        System.out.println("TimeProxy.method stop" + System.currentTimeMillis());
    }
}
