package cn.wgh.designpattern.behavioral.state.v1;

/**
 * 如果状态会不断扩展，方法比较固定，那么每次状态改变，根据状态做出不同反应的方法里都有可能改动，比较麻烦。
 * 所以该方式不太适合。
 * <p>
 * 参见v2，我们使用状态模式，状态模式适用于方法比较固定，状态变化较大，而方法根据状态而不同的情况。
 * <p>
 * Created by wgh on 2021/1/30.
 */
public class MM {
    String name;
    MMState mmState;

    public MM(String name, MMState mmState) {
        this.name = name;
        this.mmState = mmState;
    }

    /**
     * 状态（有可能有很多种，并且不断扩展）
     */
    enum MMState { HAPPY, SAD }


    public void smile() {
        switch (mmState) {
            case HAPPY:
                System.out.println(name + "开心的笑");
            case SAD:
                System.out.println(name + "悲伤的笑");
        }
    }

    public void cry() {
        switch (mmState) {
            case HAPPY:
                System.out.println(name + "喜极而泣");
            case SAD:
                System.out.println(name + "嚎啕大哭");
        }
    }

    public void say() {
        switch (mmState) {
            case HAPPY:
                System.out.println(name + "好好说话");
            case SAD:
                System.out.println(name + "赶紧滚");
        }
    }
}
