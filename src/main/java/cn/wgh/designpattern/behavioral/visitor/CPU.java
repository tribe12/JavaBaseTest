package cn.wgh.designpattern.behavioral.visitor;

/**
 * CPU
 * Created by wgh on 2021/1/6.
 */
public class CPU extends ComputerPart {
    @Override
    void accept(Visitor visitor) {
        visitor.visitCpu(this);
    }

    @Override
    double getPrice() {
        return 2000;
    }
}
