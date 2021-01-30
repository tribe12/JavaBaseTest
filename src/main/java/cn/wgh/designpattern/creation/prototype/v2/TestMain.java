package cn.wgh.designpattern.creation.prototype.v2;

import org.junit.Test;

/**
 * 原型模式
 *
 * Created by wgh on 2021/1/30.
 */
public class TestMain {

    /**
     * 深克隆
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        Person p1 = new Person();
        Person p2 = (Person) p1.clone();

        System.out.println("p1:"+p1);
        System.out.println("p2:"+p2);

        System.out.println("p1 == p2 :"+ (p1 == p2));
        System.out.println("p1.age == p2.age :"+ (p1.age == p2.age));
        System.out.println("p1.score == p2.score :"+ (p1.score == p2.score));
        System.out.println("p1.loc == p2.loc :"+ (p1.loc == p2.loc));

        System.out.println("---------------------1");

        p1.loc.roomNo = 23;

        System.out.println("p1:"+p1);
        System.out.println("p2:"+p2);

        System.out.println("p1 == p2 :"+ (p1 == p2));
        System.out.println("p1.age == p2.age :"+ (p1.age == p2.age));
        System.out.println("p1.score == p2.score :"+ (p1.score == p2.score));
        System.out.println("p1.loc == p2.loc :"+ (p1.loc == p2.loc));

        System.out.println("---------------------2");
        p1.age = 9;
        p1.score = 99;
        p1.loc.street = "二环路";

        System.out.println("p1:"+p1);
        System.out.println("p2:"+p2);

        System.out.println("p1 == p2 :"+ (p1 == p2));
        System.out.println("p1.age == p2.age :"+ (p1.age == p2.age));
        System.out.println("p1.score == p2.score :"+ (p1.score == p2.score));
        System.out.println("p1.loc == p2.loc :"+ (p1.loc == p2.loc));

        System.out.println("---------------------3");
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

