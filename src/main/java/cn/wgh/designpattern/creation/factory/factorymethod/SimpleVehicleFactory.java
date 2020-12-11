package cn.wgh.designpattern.creation.factory.factorymethod;

/**
 * 简单工厂——扩展性并不好
 * Created by wgh on 2020/12/10.
 */
public class SimpleVehicleFactory {
    public Car creatCar(){
        System.out.println("SimpleVehicleFactory Creat Car");
        return new Car();
    }

    public Plane creatPlane(){
        System.out.println("SimpleVehicleFactory Creat Plane");
        return new Plane();
    }

    public Broom creatBroom(){
        System.out.println("SimpleVehicleFactory Creat Broom");
        return new Broom();
    }
}
