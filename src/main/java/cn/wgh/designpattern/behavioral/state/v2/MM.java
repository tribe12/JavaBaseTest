package cn.wgh.designpattern.behavioral.state.v2;

/**
 * Created by wgh on 2021/1/30.
 */
public class MM {
    String name;
    MMState mmState;

    public MM(String name, MMState mmState) {
        this.name = name;
        this.mmState = mmState;
    }

    public void smile() {
        System.out.print(name);
        mmState.smile();
    }

    public void cry() {
        System.out.print(name);
        mmState.cry();
    }

    public void say() {
        System.out.print(name);
        mmState.say();
    }
}
