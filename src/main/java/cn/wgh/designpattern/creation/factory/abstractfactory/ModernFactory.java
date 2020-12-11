package cn.wgh.designpattern.creation.factory.abstractfactory;

/**
 * 现代人工厂
 * Created by wgh on 2020/12/9.
 */
public class ModernFactory extends AbstractFactory {
    @Override
    Food creatFood() {
        System.out.println("--- new Bread ---");
        return new Bread();
    }

    @Override
    Vehicle creatVehicle() {
        System.out.println("--- new Car ---");
        return new Car();
    }

    @Override
    Weapon creatWeapon() {
        System.out.println("--- new AK47 ---");
        return new AK47();
    }
}
