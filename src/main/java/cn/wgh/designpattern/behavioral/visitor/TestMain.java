package cn.wgh.designpattern.behavioral.visitor;

import org.junit.Test;

/**
 * Visitor访问者模式：在结构不变饿情况下动态改变对于内部元素的动作
 * <p>
 * 注意：适合结构固定的
 * <p>
 * 多数用在开发编译器上
 * <p>
 * Created by wgh on 2021/1/9.
 */
public class TestMain {

    @Test
    public void test1() throws Exception {
        Computer computer = new Computer();
        StudentVisitor student = new StudentVisitor();
        PersonVisitor person = new PersonVisitor();
        CorpVisitor corp = new CorpVisitor();

        computer.accept(student);
        System.out.println("接待student后，student拿到的价格totalPrice: " + student.totalPrice + "元");
        computer.accept(person);
        System.out.println("接待person后，person拿到的价格totalPrice: " + person.totalPrice + "元");
        computer.accept(corp);
        System.out.println("接待corp后，corp拿到的价格totalPrice: " + corp.totalPrice + "元");
    }
}
