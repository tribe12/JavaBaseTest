package cn.wgh.designpattern.creation.prototype.v1;

import cn.wgh.designpattern.creation.builder.*;
import org.junit.Test;

/**
 * 原型模式
 *
 * 实现原型模式需要实现标记型接口Cloneable
 * 一般会重写clone()方法（如果只是些clone()方法，而没有实现Cloneable接口，调用时会报异常）
 * 一般用于一个对象的属性已经确定，需要产生很多相同对象的时候
 * 需要区分浅克隆和深克隆
 *
 *
 * Created by wgh on 2021/1/30.
 */
public class TestMain {

    /**
     * 浅克隆
     * 里面的Location属于浅克隆
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        Person p1 = new Person();
        Person p2 = (Person)p1.clone();

        System.out.println("p1:"+p1);
        System.out.println("p2:"+p2);

        System.out.println("p1 == p2 :"+ (p1 == p2));
        System.out.println("p1.age == p2.age :"+ (p1.age == p2.age));
        System.out.println("p1.score == p2.score :"+ (p1.score == p2.score));
        System.out.println("p1.loc == p2.loc :"+ (p1.loc == p2.loc));

        System.out.println("----------------------1");

        p1.loc.roomNo = 23;

        System.out.println("p1:"+p1);
        System.out.println("p2:"+p2);

        System.out.println("p1 == p2 :"+ (p1 == p2));
        System.out.println("p1.age == p2.age :"+ (p1.age == p2.age));
        System.out.println("p1.score == p2.score :"+ (p1.score == p2.score));
        System.out.println("p1.loc == p2.loc :"+ (p1.loc == p2.loc));

        System.out.println("----------------------2");
        p1.age = 9;
        p1.score = 99;
        p1.loc.street = "二环路";

        System.out.println("p1:"+p1);
        System.out.println("p2:"+p2);

        System.out.println("p1 == p2 :"+ (p1 == p2));
        System.out.println("p1.age == p2.age :"+ (p1.age == p2.age));
        System.out.println("p1.score == p2.score :"+ (p1.score == p2.score));
        System.out.println("p1.loc == p2.loc :"+ (p1.loc == p2.loc));

        System.out.println("----------------------3");
        p2.age = 10;
        p2.score = 100;
        p2.loc.street = "三环路";

        System.out.println("p1:"+p1);
        System.out.println("p2:"+p2);

        System.out.println("p1 == p2 :"+ (p1 == p2));
        System.out.println("p1.age == p2.age :"+ (p1.age == p2.age));
        System.out.println("p1.score == p2.score :"+ (p1.score == p2.score));
        System.out.println("p1.loc == p2.loc :"+ (p1.loc == p2.loc));
    }
}

