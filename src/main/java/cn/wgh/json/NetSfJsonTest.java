package cn.wgh.json;

import org.junit.Test;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class NetSfJsonTest {
	@Test
	public void testName() throws Exception {
		String str =  "{\"id\":\"585203e39d6d8e72b41c68fe\",\"returnCode\":\"200\"}";
		
		
		JSONObject jsonObj = JSONObject.fromObject(str);
		
		int returnCode = jsonObj.optInt("returnCode");
		String id = jsonObj.getString("id");
		System.out.println("returnCode:"+returnCode);
		System.out.println("id:"+id);
		
	}

	@Test
	public void test1() throws Exception {
		String str = "[{\"cmgh\":\"1\",\"cldgbh\":\"1\",\"cptts\":\"1\",\"czkjg\":\"1\",\"csfsj\":\"1\",\"ccxjg\":\"1\",\"cbz\":\"1\"}]";

		JSONArray jsonArray = JSONArray.fromObject(str);

		System.out.println("jsonArray结果:" + jsonArray);
		
		String s = (String)jsonArray.get(2);
		
		System.out.println("s结果:" + s);
		
		
	}
}
