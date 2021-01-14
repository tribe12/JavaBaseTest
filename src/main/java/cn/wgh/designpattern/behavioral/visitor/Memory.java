package cn.wgh.designpattern.behavioral.visitor;

/**
 * 内存
 * Created by wgh on 2021/1/6.
 */
public class Memory extends ComputerPart {
    @Override
    void accept(Visitor visitor) {
        visitor.visitMemory(this);
    }

    @Override
    double getPrice() {
        return 300;
    }
}
