package cn.wgh.designpattern.behavioral.observer.v1;

/**
 * Created by wgh on 2020/12/19.
 */
public class Mum implements Observer {
    public void feed() {
        System.out.println("mun feeding ...");
    }

    @Override
    public void actionWake() {
        feed();
    }
}
