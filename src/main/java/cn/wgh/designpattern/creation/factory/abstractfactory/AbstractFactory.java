package cn.wgh.designpattern.creation.factory.abstractfactory;

/**
 * 抽象工厂类
 * Created by wgh on 2020/12/9.
 */
public abstract class AbstractFactory {
    abstract Food creatFood();

    abstract Vehicle creatVehicle();

    abstract Weapon creatWeapon();
}
