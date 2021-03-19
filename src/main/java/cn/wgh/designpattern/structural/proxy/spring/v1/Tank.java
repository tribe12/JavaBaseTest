package cn.wgh.designpattern.structural.proxy.spring.v1;

import java.util.Random;

/**
 * Created by wgh on 2020/3/19.
 */
public class Tank  {
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
