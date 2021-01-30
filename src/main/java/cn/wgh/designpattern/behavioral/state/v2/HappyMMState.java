package cn.wgh.designpattern.behavioral.state.v2;

/**
 * Created by wgh on 2021/1/30.
 */
public class HappyMMState extends MMState {
    @Override
    void smile() {
        System.out.println("开心的笑");
    }

    @Override
    void cry() {
        System.out.println("喜极而泣");
    }

    @Override
    void say() {
        System.out.println("好好说话");
    }
}
