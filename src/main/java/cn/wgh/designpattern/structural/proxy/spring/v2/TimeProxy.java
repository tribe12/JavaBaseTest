package cn.wgh.designpattern.structural.proxy.spring.v2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;



/**
 * Created by wgh on 2021/3/19.
 */
@Aspect
public class TimeProxy {
    @Before("execution(void cn.wgh.designpattern.structural.proxy.spring.v2.Tank.move())")
    public void before() {
        System.out.println("TimeProxy.method start" + System.currentTimeMillis());
    }

    @After("execution(void cn.wgh.designpattern.structural.proxy.spring.v2.Tank.move())")
    public void after() {
        System.out.println("TimeProxy.method stop" + System.currentTimeMillis());
    }
}
