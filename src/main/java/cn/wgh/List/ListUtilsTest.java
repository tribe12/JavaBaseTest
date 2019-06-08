package cn.wgh.List;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.ListUtils;
import org.junit.Test;

public class ListUtilsTest {
	@Test
	public void testName() throws Exception	{
		
		List<Object> list1 = new ArrayList<Object>();
		list1.add("1");
		List<String> list2 = new ArrayList<String>();
		list2.add("1");
		boolean equalList = ListUtils.isEqualList(list1, list2);
		System.out.println(equalList);
	}
	
	@Test
	public void testName3() throws Exception {
		List<Object> list = new ArrayList<Object>();
		
		boolean contains = list.contains("1");
		System.out.println(contains);
		
		Map<String, List<Object>> listMap = new HashMap<String, List<Object>>();
		List<Object> list2 = listMap.get("1");
		List<Object> emptyIfNull1 = ListUtils.emptyIfNull(list);
		List<Object> emptyIfNull2 = ListUtils.emptyIfNull(list2);
		System.out.println(list);
		System.out.println(emptyIfNull1);
		System.out.println(list2);
		System.out.println(emptyIfNull2);
		
		
	}
	
	
	@Test
	public void testName4() throws Exception {
		List<Object> defaultList = new ArrayList<Object>();
		defaultList.add(1);
		
		List<Object> list = new ArrayList<Object>();
		Map<String, List<Object>> listMap = new HashMap<String, List<Object>>();
		List<Object> list2 = listMap.get("1");
		List<Object> defaultIfNull1 = ListUtils.defaultIfNull(list, defaultList);
		List<Object> defaultIfNull2 = ListUtils.defaultIfNull(list2, defaultList);
		System.out.println(list);
		System.out.println(defaultIfNull1);
		System.out.println(list2);
		System.out.println(defaultIfNull2);
	}
	
	
	@Test
	public void retainAllTest() throws Exception {
		List<Object> list1 = new ArrayList<Object>();
//		List<Object> list1 = null;
		list1.add("1");
		list1.add("3");
		list1.add("5");
		list1.add("4");
		list1.add("2");
//		list1.add("6");
		List<String> list2 = new ArrayList<String>();
//		List<String> list2 = null;
		list2.add("1");
		list2.add("2");
		list2.add("3");
		list2.add("4");
		list2.add("5");
//		list2.add("7");
//		list2.add("6");
//		list2.add("9");
//		list2.add("8");
//		list2.add("7");
//		
		boolean equalList = ListUtils.isEqualList(list1, list2);//必须顺序一样
		
		
		List<Object> retainAll = ListUtils.retainAll(list1, list2);
		
		System.out.println(retainAll);
		System.out.println(equalList);
		
		
	}
}
