package cn.wgh.Maptest;

import org.junit.Test;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * Created by wgh on 2021/3/9.
 */
public class HashTableTest {

    @Test
    public void test1() throws Exception {
//        创建
        Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
//        添值
        ht.put(1, "Andy");
        ht.put(2, "Bill");
        ht.put(3, "Cindy");
        ht.put(4, "Dell");
        ht.put(5, "Felex");
        ht.put(6, "Edinburg");
        ht.put(7, "Green");
//        取值
        String str = ht.get(1);
        System.out.println(str);// Andy




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
            String value =(String) itv.next();
            System.out.println(value);
        }


//        取Hashtable记录数
        System.out.println("取Hashtable记录数:");
        int i = ht.size();
        System.out.println(i);// 7

//        删除元素
        System.out.println("删除元素:");
        ht.remove(1);
        ht.remove(3);

        System.out.println(ht.size());// 5

    }

}
