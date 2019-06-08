package cn.wgh.List;


import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import net.sf.json.JSONArray;

public class JSON2ListTest {
	@Test
	public void net_sf_json_JSONArray() throws Exception {
		String s = "[\"64564545656\",\"adfasfasdfadf\"]";  
		s = null;  
		List<String> indList = JSONArray.fromObject(s);
		System.out.println(indList);
		System.out.println(indList==null);
		System.out.println(indList.isEmpty());
//		System.out.println(indList.get(0));
	}
	
	@Test
	public void alibaba_fastjson() throws Exception {
		String s = "[\"64564545656\",\"adfasfasdfadf\"]";  
		s = null;  
		
		com.alibaba.fastjson.JSONArray parseArray = com.alibaba.fastjson.JSONArray.parseArray(s);
		
		System.out.println(parseArray);
		System.out.println(parseArray==null);
		System.out.println(parseArray.isEmpty());
		System.out.println(parseArray.get(0));
		
		parseArray.add("123");
		
		for (Object sb : parseArray) {
			String ss = (String)sb;
			System.out.println(ss);
		}
	}
	
	
	@Test
	public void alibaba_fastjson2() throws Exception {
		String s = "[\"64564545656\",\"adfasfasdfadf\"]";  
		s = null;  
		
		List<String> list = com.alibaba.fastjson.JSONArray.parseArray(s, String.class);
		
		System.out.println(list);
		System.out.println(list==null);
		System.out.println(list.isEmpty());
		System.out.println(list.get(0));
		
		list.add("123");
		for (String string : list) {
			System.out.println(string);
		}
		
	}
	
}
