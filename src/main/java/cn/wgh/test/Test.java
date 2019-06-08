package cn.wgh.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class Test {
	@org.junit.Test
	public void testName() throws Exception {
		boolean addFlag = true;
 		String name = "2";
		String mobile = "3";
		if(StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(mobile)){
			Map<String, Object> queryMap = new HashMap<String, Object>();
			queryMap.put("name", name);
			queryMap.put("mobile", mobile);
			String existId = "222";
			if(StringUtils.isNotEmpty(existId)){
				//修改
				addFlag = false;
				System.out.println("修改");
			}
		}
		
		if(addFlag){
			System.out.println("添加");
		}
	}
}
