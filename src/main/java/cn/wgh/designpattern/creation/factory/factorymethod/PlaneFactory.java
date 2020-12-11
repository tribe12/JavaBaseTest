package cn.wgh.designpattern.creation.factory.factorymethod;

/**
 * Created by wgh on 2020/12/10.
 */
public class PlaneFactory {
    public Moveable creat(){
        System.out.println("CarFactory Creat Plane");
        return new Plane();
    }
}
