package cn.wgh.designpattern.structural.bridge;

/**
 * Created by wgh on 2021/1/24.
 */
public class GG {
    String name;

    public GG(String name) {
        this.name = name;
    }

    public void give(MM mm, Gift gift) {
        System.out.println(this.name + "送" + gift + "给" + mm.name + "当做礼物");
    }
}
