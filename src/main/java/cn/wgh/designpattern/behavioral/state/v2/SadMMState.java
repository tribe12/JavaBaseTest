package cn.wgh.designpattern.behavioral.state.v2;

/**
 * Created by wgh on 2021/1/30.
 */
public class SadMMState extends MMState {
    @Override
    void smile() {
        System.out.println("悲伤的笑");
    }

    @Override
    void cry() {
        System.out.println("嚎啕大哭");
    }

    @Override
    void say() {
        System.out.println("赶紧滚");
    }
}
