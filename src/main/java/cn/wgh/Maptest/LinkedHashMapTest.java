package cn.wgh.Maptest;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: tribe
 * @time: 2023/4/16 23:29
 */
public class LinkedHashMapTest {
    /**
     * 插入顺序：先添加的在前面，后添加的在后面。修改操作不影响顺序
     * 默认情况下，LinkedHashMap是按照插入顺序的
     * 键是按照:“c”, “d”,"a"的顺序插入的，修改d不会修改顺序，但是会修改值
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        Map<String, Integer> seqMap = new LinkedHashMap<>();
        seqMap.put("c", 100);
        seqMap.put("d", 200);
        seqMap.put("a", 500);
        for (Map.Entry<String, Integer> entry : seqMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("---");
        seqMap.put("d", 300);
        for (Map.Entry<String, Integer> entry : seqMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    /**
     * 访问顺序：所谓访问指的是get/put操作，对一个键执行get/put操作后，其对应的键值对会移动到链表末尾，
     * 所以最末尾的是最近访问的，最开始的是最久没有被访问的，这就是访问顺序。
     * <p>
     * LinkedHashMap有5个构造方法，其中4个都是按插入顺序，只有一个是可以指定按访问顺序：
     * public LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)
     *
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        Map<String, Integer> accessMap = new LinkedHashMap<>(16, 0.75f, true);
//        Map<String, Integer> accessMap = new LinkedHashMap<>();
        accessMap.put("c", 100);
        accessMap.put("d", 200);
        accessMap.put("a", 500);
        for (Map.Entry<String, Integer> entry : accessMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("---");
//        accessMap.get("c");
        accessMap.put("d", 300);
        for (Map.Entry<String, Integer> entry : accessMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }


    /**
     * 使用按访问有序实现缓存
     * 在LinkedHashMap添加元素后，会调用removeEldestEntry防范，传递的参数时最久没有被访问的键值对，
     * 如果方法返回true，这个最久的键值对就会被删除。LinkedHashMap中的实现总返回false，该子类重写后即可实现对容量的控制
     */
    @Test
    public void test3() throws Exception {
        LRUCache<String, Object> cache = new LRUCache<>(3);
        cache.put("a", "abstract");
        cache.put("b", "basic");
        cache.put("c", "call");
        cache.get("a");
        cache.put("d", "滴滴滴");
        System.out.println(cache); // 输出为：{c=call, a=abstract, d=滴滴滴}
    }

    public class LRUCache<K, V> extends LinkedHashMap<K, V> {

        private int maxEntries;

        public LRUCache(int maxEntries) {
            super(16, 0.75f, true);
            this.maxEntries = maxEntries;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > maxEntries;
        }

    }


}
