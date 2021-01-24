package cn.wgh.designpattern.structural.bridge;

/**
 * 礼物抽象类
 * Created by wgh on 2021/1/24.
 */
public abstract class Gift {
    String attribute;

    //聚合了一个GiftImpl的实现
    GiftImpl impl;


    @Override
    public String toString() {
        return attribute + impl.toString();
    }
}
