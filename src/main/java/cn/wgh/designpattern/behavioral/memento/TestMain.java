package cn.wgh.designpattern.behavioral.memento;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录模式
 * <p>
 * 本例演示存盘、快照
 * <p>
 * 需要实现序列化接口
 * Created by wgh on 2021/1/30.
 */
public class TestMain {
    @Test
    public void test1() throws Exception {
        List<SchoolRecord> srs = new ArrayList<>();
        srs.add(new SchoolRecord("1997", "1999", "红星小学"));
        srs.add(new SchoolRecord("1999", "2001", "实验小学"));
        Person p1 = new Person(10, 100, "一环路", 20, srs, "F:\\test\\io\\person.data");

        p1.save();
        System.out.println(p1);

        System.out.println("改变");
        p1.age = 9;
        p1.score = 98;
        p1.loc.street = "三环路";
        p1.loc.roomNo = 131;
        List<SchoolRecord> srs2 = new ArrayList<>();
        srs2.add(new SchoolRecord("1998", "2000", "希望小学"));
        srs2.add(new SchoolRecord("2000", "2003", "第一中学"));
        p1.schoolRecords = srs2;
        System.out.println(p1);

        p1.load();
        System.out.println(p1);

    }


    @Test
    public void test2() throws Exception {
        List<SchoolRecord> srs = new ArrayList<>();
        srs.add(new SchoolRecord("1997", "1999", "红星小学"));
        srs.add(new SchoolRecord("1999", "2001", "实验小学"));
        Person p1 = new Person(10, 100, "一环路", 20, srs, "F:\\test\\io\\person.data");

        p1.savePart();
        System.out.println(p1);

        System.out.println("改变");
        List<SchoolRecord> srs2 = new ArrayList<>();
        srs2.add(new SchoolRecord("1998", "2000", "希望小学"));
        srs2.add(new SchoolRecord("2000", "2003", "第一中学"));
        p1.age = 9;
        p1.score = 98;
        p1.loc.street = "三环路";
        p1.loc.roomNo = 131;
        p1.schoolRecords = srs2;
        System.out.println(p1);

        p1.loadPart();
        System.out.println(p1);

    }
}
