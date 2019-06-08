package cn.wgh.json;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.wgh.json.pojo.ApiRole;
import cn.wgh.json.pojo.Course;
import cn.wgh.json.pojo.ExtendUser;
import cn.wgh.json.pojo.OpManagerRoleMenu;
import cn.wgh.json.pojo.Student;
import cn.wgh.json.pojo.User;

public class AlibabaJsonTest2 {
	private SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Test
	public void map2pojo() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String id = "1231";
		String createTime;
		String groupId = "2";
		String name = "普通";
		String spId = "16121654545";
		String type = "2";
		String memberCount;
		
		map.put("id", id);
		map.put("groupId", groupId);
		map.put("name", name);
		map.put("spId", spId);
		map.put("type", type);
		map.put("age", 12);
		map.put("mun", "20170228");
		
		String str = JSONObject.toJSONString(map);
		System.out.println("str:"+str);
		
		ApiRole apiRole = JSON.parseObject(str, ApiRole.class);
		System.out.println(apiRole);
		
		apiRole.setCreateTime(dateFormate.format(new Date()));
		apiRole.setMemberCount("20");
		System.out.println(apiRole);
	}
	
	@Test
	public void map2pojo_() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Date birthDate = new Date();
		List<Course> courses= new ArrayList<Course>();
		Course course = new Course();
		course.setId(001);
		course.setName("数学");
		course.setTotalPoint("100");
		course.setGrade("92.5");
		course.setRemark("优");
		courses.add(course);
		
		
		int id = 213;
		String name = "小明";
		int age = 12;
		String remark = "努力啊";
		
		map.put("id", id);
		map.put("name", name);
		map.put("age", age);
		map.put("remark", remark);
		map.put("birthDate", birthDate);
		map.put("courses", courses);
		
		
		String str = JSONObject.toJSONString(map);
		System.out.println("str:"+str);
		Student student = JSON.parseObject(str, Student.class);
//		List<Student> studentlist = JSON.parseArray(str, Student.class);
		System.out.println(student);
		
		
		
		System.out.println("--------------");
//		System.out.println(studentlist);
	}
	
	
	
	@Test
	public void testName3() throws Exception {
		List<Object> list = new ArrayList<Object>();
		System.out.println(list);
	}
	
	@Test
	public void testName4() throws Exception {
		String str = "{\"managerRole\":{\"name\": \"testjs22\",\"remark\": \"备注信息\",\"adminIds\": [25,26]},\"managerMenu\": {\"managerMenuList\": [{\"menuId\": 10,\"allowUse\": 1,\"allowGrant\": 0}]}}";
		JSONObject jsonVo = JSON.parseObject(str);
		
		
		if(jsonVo.containsKey("managerRole")){
//			OpManagerRoleVo managerRoleVo = JSON.parseObject(jsonVo.getString("managerRole"), OpManagerRoleVo.class);
		}
		if (jsonVo.containsKey("managerMenu")) {
			JSONObject managerMenu = JSON.parseObject(jsonVo.getString("managerMenu"));
			if (managerMenu.containsKey("managerMenuList")) {
				List<OpManagerRoleMenu> managerMenuList = new ArrayList<OpManagerRoleMenu>();
				managerMenuList = JSON.parseArray(managerMenu.getString("managerMenuList"),
						OpManagerRoleMenu.class);
				if ( managerMenuList != null && !managerMenuList.isEmpty()) {
					for (OpManagerRoleMenu opManagerRoleMenu : managerMenuList) {
					}
				}
			}
		}
	}
	
	
	
	@Test
	public void extendPojoTest() throws Exception {
		String str = "{ \"name\": \"小明\",   \"number\": \"12\",    \"id\": 3}";
		ExtendUser extendUser = JSON.parseObject(str,ExtendUser.class);
		System.out.println(extendUser);
		System.out.println("id:"+extendUser.getId());
		System.out.println("name:"+extendUser.getName());
		System.out.println("number:"+extendUser.getNumber());
	}
	

	@Test
	public void userPojoTest() throws Exception {
		String str = "{ \"name\": \"小明\",   \"number\": \"12\",    \"id\": 3, \"abcNo\": \"1234abcdefg\", }";
		User user = JSON.parseObject(str,ExtendUser.class);
		System.out.println(user);
		System.out.println("id:"+user.getId());
		System.out.println("name:"+user.getName());
		
		JSONObject jsonObject = JSON.parseObject(str);
		String abcNo = jsonObject.getString("abcNo");
		System.out.println("abcNo:"+abcNo);
	}
	
	
}
