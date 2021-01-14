package cn.wgh.designpattern.behavioral.visitor;

/**
 * 主板
 * Created by wgh on 2021/1/6.
 */
public class Board extends ComputerPart {
    @Override
    void accept(Visitor visitor) {
        visitor.visitBoard(this);
    }

    @Override
    double getPrice() {
        return 300;
    }
}
