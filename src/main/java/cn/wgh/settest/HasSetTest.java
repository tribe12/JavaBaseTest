package cn.wgh.settest;


import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * HashSet和HashMap的区别:
 * (1)HashSet实现了Set接口, 仅存储对象; HashMap实现了 Map接口, 存储的是键值对.
 * (2)HashSet底层其实是用HashMap实现存储的, HashSet封装了一系列HashMap的方法.
 * 依靠HashMap来存储元素值,(利用hashMap的key键进行存储), 而value值默认为Object对象.
 * 所以HashSet也不允许出现重复值, 判断标准和HashMap判断标准相同, 两个元素的hashCode相等并且通过equals()方法返回true.
 *
 *
 *
 * @author: tribe
 * @time: 2023/4/10 1:45
 */
public class HasSetTest {
    @Test
    public void test1() throws Exception {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("c");
        hashSet.add("b");
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("d");
        hashSet.add("3");
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("三");
        hashSet.add("一");
        hashSet.add("二");
        System.out.println(hashSet);//[一, a, 1, b, 2, c, 3, d, 三, 二]
        System.out.println(hashSet.size());//10
        for (String s : hashSet) {
            System.out.println(s);
        }

        HashMap<String, Object> hashMap = new HashMap<>();
        Object value = new Object();
        hashMap.put("c",value);
        hashMap.put("b",value);
        hashMap.put("a",value);
        hashMap.put("b",value);
        hashMap.put("d",value);
        System.out.println(hashMap);
    }

}
