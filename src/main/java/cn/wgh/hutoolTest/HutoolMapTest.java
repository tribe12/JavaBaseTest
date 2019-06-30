package cn.wgh.hutoolTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.hutool.core.map.MapUtil;

public class HutoolMapTest {
	@Test
	public void testName() throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		list=getData1();
		Map<String, List<Object>> listMap = MapUtil.toListMap(list);
		System.out.println(listMap);
		
		List<Map<String, Object>> mapList = MapUtil.toMapList(listMap);
		System.out.println(mapList);
	}


	/*
 		[
  			{a: 1, b: 1, c: 1}
  			{a: 2, b: 2}
  			{a: 3, b: 3}
  			{a: 4}
		]
	 */
	private List<Map<String, Object>> getData1() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("a", 1);
		map1.put("b", 1);
		map1.put("c", 1);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("a", 2);
		map2.put("b", 2);
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("a", 3);
		map3.put("b", 3);
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("a", 4);
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		
		return list;
	}
	
	
	
}
