package cn.wgh.designpattern.behavioral.observer.v3;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.util.List;
import java.awt.event.ActionListener;

/**
 * Created by wgh on 2020/12/21.
 */
public class MyFrame extends Frame {
    public void launch(List<ActionListener> actionListeners) {
        Button button = new Button("press me");
        if (actionListeners != null && !actionListeners.isEmpty()) {
            for (ActionListener actionListener : actionListeners
                    ) {
                button.addActionListener(actionListener);
            }
        }
        this.add(button);
        this.pack();
       // this.addWindowListener((WindowAdapter) windowClosing(e) -> {System.exit(0);});
        MyWindowListener myWindowListener = new MyWindowListener();
        this.addWindowListener(myWindowListener);
        this.setLocation(800,800);
        this.isVisible();
    }

}
