package cn.wgh.designpattern.creation.factory.factorymethod;

import org.junit.Test;

/**
 * Created by wgh on 2020/12/10.
 */
public class TestMain {
    @Test
    public void test1() throws Exception {
/*        Moveable m = new Car();
//        Moveable m = new Plane();
//        Moveable m = new Broom();
*/
        Moveable m = new CarFactory().creat();
//        Moveable m = new PlaneFactory().creat();
//        Moveable m = new BroomFactory().creat();
        m.go();
    }
}
