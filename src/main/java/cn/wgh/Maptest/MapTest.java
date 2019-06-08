package cn.wgh.Maptest;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

import org.junit.Test;
//import org.apache.commons.collections.MapUtils;

public class MapTest {

	@Test
	public void test1() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(map.size());// 0
		System.out.println(map.isEmpty());// true
		System.out.println(map == null);// false
	}

	@Test
	public void testName1() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("一", 1);
		map.put("二", "");
		map.put("三", 3);
		map.put("四", null);
		map.put("五", 5);
		System.out.println("map:" + map);
		if (map.containsKey("一")) {
			System.out.println("------- 一  -------->" + map.get("一"));
		}
		if (map.containsKey("二")) {
			System.out.println("------- 二  -------->" + map.get("二"));
		}
		if (map.containsKey("四")) {
			System.out.println("------- 四  -------->" + map.get("四"));
		}
	}

	@Test
	public void testName2() throws Exception {
		int a = 0;
		int b = 5;
		int c = 1;
		int d = a = a % b > 0 ? a / b + 1 : a / b;
		for (int i = 0; i < d; i++) {
			System.out.println(i);
		}
	}

	@Test
	public void mapnull() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (map.isEmpty()) {
			System.out.println("map isEmpty()");
		} else {
			System.out.println("map ! isEmpty()");
		}

		Map<String, Map<String, Object>> mapMap = new HashMap<String, Map<String, Object>>();
		if (map.isEmpty()) {
			System.out.println("mapMap isEmpty()");
		} else {
			System.out.println("mapMap ! isEmpty()");
		}

		if (map == null) {
			System.out.println("map==null");
		}

		Map<String, Object> map2 = mapMap.get("1");
		// map2.isEmpty()//会报错，因为按该键取得的值并不存在，再用map的方法会报错。

		if (map2 == null) {
			System.out.println("map2==null");
		}
		// if(map2.equals(null)){
		// System.out.println("map2.equals(null)");
		// }

		Map<String, Object> map3 = new HashMap<String, Object>();
		map3 = mapMap.get("2");
		// map3.isEmpty();//先new一个map，再赋值还是会报错；

		if (map3 == null) {
			System.out.println("map3==null");
		}
		// if(map3.equals(null)){
		// System.out.println("map3.equals(null)");
		// }

	}

	@Test
	public void entrySet() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("一", 1);
		map.put("二", "");
		map.put("三", 3);
		map.put("四", null);
		map.put("五", 5);
		System.out.println("map:" + map);
		Set<Entry<String, Object>> entrySet = map.entrySet();
		System.out.println("entrySet:" + entrySet);
		for (Entry<String, Object> entry : entrySet) {
			System.out.println(entry);
		}

		System.out.println("------------------------");
		Set<String> keySet = map.keySet();
		System.out.println("keySet:" + keySet);
		Iterator<String> iterator = keySet.iterator();
		System.out.println("iterator:" + iterator);
		String next = iterator.next();
		System.out.println("next:" + next);

		Collection<Object> values = map.values();
		System.out.println("values:" + values);
		Iterator<Object> iterator2 = values.iterator();
		System.out.println("iterator2:" + iterator2);
		Object next2 = iterator2.next();
		System.out.println("next2:" + next2);

		System.out.println("------------------------");
		boolean containsKey = map.containsKey("一");
		System.out.println("containsKey:" + containsKey);

	}

	@Test
	public void mapmap() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", "101");
		Map<String, Object> map2 = new HashMap<String, Object>(map);
		map2.put("2", "202");
		System.out.println(map);
		System.out.println(map2);
	}

	@Test
	public void removeTest() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("一", 1);
		map.put("二", "");
		map.put("三", 3);
		map.put("四", null);
		map.put("五", 5);
		System.out.println(map);
		map.remove("三");
		System.out.println(map);
	}

	@Test
	public void testName() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Set keys = map.keySet();
		if (keys != null) {
			Iterator iterator = keys.iterator();
			while (iterator.hasNext()) {
				Object key = iterator.next();
				Object value = map.get(key);
			}
		}
		Set entries = map.entrySet();
		if (entries != null) {
			Iterator iterator = entries.iterator();
			while (iterator.hasNext()) {
				Map.Entry entry = (Entry) iterator.next();
				Object key = entry.getKey();
				Object value = entry.getValue();
			}
		}
	}

	@Test
	public void ffffffff() throws Exception {
		final Map<String, Object> map = new HashMap<String, Object>();

		System.out.println("map1:" + map);

		map.put("1", 1);
		map.put("2", "2");

		System.out.println("map2:" + map);

		map.put("1", "一");
		map.put("2", "二");

		System.out.println("map2:" + map);
	}

	@Test
	public void putgetTest() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("map:" + map);
		map.put("1", 1);
		map.put("2", "2");
		System.out.println(map.get("1"));
		System.out.println(map.get("2"));
		System.out.println(map.get("3"));
		
		System.out.println(map.containsKey("1"));
		System.out.println(map.containsKey("2"));
		System.out.println(map.containsKey("3"));
		
	}
	
	
	@Test
	public void mapmapmap() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("一", "");
		map.put("二", "");
		map.put("一", "1");
		map.put("二", "2");
		map.clear();
		System.out.println(map);
		map.put("一", "11");
		map.put("二", "22");
		map.put("一", "111");
		map.put("二", "222");
		map.put("一", "1111");
		map.put("二", "2222");
		map.put("一", "11111");
		map.put("二", "22222");
		System.out.println(map);
	}
	
	@Test
	public void testnull() throws Exception {
		Map<String, Object> map = null;
		map.put("一", "1");
		map.put("二", "");
		System.out.println(map);
	}
	
	
}
