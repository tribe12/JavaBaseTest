package cn.wgh.designpattern.structural.proxy.v1;

import java.util.Random;

/**
 * Created by wgh on 2020/12/30.
 */
public class Tank implements Movable {
    @Override
    public void move() {
        System.out.println("Tank moving ....");
        try {
            // tank行驶花费时间
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
