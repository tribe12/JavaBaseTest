package cn.wgh.designpattern.behavioral.command;

import org.junit.Test;

/**
 * Command命令模式
 *
 * 应用：
 *      宏命令：Command（命令模式）+ Composite（组合模式）
 *      多次undo：Command（命令模式）+ Chain of Responsibility（责任链模式）
 *      Transaction事务：Command（命令模式）+ Memento（备忘录模式）
 *
 * Created by wgh on 2021/1/26.
 */
public class TestMain {

    @Test
    public void test1() throws Exception {
        Content content = new Content("hello everyable ");
        System.out.println(content.msg);
        System.out.println("-----------------------");

        Command insert = new InsertCommand(content, "My name is XiaoMing");
        insert.doit();
        System.out.println(content.msg);
        insert.undo();
        System.out.println(content.msg);

        Command delete = new DeleteCommand(content, 5);
        delete.doit();
        System.out.println(content.msg);
        delete.undo();
        System.out.println(content.msg);

    }
}
