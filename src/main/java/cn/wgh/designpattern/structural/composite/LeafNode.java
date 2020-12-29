package cn.wgh.designpattern.structural.composite;

/**
 * Created by wgh on 2020/12/28.
 */
public class LeafNode extends Node {
    String content;

    public LeafNode(String content) {
        this.content = content;
    }

    @Override
    public void p() {
        System.out.println(content);
    }
}
