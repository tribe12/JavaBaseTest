package cn.wgh.designpattern.creation.factory.abstractfactory;

/**
 * 面包
 * Created by wgh on 2020/12/9.
 */
public class Bread extends Food {
    @Override
    void eat() {
        System.out.println("+++ eat Bread +++");
    }
}
