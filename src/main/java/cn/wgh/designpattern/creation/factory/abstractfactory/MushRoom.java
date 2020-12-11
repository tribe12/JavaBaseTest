package cn.wgh.designpattern.creation.factory.abstractfactory;

/**
 * 蘑菇
 * Created by wgh on 2020/12/9.
 */
public class MushRoom extends Food {
    @Override
    void eat() {
        System.out.println("+++ eat MushRoom +++");
    }
}
