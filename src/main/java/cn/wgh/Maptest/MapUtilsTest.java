package cn.wgh.Maptest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.junit.Test;

public class MapUtilsTest {
	@Test
	public void testName() throws Exception {
		HashMap<Object, Object> map1 = new  HashMap<>(); 
		map1.put("m1_1", "23");
//		map1.put("m1_1", null);
		System.out.println("map1______1:"+map1);
		Integer integer = MapUtils.getInteger(map1, "m1_1");
		System.out.println("map1______2:"+map1);
		System.out.println("integer:"+integer);
		
		
		
		Integer integer2 = MapUtils.getInteger(map1, "m1_1", 3);
		System.out.println("integer2:"+integer2);
		
		System.out.println("map1______1:"+map1);
		System.out.println("map1______2:"+map1);
	}
	
	
	@Test
	public void test2() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if(map==null){
			System.out.println("1111111111");
		}
		Map<String, Object> emptyIfNull = MapUtils.emptyIfNull(map);
		System.out.println("map:"+map);
		System.out.println("emptyIfNull:"+emptyIfNull);
		
		System.out.println("--------------------");
		Map<String, Map<String, Object>> mapMap = new HashMap<String, Map<String, Object>>();
		Map<String, Object> map2 = mapMap.get("1");
		boolean empty = MapUtils.isEmpty(map2);
		if(map2==null){
			System.out.println("map2==null");
		}
		System.out.println(empty);
		Map<String, Object> emptyIfNull2 = MapUtils.emptyIfNull(map2);
		System.out.println("map2:"+map2);
		System.out.println("emptyIfNull2:"+emptyIfNull2);
		System.out.println(MapUtils.isEmpty(emptyIfNull2));
		
		
	}
	
	@Test
	public void 判断为空() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean empty = MapUtils.isEmpty(map);
		System.out.println(empty);
		
		
		Map<String, Map<String, Object>> mapMap = new HashMap<String, Map<String, Object>>();
		Map<String, Object> map2 = mapMap.get("1");
		boolean empty2 = MapUtils.isEmpty(map2);
		System.out.println(empty2);
	}
	
	
	@Test
	public void test4() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("一", 1);
		String str = MapUtils.getString(map, "一");
		System.out.println(str);
	}
	
}
