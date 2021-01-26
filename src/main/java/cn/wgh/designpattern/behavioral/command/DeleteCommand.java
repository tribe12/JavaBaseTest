package cn.wgh.designpattern.behavioral.command;

/**
 * 删除命令
 * <p>
 * Created by wgh on 2021/1/26.
 */
public class DeleteCommand extends Command {
    Content c;

    String deleteStr;

    int deleteCount;

    public DeleteCommand(Content c, int deleteCount) {
        this.c = c;
        this.deleteCount = deleteCount;
    }

    @Override
    public void doit() {
        if (this.deleteCount < 0) {
            deleteStr = "";
            return;
        }

        if (this.deleteCount > c.msg.length()) {
            this.deleteCount = c.msg.length();
        }

        deleteStr = c.msg.substring(c.msg.length() - deleteCount, c.msg.length());
        c.msg = c.msg.substring(0, c.msg.length() - deleteCount);
    }

    @Override
    public void undo() {
        c.msg += deleteStr;
    }
}
