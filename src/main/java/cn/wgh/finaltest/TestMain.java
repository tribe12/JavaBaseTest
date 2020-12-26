package cn.wgh.finaltest;

import org.junit.Test;

/**
 * Created by wgh on 2020/12/23.
 */
public class TestMain {

    @Test
    public void finalDataTest() throws Exception {
        FinalData finalData = new FinalData();

        System.out.println(finalData);
        System.out.println(new FinalData());
        System.out.println(finalData.getVALUE_1());
        System.out.println(finalData.getValue2());
    }


    @Test
    public void finalMethodTest() throws Exception {
        Sub sub = new Sub();
        sub.doit();
        sub.doit2();
        sub.doit3();

        System.out.println("------------------------");
        Parents parents = sub;
        //不能调用private方法
//        parents.doit();
        parents.doit2();
        parents.doit3();
    }


    @Test
    public void finalClassTest() throws Exception {
        FinalClass finalClass = new FinalClass();
        //f.a++; //不允许
        System.out.println(finalClass.a);
        finalClass.doit(10);
    }
}
