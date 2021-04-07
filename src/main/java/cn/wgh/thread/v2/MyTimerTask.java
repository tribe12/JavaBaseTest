package cn.wgh.thread.v2;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 子母弹
 * 爆炸后继续爆炸。。。
 * Created by wgh on 2021/4/5.
 */
public class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println(LocalDateTime.now()+" 爆炸boom!!!");
        new Timer().schedule(new MyTimerTask(), 1500);
    }
}
