package cn.wgh.designpattern.structural.proxy.v1;

/**
 * Tank行驶日志代理类
 * 最基础的静态代理
 * Created by wgh on 2020/12/30.
 */
public class TankLogProxy implements Movable {
    private Movable movable;

    TankLogProxy(Movable m) {
        this.movable = m;
    }

    @Override
    public void move() {
        System.out.println("Begin move");
        movable.move();
        System.out.println("End move");
    }


}
