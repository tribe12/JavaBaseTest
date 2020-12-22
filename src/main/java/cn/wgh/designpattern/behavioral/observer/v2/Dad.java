package cn.wgh.designpattern.behavioral.observer.v2;


/**
 * Created by wgh on 2020/12/19.
 */
public class Dad implements Observer {
    public void hug() {
        System.out.println("dad hugging ...");
    }

    public void hug2() {
        System.out.println("dad hugging2 ...");
    }

    @Override
    public void actionWake(WakeUpEvent wakeUpEvent) {

        /*  if(...){
            hug();
        }else{
            hug2();
        }*/
        hug();
    }
}
