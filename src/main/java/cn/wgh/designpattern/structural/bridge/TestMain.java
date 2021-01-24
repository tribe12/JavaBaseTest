package cn.wgh.designpattern.structural.bridge;

import org.junit.Test;

/**
 * Bridge桥接模式
 * <p>
 * 双维度扩展
 * 分离抽象与具体，让他们可以独自发展
 * 用聚合的方式（桥）连接抽象与具体
 * <p>
 * Created by wgh on 2021/1/23.
 */
public class TestMain {

    @Test
    public void test1() throws Exception {
        GG gg = new GG("旺财");
        MM mm = new MM("小美");
        Gift gift = new WarmGift(new Flower());

        gg.give(mm, gift);
        gg.give(mm, new ColdGift(new Book()));
    }
}
