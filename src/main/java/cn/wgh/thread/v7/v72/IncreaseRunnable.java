package cn.wgh.thread.v7.v72;

/**
 * Created by wgh on 2021/4/12.
 */
public class IncreaseRunnable implements Runnable {

    Sharedata sharedata;

    public IncreaseRunnable(Sharedata sharedata) {
        this.sharedata = sharedata;
    }

    @Override
    public void run() {
        sharedata.increase();
    }
}
