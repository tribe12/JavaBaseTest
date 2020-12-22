package cn.wgh.designpattern.behavioral.observer.v2;

import org.junit.Test;

/**
 * Created by wgh on 2020/12/19.
 */
public class TestMain {
    @Test
    public void test() throws  Exception{
        Child child = new Child();
        //do sth
        WakeUpEvent wakeUpEvent = new WakeUpEvent(System.currentTimeMillis(),"bed");
        child.wakeUp(wakeUpEvent);
    }

}
