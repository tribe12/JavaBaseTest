package cn.wgh.designpattern.behavioral.visitor;

/**
 * Created by wgh on 2021/1/6.
 */
public abstract class ComputerPart {
    abstract void accept(Visitor visitor);

    abstract double getPrice();
}
