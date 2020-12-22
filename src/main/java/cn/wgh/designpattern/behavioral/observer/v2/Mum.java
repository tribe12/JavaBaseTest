package cn.wgh.designpattern.behavioral.observer.v2;

/**
 * Created by wgh on 2020/12/19.
 */
public class Mum implements Observer {
    public void feed() {
        System.out.println("mun feeding ...");
    }

    public void feed2() {
        System.out.println("mun feeding2 ...");
    }

    @Override
    public void actionWake(WakeUpEvent wakeUpEvent) {
/*        if(...){
            feed();
        }else{
            feed2();
        }*/
        feed();
    }
}
