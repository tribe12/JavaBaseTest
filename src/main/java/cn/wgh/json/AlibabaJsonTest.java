package cn.wgh.json;


import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.wgh.json.pojo.ApiRole;
import cn.wgh.json.pojo.Group;
import cn.wgh.json.pojo.User;
import cn.wgh.json.pojo.Variable;
import cn.wgh.json.pojo.Weibo;

/**
 * 下面是FastJson的简介：常用的方法！ Fastjson
 * API入口类是com.alibaba.fastjson.JSON，常用的序列化操作都可以在JSON类上的静态方法直接完成。
 * 
 * // 把JSON文本parse为JSONObject或者JSONArray 
 * public static final Object parse(String text);
 * 
 * // 把JSON文本parse成JSONObject 
 * public static final JSONObject parseObject(String text);
 * 
 * // 把JSON文本parse为JavaBean
 * public static final <T> T parseObject(String text,Class<T> clazz);
 * 
 * // 把JSON文本parse成JSONArray
 * public static final JSONArray parseArray(String text);
 * 
 * //把JSON文本parse成JavaBean集合
 * public static final <T> List<T> parseArray(String text, Class<T> clazz);
 * 
 * // 将JavaBean序列化为JSON文本 
 * public static final String toJSONString(Object object);
 * 
 * // 将JavaBean序列化为带格式的JSON文本 
 * public static final String toJSONString(Object object, boolean prettyFormat);
 * 
 * //将JavaBean转换为JSONObject或者JSONArray（和上面方法的区别是返回值是不一样的） 
 * public static final Object toJSON(Object javaObject);
 */
public class AlibabaJsonTest {
	/**
	 * 将Json文本数据信息转换为JsonObject对象，然后利用键值对的方式获取信息
	 */
	@Test
	public void json2JsonObjectM1() throws Exception {
		String str = "{\"name\":\"小明\"}";
//		JSONObject jsonObject = JSON.parseObject(str);
		JSONObject jsonObject = JSON.parseObject(str);
		Object object = jsonObject.get("name");
		String name = (String) jsonObject.get("name");
		System.out.println(object.getClass());// class java.lang.String
		System.out.println(name.getClass());// class java.lang.String
		System.out.println(object);// 小明
		System.out.println(name);// 小明
	}

	/**
	 * 将Json文本数据转换为JavaBean数据！
	 * 需要注意的是：这时候的Json文本信息中的键的名称必须和JavaBean中的字段名称一样！键中没有的在这个JavaBean中就显示为null！
	 */
	@Test
	public void json2BeanM2() throws Exception {
		String str = "{\"id\":1,\"name\":\"小明\"}";
		User user = JSONObject.parseObject(str, User.class);
		System.out.println(user.getId());// 1
		System.out.println(user.getName());// 小明

		String s = "{\"id\":\"028\",\"city\":\"成都\"}";
		Weibo weibo = JSONObject.parseObject(s, Weibo.class);
		System.out.println(weibo.getId());// 028
		System.out.println(weibo.getCity());// 成都
	}

	/**
	 * 将Map类型的数据转换为JsonString
	 */
	@Test
	public void complexMap2JsonM9() throws Exception {
		Group group = new Group();
		group.setId(1);
		group.setName("group");

		User user1 = new User();
		user1.setId(2);
		user1.setName("user1");
		User user2 = new User();
		user2.setId(3);
		user2.setName("user2");
		User user3 = new User();
		user3.setId(4);
		user3.setName("user3");

		group.getList().add(user1);
		group.getList().add(user2);

		Map<Integer, Object> map = new HashMap<Integer, Object>();
		map.put(1, "No.1");
		map.put(2, "No.2");
		map.put(5, group.getList());

		String jsonString = JSON.toJSONString(map);
		System.out.println(jsonString);
		// {1:"No.1",2:"No.2",5:[{"id":2,"name":"user1"},{"id":3,"name":"user2"}]}
	}

	/**
	 * 由一个复杂的Object到Json的Demo
	 */
	@Test
	public void complex2JsonM8() {
		Group group = new Group();
		group.setId(1);
		group.setName("group");

		User user1 = new User();
		user1.setId(2);
		user1.setName("user1");
		User user2 = new User();
		user2.setId(3);
		user2.setName("user2");

		group.getList().add(user1);
		group.getList().add(user2);

		String jsonString = JSON.toJSONString(group);
		System.out.println(jsonString);
		// {"id":1,"list":[{"id":2,"name":"user1"},{"id":3,"name":"user2"}],"name":"group"}
	}

	/**
	 * 一个相对复杂的例子： JSON文本数据： 首先是JSONObject，转换为JSONArray； 然后将JSONArray转换为JavaBean
	 */
	@Test
	public void complexExampleM7() {
		String s = "{js:[{id:\"110000\",\"city\":\"北#001京市\"},{id:\"110000\",\"city\":\"北#002京市\"}"
				+ ",{id:\"110000\",\"city\":\"北#002京市\"},{id:\"110000\",\"city\":\"北#002京市\"},"
				+ "{id:\"110000\",\"city\":\"#006北#005京市\"}," + "{id:\"110000\",\"city\":\"北#002京市\"},"
				+ "{id:\"110000\",\"city\":\"北#002京市\"},{id:\"120000\",\"city\":\"天#009津市\"}]}";
		JSONObject object = JSON.parseObject(s);
		Object jsonArray = object.get("js");
		System.out.println(jsonArray);//[{"city":"北#001京市","id":"110000"},{"city":"北#002京市","id":"110000"},{"city":"北#002京市","id":"110000"},{"city":"北#002京市","id":"110000"},{"city":"#006北#005京市","id":"110000"},{"city":"北#002京市","id":"110000"},{"city":"北#002京市","id":"110000"},{"city":"天#009津市","id":"120000"}]
		List<Weibo> list = JSON.parseArray(jsonArray + "", Weibo.class);
		for (Weibo weibo : list) {
			System.out.println(weibo.getCity());
		}
//		北#001京市
//		北#002京市
//		北#002京市
//		北#002京市
//		#006北#005京市
//		北#002京市
//		北#002京市
//		天#009津市
	}
	
	/** 
     * 将JavaBean转换为JSON对象 
     */  
	@Test
    public void bean2JSONObjectM6() {  
        Weibo weibo = new Weibo("0373", "洛阳");  
        JSONObject json = (JSONObject) JSON.toJSON(weibo); 
        System.out.println(json);//{"city":"洛阳","id":"0373"}
        System.out.println(json.get("id"));  //0373
    }  
	

    /** 
     * 将JSON文本转换为JavaBean的集合； 
     * 内部实现肯定是：首先转换为JSONArray，然后再转换为List集合 
     */  
	@Test
    public void json2JavaBeanM4() {  
        String s = "[{\"id\":\"0375\",\"city\":\"平顶山\"},{\"id\":\"0377\",\"city\":\"南阳\"}]";  
        List<Weibo> list = JSON.parseArray(s, Weibo.class);  
        for (Weibo weibo : list) {  
            System.out.println(weibo.getCity());  
        }  
//        平顶山
//        南阳
    }  
	
	
	 /** 
     * 将json数据转化为JSONArray: 
     * 注意：获取到JSONArray之后（我们这里只是获取到JSONArray而不是JavaBean的List集合） 
     * 获取JSONArray中的数据转换为String类型需要在外边加""; 
     */  
	@Test
    public void json2JSONArrayM3() {  
        String s = "[{\"id\":\"0375\",\"city\":\"平顶山\"},{\"id\":\"0377\",\"city\":\"南阳\"}]";  
        //将JSON文本转换为JSONArray  
        JSONArray array = JSON.parseArray(s);  
        System.out.println(array);//[{"city":"平顶山","id":"0375"},{"city":"南阳","id":"0377"}]
        System.out.println(array.get(0));//{"city":"平顶山","id":"0375"}  
        //这行必须写：必须加上+"";不然会报出类型强转异常！  $$$$$$$$$$$$$$$$重要$$$$$$$$$$$$$$$$
        String str = array.get(1)+"";
        System.out.println(str);//{"city":"南阳","id":"0377"}
        JSONObject object = JSON.parseObject(str);  
        System.out.println(object.get("id"));//0377  
        Weibo weibo = JSON.parseObject(str, Weibo.class);
        System.out.println(weibo.getCity());//南阳
    }  
     
	/** 
     * 将JavaBean转换为Json格式的数据/Json文本 
     * 用户数据的传递：例如上传服务器 
     */  
	@Test
    public void bean2JsonM5() {  
        Weibo weibo = new Weibo("123456", "上海");  
        String string = JSON.toJSONString(weibo);  
        System.out.println(string);  //{"city":"上海","id":"123456"} 
    }  
	
	@Test
    public void testName() {  
		 String json = "{'name': 'helloworlda','array':[{'a':'111','b':'222','c':'333'},{'a':'999'}],'address':'111','people':{'name':'happ','sex':'girl'}}";  
		 JSONObject jsonobj = JSONObject.parseObject(json);//将字符串转化成json对象   
		 String name=jsonobj.getString("name");//获取字符串。  
		 JSONArray array=jsonobj.getJSONArray("array");//获取数组  
		 JSONObject obj=jsonobj.getJSONObject("people");//获取对象  
		 System.out.println("jsonobj : "+jsonobj);  
		 System.out.println("获取字符串_nameStr: "+name);
		 System.out.println("获取数组_array: "+array);  
		 System.out.println("获取对象_obj: "+obj.getString("name"));  
	}  
	
	
	
	
	@Test
	public void 变量组() throws Exception {
		String str = "[{\"name\":\"num\",\"type\":\"string\",\"value\":\"编号132163456\",\"scope\":\"global\"},{\"name\":\"address\",\"type\":\"string\",\"value\":\"天府广场\",\"scope\":\"global\"},{\"name\":\"name\",\"type\":\"string\",\"value\":\"标题1\",\"scope\":\"global\"},{\"name\":\"employee\",\"type\":\"string\",\"value\":\"Kermit\",\"scope\":\"global\"},{\"name\":\"type\",\"type\":\"string\",\"value\":\"问题类型1\",\"scope\":\"global\"},{\"name\":\"explain\",\"type\":\"string\",\"value\":\"情况说明\",\"scope\":\"global\"}]";
		JSONArray array = JSON.parseArray(str); 
		int size = array.size();
		Map<String,Object> variableMap = new HashMap<String,Object>();
		for (int i = 0; i < size; i++) {
			Variable variable = JSON.parseObject(array.get(i)+"", Variable.class);
			variableMap.put(variable.getName(),variable.getValue());
	        System.out.println(variable.getName()+":"+variable.getValue());
		}
		
		System.out.println(variableMap);
		/*
		 * num:编号132163456 
		 * address:天府广场
		 * name:标题1 
		 * employee:Kermit 
		 * type:问题类型1
		 * explain:情况说明 {num=编号132163456, address=天府广场, name=标题1, explain=情况说明, type=问题类型1, employee=Kermit}
		 */
		
		
		/**
		 *   String s = "[{\"id\":\"0375\",\"city\":\"平顶山\"},{\"id\":\"0377\",\"city\":\"南阳\"}]";  
        //将JSON文本转换为JSONArray  
        JSONArray array = JSON.parseArray(s);  
        System.out.println(array);//[{"city":"平顶山","id":"0375"},{"city":"南阳","id":"0377"}]
        System.out.println(array.get(0));//{"city":"平顶山","id":"0375"}  
        //这行必须写：必须加上+"";不然会报出类型强转异常！  $$$$$$$$$$$$$$$$重要$$$$$$$$$$$$$$$$
        String str = array.get(1)+"";
        System.out.println(str);//{"city":"南阳","id":"0377"}
        JSONObject object = JSON.parseObject(str);  
        System.out.println(object.get("id"));//0377  
        Weibo weibo = JSON.parseObject(str, Weibo.class);
        System.out.println(weibo.getCity());//南阳
		 */
		
	}
	
	
	@Test
	public void testName200() throws Exception {
		String string = "{\"returnCode\":\"200\",\"list\":[{\"id\":\"17011111482390477382\",\"createTime\":\"2017-01-11 11:48:13\",\"groupId\":\"16121510054490530885\",\"name\":\"测试号test2\",\"spId\":\"16121310131890219167\",\"type\":\"1\",\"memberCount\":\"0\"},{\"id\":\"16121510085090531187\",\"createTime\":\"2016-12-15 10:08:50\",\"groupId\":\"16121510054490530885\",\"name\":\"客户经理\",\"spId\":\"16121310131890219167\",\"type\":\"2\",\"memberCount\":\"34\"},{\"id\":\"16121510090290531195\",\"createTime\":\"2016-12-15 10:09:03\",\"groupId\":\"16121510054490530885\",\"name\":\"支撑经理\",\"spId\":\"16121310131890219167\",\"type\":\"2\",\"memberCount\":\"12\"},{\"id\":\"16121510091490531203\",\"createTime\":\"2016-12-15 10:09:15\",\"groupId\":\"16121510054490530885\",\"name\":\"省产品经理\",\"spId\":\"16121310131890219167\",\"type\":\"2\",\"memberCount\":\"4\"},{\"id\":\"17011111374690477334\",\"createTime\":\"2017-01-11 11:37:36\",\"groupId\":\"16121510054490530885\",\"name\":\"系统测试\",\"spId\":\"16121310131890219167\",\"type\":\"2\",\"memberCount\":\"0\"},{\"id\":\"17011111380290477336\",\"createTime\":\"2017-01-11 11:37:52\",\"groupId\":\"16121510054490530885\",\"name\":\"系统测试2\",\"spId\":\"16121310131890219167\",\"type\":\"2\",\"memberCount\":\"0\"},{\"id\":\"17011111381790477338\",\"createTime\":\"2017-01-11 11:38:06\",\"groupId\":\"16121510054490530885\",\"name\":\"系统测试3\",\"spId\":\"16121310131890219167\",\"type\":\"2\",\"memberCount\":\"0\"},{\"id\":\"17011114051390478174\",\"createTime\":\"2017-01-11 14:05:14\",\"groupId\":\"16121510054490530885\",\"name\":\"测试角色_兼平台_Test\",\"spId\":\"16121310131890219167\",\"type\":\"2\",\"memberCount\":\"0\"}],\"dataCount\":8}";
		JSONObject jsonObject = JSONObject.parseObject(string);
		String  returnCode = jsonObject.getString("returnCode");
		if("200".equals(returnCode)){
			JSONArray jsonArray = jsonObject.getJSONArray("list");
			 List<ApiRole> apiRoleList = JSON.parseArray(jsonArray + "", ApiRole.class);
			 int i = 1;
			for (ApiRole apiRole : apiRoleList) {
				System.err.println(i++ +":"+apiRole);
			}
		}
		
	}
	
	
	
	@Test
	public void mapmap() throws Exception {
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> map2 = new HashMap<String, Object>();
		
		 map.put("1", 1);
		 map.put("2", 2);
		 map.put("3", 3);
		 map.put("4", 4);
		 map2.put("5", 5);
		 map2.put("6", 6);
		 map2.put("7", 7);
		 map2.put("8", 8);
		 
		 System.err.println(map);
		 System.err.println(map2);
		 map.putAll(map2);
		 System.err.println(map);
		 
		 
		
	}
	
	
	@Test
	public void testName222() throws Exception {
		String str = "[{\"cmgh\":\"1\",\"cldgbh\":\"1\",\"cptts\":\"1\",\"czkjg\":\"1\",\"csfsj\":\"1\",\"ccxjg\":\"1\",\"cbz\":\"1\"}]";
		
//		JSONArray array = JSON.parseArray(str);
//		System.out.println("array结果:"+array);
		 List<Datagrid> list = JSON.parseArray(str , Datagrid.class);
		
		System.out.println("list结果:"+list);
		
		Datagrid datagrid = list.get(0);
		System.out.println("------>"+datagrid.getCbz());
	}
	
	@Test
	public void testids() throws Exception {
		String idsJsonStr = 	"[{\"45155\"},{\"1545646\"},{\"23423\"}]";
		idsJsonStr = 	"[\"45155\",\"1545646\",\"23423\"]";
		List<String> ids = com.alibaba.fastjson.JSONArray.parseArray(idsJsonStr, String.class);
		System.out.println(ids);
	}
	
	
}
