package cn.wgh.designpattern.structural.proxy.v2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by wgh on 2020/12/30.
 */
public class LogHander implements InvocationHandler {
    Tank tank;

    LogHander(Tank tank) {
        this.tank = tank;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method——" + method.getName() + " begin ...");
        Object o = method.invoke(tank, args);
        System.out.println("method——" + method.getName() + " end !");
        return o;
    }
}
