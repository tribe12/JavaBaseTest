package cn.wgh.Maptest;

import org.junit.Test;

import java.util.*;

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
        while (keyIterator.hasNext()) {
            System.out.println(keyIterator.next());
        }

        Iterator valueIterator = treeMap.values().iterator();
        while (valueIterator.hasNext()) {
            System.out.println(valueIterator.next());
        }
    }

    @Test
    public void testName2() throws Exception {
        //创建TreeMap对象：
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        System.out.println("初始化后,TreeMap元素个数为：" + treeMap.size());

        //新增元素:
        treeMap.put("hello", 1);
        treeMap.put("world", 2);
        treeMap.put("my", 3);
        treeMap.put("name", 4);
        treeMap.put("is", 5);
        treeMap.put("jiaboyan", 6);
        treeMap.put("i", 6);
        treeMap.put("am", 6);
        treeMap.put("a", 6);
        treeMap.put("developer", 6);
        System.out.println("添加元素后,TreeMap元素个数为：" + treeMap.size());

        //遍历元素：
        Set<Map.Entry<String, Integer>> entrySet = treeMap.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("TreeMap元素的key:" + key + ",value:" + value);
        }

        //获取所有的key：
        Set<String> keySet = treeMap.keySet();
        for (String strKey : keySet) {
            System.out.println("TreeMap集合中的key:" + strKey);
        }

        //获取所有的value:
        Collection<Integer> valueList = treeMap.values();
        for (Integer intValue : valueList) {
            System.out.println("TreeMap集合中的value:" + intValue);
        }

        //获取元素：
        Integer getValue = treeMap.get("jiaboyan");//获取集合内元素key为"jiaboyan"的值
        String firstKey = treeMap.firstKey();//获取集合内第一个元素
        String lastKey = treeMap.lastKey();//获取集合内最后一个元素
        String lowerKey = treeMap.lowerKey("jiaboyan");//获取集合内的key小于"jiaboyan"的key
        String ceilingKey = treeMap.ceilingKey("jiaboyan");//获取集合内的key大于等于"jiaboyan"的key
        SortedMap<String, Integer> sortedMap = treeMap.subMap("a", "my");//获取集合的key从"a"到"jiaboyan"的元素

        //删除元素：
        Integer removeValue = treeMap.remove("jiaboyan");//删除集合中key为"jiaboyan"的元素
        treeMap.clear(); //清空集合元素：

        //判断方法：
        boolean isEmpty = treeMap.isEmpty();//判断集合是否为空
        boolean isContain = treeMap.containsKey("jiaboyan");//判断集合的key中是否包含"jiaboyan"

    }


}
