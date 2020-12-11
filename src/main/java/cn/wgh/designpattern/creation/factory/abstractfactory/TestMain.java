package cn.wgh.designpattern.creation.factory.abstractfactory;

import org.junit.Test;

/**
 * Created by wgh on 2020/12/9.
 */
public class TestMain {

    @Test
    public void test1() throws Exception {
        AbstractFactory factory = new ModernFactory();
//        AbstractFactory factory = new MagicFactory();
        Food food = factory.creatFood();
        Vehicle vehicle = factory.creatVehicle();
        Weapon weapon = factory.creatWeapon();
        food.eat();
        vehicle.go();
        weapon.attack();
    }
}

