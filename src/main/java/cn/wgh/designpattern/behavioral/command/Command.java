package cn.wgh.designpattern.behavioral.command;

/**
 * 命令
 * <p>
 * Created by wgh on 2021/1/26.
 */
public abstract class Command {

    /**
     * 执行
     */
    public abstract void doit();

    /**
     * 撤销
     */
    public abstract void undo();
}
