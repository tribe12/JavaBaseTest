package cn.wgh.designpattern.behavioral.observer.v2;

/**
 * Created by wgh on 2020/12/19.
 */
public class Dog implements Observer {
    public void wang() {
        System.out.println("dog wanging ...");
    }
    public void wang2() {
        System.out.println("dog wanging2 ...");
    }

    @Override
    public void actionWake(WakeUpEvent wakeUpEvent)
    /*        if(...){
            wang();
        }else{
            wang2();
        }*/{
        wang();
    }
}
