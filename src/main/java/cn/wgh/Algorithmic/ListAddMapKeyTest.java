package cn.wgh.Algorithmic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ListAddMapKeyTest {
	@Test
	public void testName() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "101");
		map.put("2", "202");
		map.put("3", "303");
		map.put("4", "404");
		map.put("5", "505");
		map.put("6", "606");
		map.put("7", "707");
		map.put("8", "808");
		
		List<String> list1 = new ArrayList<String>();
		list1.add("1"); 
		list1.add("2");
		list1.add("3");
		list1.add("4"); 
		list1.add("5"); 
		list1.add("6");
		list1.add("7");
		list1.add("8");
		
		List<String> list2 = new ArrayList<String>();
		list2.add("101"); 
		list2.add("202");
		list2.add("303");
		list2.add("404"); 
		list2.add("505"); 
		list2.add("606");
		list2.add("707");
		list2.add("808");
		
		
		List<String> syslist = new ArrayList<String>();
		syslist.add("1");
		syslist.add("2");
		syslist.add("3");
		syslist.add("5");
		
		System.out.println("list1:"+list1);
		System.out.println("list2:"+list2);
		System.out.println("syslist:"+syslist);
		System.out.println("----------------------------------------------");
		for (String num1 : list1) {
			for (String sys : syslist) {
				if(num1.equals(sys)){
					list2.remove(map.get(num1));
				}
			}
		}
		list1.removeAll(syslist);
		
		System.out.println("list1:"+list1);
		System.out.println("list2:"+list2);
		
	}
	
	
	
}
