package cn.wgh.designpattern.creation.factory.abstractfactory;

/**
 * 魔法棒
 * Created by wgh on 2020/12/9.
 */
public class MagicStick extends Weapon {
    @Override
    void attack() {
        System.out.println("MagicStick * * * * * *");
    }
}
