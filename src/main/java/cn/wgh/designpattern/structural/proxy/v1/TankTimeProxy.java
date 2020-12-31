package cn.wgh.designpattern.structural.proxy.v1;

/**
 * 记录Tank行驶时间代理类
 * 最基础的静态代理
 * Created by wgh on 2020/12/30.
 */
public class TankTimeProxy implements Movable {
    private Movable movable;

    TankTimeProxy(Movable m) {
        this.movable = m;
    }

    @Override
    public void move() {
        long beginTime = System.currentTimeMillis();
        movable.move();
        long endTime = System.currentTimeMillis();
        System.out.println("move time:" + (endTime - beginTime) + "ms");
    }
}
