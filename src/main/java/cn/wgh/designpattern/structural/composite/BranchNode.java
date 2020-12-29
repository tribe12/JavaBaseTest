package cn.wgh.designpattern.structural.composite;

import java.util.*;

/**
 * Created by wgh on 2020/12/28.
 */
public class BranchNode extends Node {
   public List<Node> nodes = new ArrayList<>();
    String name;

    public BranchNode(String name) {
        this.name = name;
    }

    public void add(Node node) {
        nodes.add(node);
    }

    @Override
    public void p() {
        System.out.println(name);
    }
}
