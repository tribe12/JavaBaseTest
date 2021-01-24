package cn.wgh.designpattern.structural.bridge;

/**
 * 冷酷的礼物
 * <p>
 * Created by wgh on 2021/1/24.
 */
public class ColdGift extends Gift {
    public ColdGift(GiftImpl impl) {
        this.attribute = "冷酷的";
        this.impl = impl;
    }
}
