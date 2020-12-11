package cn.wgh.designpattern.creation.factory.abstractfactory;

/**
 * Created by wgh on 2020/12/9.
 */
public class MagicFactory extends AbstractFactory {
    @Override
    Food creatFood() {
        System.out.println("~~~ new MushRoom ~~~");
        return new MushRoom();
    }

    @Override
    Vehicle creatVehicle() {
        System.out.println("~~~ new Broom ~~~");
        return new Broom();
    }

    @Override
    Weapon creatWeapon() {
        System.out.println("~~~ new MagicStick ~~~");
        return new MagicStick();
    }
}
