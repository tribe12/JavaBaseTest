package cn.wgh.designpattern.structural.bridge;

/**
 * 温暖的礼物
 *
 * Created by wgh on 2021/1/24.
 */
public class WarmGift extends Gift{
    public WarmGift(GiftImpl impl) {
        this.attribute = "温暖的";
        this.impl = impl;
    }
}
