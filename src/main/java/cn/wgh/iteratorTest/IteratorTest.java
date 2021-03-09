package cn.wgh.iteratorTest;

import org.junit.Test;

import java.util.*;

public class IteratorTest {
    @Test
    public void testName() throws Exception {
        List<Object> list = new ArrayList<Object>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        Iterator<Object> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("------------------------------------------");
        System.out.println(iterator.hasNext());

        System.out.println(list);

        System.out.println("------------------------------------------");

        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            System.out.println(iter.next());
        }

        System.out.println("------------------------------------------");
        iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.remove();
        System.out.println(list);
    }


    @Test
    public void testHashMap() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("一", 1);
        map.put("二", "");
        map.put("三", 3);
        map.put(null, "kong key");
        map.put("四", null);
        map.put("五", 5);
        System.out.println("对键进行遍历:");
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            System.out.println(key);
        }


        //      对值进行遍历
        System.out.println("对值进行遍历:");
        Iterator itv = map.values().iterator();
        while (itv.hasNext()) {
            // Get value
            Object value = itv.next();
            System.out.println(value);
        }
    }


    @Test
    public void testHashtable() throws Exception {

        Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
//        添值
        ht.put(1, "Andy");
        ht.put(2, "Bill");
        ht.put(3, "");
        ht.put(4, "Dell");
        ht.put(5, "Felex");
        ht.put(6, "");
        ht.put(7, "Green");

        //      对键进行遍历
        System.out.println("对键进行遍历:");
        Iterator it = ht.keySet().iterator();
        while (it.hasNext()) {
            Integer key = (Integer) it.next();
            System.out.println(key);
        }

//      对值进行遍历
        System.out.println("对值进行遍历:");
        Iterator itv = ht.values().iterator();
        while (itv.hasNext()) {
            // Get value
            Object value = itv.next();
            System.out.println(value);
        }
    }
}
