package cn.wgh.designpattern.behavioral.observer.v3;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by wgh on 2020/12/21.
 */
public class MyActionListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        //do sth
        int id =e.getID();
        System.out.println("MyActionListener "+id);
    }
}
