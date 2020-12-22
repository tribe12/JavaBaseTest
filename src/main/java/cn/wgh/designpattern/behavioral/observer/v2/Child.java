package cn.wgh.designpattern.behavioral.observer.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wgh on 2020/12/19.
 */
public class Child {
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }

    public boolean isCry() {
        return cry;
    }

    public void wakeUp(WakeUpEvent wakeUpEvent) {
        cry = true;
        for (Observer obs : observers) {
            obs.actionWake(wakeUpEvent);
        }
    }
}
