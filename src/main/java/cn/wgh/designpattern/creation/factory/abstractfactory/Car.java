package cn.wgh.designpattern.creation.factory.abstractfactory;

/**
 * 汽车
 * Created by wgh on 2020/12/9.
 */
public class Car extends Vehicle {
    @Override
    void go() {
        System.out.println("Car go ...");
    }
}
