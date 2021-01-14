package cn.wgh.designpattern.behavioral.visitor;

/**
 * Created by wgh on 2021/1/6.
 */
public interface Visitor {
    void visitCpu(CPU cpu);

    void visitMemory(Memory memory);

    void visitBoard(Board board);
}
