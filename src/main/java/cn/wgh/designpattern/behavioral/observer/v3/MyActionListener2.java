package cn.wgh.designpattern.behavioral.observer.v3;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by wgh on 2020/12/21.
 */
public class MyActionListener2 implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        //do sth
        int modifiers = e.getModifiers();
        long when = e.getWhen();
        System.out.println("MyActionListener " + modifiers + "--" + when);
    }
}
