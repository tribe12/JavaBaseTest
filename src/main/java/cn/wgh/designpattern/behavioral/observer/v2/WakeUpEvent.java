package cn.wgh.designpattern.behavioral.observer.v2;

/**
 * Created by wgh on 2020/12/21.
 */
public class WakeUpEvent {
    long timestamp;
    String loc;

    public WakeUpEvent(long timestamp, String loc) {
        this.timestamp = timestamp;
        this.loc = loc;
    }
}
