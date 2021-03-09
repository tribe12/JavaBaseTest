package cn.wgh.Maptest;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * Created by wgh on 2021/3/9.
 */
public class TreeMapTest {
    @Test
    public void testName() throws Exception {
        TreeMap treeMap = new TreeMap<>();
        treeMap.put(1, "一");
        treeMap.put(3, "三");
        treeMap.put(5, "五");
        treeMap.put(7, "七");
        treeMap.put(8, "八");
        treeMap.put(6, "六");
        treeMap.put(4, "四");
        treeMap.put(2, "二");
        Iterator keyIterator = treeMap.keySet().iterator();
        while (keyIterator.hasNext()){
            System.out.println(keyIterator.next());
        }

        Iterator valueIterator = treeMap.values().iterator();
        while (valueIterator.hasNext()){
            System.out.println(valueIterator.next());
        }
    }
}
