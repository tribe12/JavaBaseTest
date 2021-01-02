package cn.wgh.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wgh on 2021/1/2.
 */
public class TestMain {

    /**
     * 使用通配符声明的名称实例化对的对象不能对其加入新的信息，
     * 只能获取或删除。
     *
     * @throws Exception
     */
    @Test
    public void testName() throws Exception {
        //实例化一个ArrayList对象
        List<String> list1 = new ArrayList<String>();
        list1.add("No.1");
        //使用通配符
        List<?> list2 = list1;
        List<?> list3 = new LinkedList<Integer>();
        System.out.println(list2.get(0));

        list1.set(0, "New No.1");
        list1.add("No.2");
        //使用通配符的对象，调用set()方法，不能被调用；
        /*list2.set(0, "New other No.1");
        list3.set(0, 3);*/
        //也不能使用add()f方法；
        /*list2.add("No.2");
        list3.add(2);*/

        //使用通配符的对象，可以获取值和删除值
        list2.get(0);
        list3.get(0);
        list2.remove(0);

    }
}
