package cn.wgh.hutoolTest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class HutoolJsonTest {
	@Test
	public void testName() throws Exception {
		String str = "{\"id\":1,\"name\":\"小明\"}";
		String formatJsonStr = JSONUtil.formatJsonStr(str);
		System.out.println(formatJsonStr);
		
		System.out.println("----------------------------");
		boolean isJson = JSONUtil.isJson(str);
		System.out.println("isJson:" + isJson);
		
		boolean isJsonArray = JSONUtil.isJsonArray(str);
		System.out.println("isJsonArray:" + isJsonArray);
		
		boolean isJsonObj = JSONUtil.isJsonObj(str);
		System.out.println("isJsonObj:" + isJsonObj);
		System.out.println("isJsonObj2:" + JSONUtil.isJsonObj(formatJsonStr));
		
		System.out.println("----------------------------");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 2);
		map.put("name", "旺财");
		map.put("phone", "123");
		
		JSONObject parseFromMap = JSONUtil.parseFromMap(map);
		System.out.println(parseFromMap);
		System.out.println("----------------------------");
		
		JSON parse = JSONUtil.parse(parseFromMap);
		System.out.println(parse);
		System.out.println(str);
		System.out.println(formatJsonStr);
	}
	
	@Test
	public void testName2() throws Exception {
	}
	
}
