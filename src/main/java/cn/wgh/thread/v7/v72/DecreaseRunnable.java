package cn.wgh.thread.v7.v72;

/**
 * Created by wgh on 2021/4/12.
 */
public class DecreaseRunnable implements Runnable {

    Sharedata sharedata;

    public DecreaseRunnable(Sharedata sharedata) {
        this.sharedata = sharedata;
    }

    @Override
    public void run() {
        sharedata.decrease();
    }
}
