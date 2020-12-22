package cn.wgh.designpattern.behavioral.observer.v3;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;


/**
 * Created by wgh on 2020/12/21.
 */
public class TestMain {
    @Test
    public void test() throws Exception {
        ArrayList<ActionListener> myActionListeners = new ArrayList<>();
        myActionListeners.add(new MyActionListener());
        myActionListeners.add(new MyActionListener2());

        MyFrame myFrame = new MyFrame();
        myFrame.launch(myActionListeners);

    }
}
