package cn.wgh.thread.v2;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器
 * Created by wgh on 2021/4/5.
 */
public class MainTest {
    public static void main(String[] args) {
        //一秒以后爆炸
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(LocalDateTime.now()+" 爆炸boom...");
            }
        },1000);

        //0.5秒以后爆炸，以后每2秒爆炸一次
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(LocalDateTime.now()+" ~爆炸boom~");
            }
        },500,2000);


        //3秒后爆炸，以后每0.5秒爆炸一次
        new Timer().schedule(new MyTimerTask(),3000);
    }
}
