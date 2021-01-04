package cn.wgh.designpattern.structural.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by wgh on 2021/1/4.
 */
public class TimeMethodInterceptor implements MethodInterceptor {
    /**
     * @param o           cglib动态生成代理类实例
     * @param method      为实体类所调用的被代理的方法引用
     * @param objects     方法参数列表
     * @param methodProxy 生成的代理类对方法的引用
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("TimeMethodInterceptor begin...");
        Object r = methodProxy.invokeSuper(o, objects);
        System.out.println("TimeMethodInterceptor end!");

        return r;
    }
}
