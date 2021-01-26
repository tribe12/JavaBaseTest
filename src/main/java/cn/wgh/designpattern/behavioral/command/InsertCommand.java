package cn.wgh.designpattern.behavioral.command;

/**
 * 添加命令
 * <p>
 * Created by wgh on 2021/1/26.
 */
public class InsertCommand extends Command {
    Content c;

    String insertStr;

    public InsertCommand(Content c, String insertStr) {
        this.c = c;
        this.insertStr = insertStr;
    }

    @Override
    public void doit() {
        c.msg += insertStr;
    }

    @Override
    public void undo() {
        c.msg = c.msg.substring(0, c.msg.length() - insertStr.length());
    }
}
