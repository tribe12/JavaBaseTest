package cn.wgh.designpattern.creation.factory.factorymethod;

/**
 * Created by wgh on 2020/12/10.
 */
public class Car implements Moveable{
    @Override
    public void go() {
        System.out.println("Car go ...");
    }
}
