package cn.wgh.designpattern.behavioral.observer.v1;

/**
 * Created by wgh on 2020/12/19.
 */
public class Dog implements Observer {
    public void wang() {
        System.out.println("dog wanging ...");
    }

    @Override
    public void actionWake() {
        wang();
    }
}
