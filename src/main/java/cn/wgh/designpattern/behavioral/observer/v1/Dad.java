package cn.wgh.designpattern.behavioral.observer.v1;


/**
 * Created by wgh on 2020/12/19.
 */
public class Dad implements Observer {
    public void hug() {
        System.out.println("dad hugging ...");
    }

    @Override
    public void actionWake() {
        hug();
    }
}
