package cn.wgh.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;

public class JsonTest {
	@Test
	public void testName() throws Exception {
		List<String> keyList = getKeyList();
		List<String> valueList = getValueList();
		String keyStr = JSONArray.toJSONString(keyList);
		String valueStr = JSONArray.toJSONString(valueList);
		System.out.println(keyStr);
		System.out.println(valueStr);
		
		JSONArray keyArray = JSONArray.parseArray(keyStr);
		JSONArray valueArray = JSONArray.parseArray(valueStr);
		
		
		int size = keyArray.size();

		Map<String, String> map = new HashMap<String, String>();
		
		for (int i = 0; i < size; i++) {
			map.put((String)keyArray.get(i), (String)valueArray.get(i));
		}
		System.out.println(map);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private List<String> getKeyList() {
		List<String> key = new ArrayList<String>();
		key.add("1");
		key.add("2");
		key.add("3");
		key.add("4");
		key.add("5");
		return key;
	}

	private List<String> getValueList() {
		List<String> value = new ArrayList<String>();
		value.add("一");
		value.add("二");
		value.add("三");
		value.add("四");
		value.add("五");
		return value;
	}
}
