package cn.wgh.json;

import java.util.ArrayList;
import java.util.List;

import javax.mail.Folder;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.wgh.json.pojo.RewardsPenalties;

public class ListMapTest {
	@Test
	public void testName1111() throws Exception {
		String roleList = "[{\"roleId\":\"1\",\"epRoleId\":\"101\"},{\"roleId\":\"2\",\"epRoleId\":\"202\"},{\"roleId\":\"3\",\"epRoleId\":\"\"}]";
//		roleList=null;
		System.out.println(roleList);
		roleList = StringUtils.replaceAll(roleList, "roleId", "id");
		System.out.println(roleList);
		List<SysRole> parseArray = new ArrayList<SysRole>();
				
		parseArray	= JSON.parseArray(roleList, SysRole.class);
		
		System.out.println(parseArray);
		
		
		
		
		List<SysRole> roles = JSON.parseArray(roleList, SysRole.class);
		if (roles != null && !roles.isEmpty()) {
			for (SysRole sysRole : roles) {
				if (StringUtils.isNotEmpty(sysRole.getId()) && StringUtils.isEmpty(sysRole.getEpRoleId())) {
					
					String epRoleId = sysRole.getId()+"0"+ sysRole.getId();
					List<SysRole> emps = new ArrayList<SysRole>();
					SysRole emp = new SysRole();
				
					emp.setId(sysRole.getId());
					emps.add(emp);
					
					
					parseArray.removeAll(emps);
//					parseArray.remove(sysRole);
					sysRole.setEpRoleId(epRoleId);
					System.out.println(parseArray);
				}
			}
		}
	}
	
	
	
	//可以去掉
	@Test
	public void removeAllPOJO() throws Exception {
		List<SysRole> list = new ArrayList<SysRole>();
		SysRole sysRole = new SysRole();
		sysRole.setId("1");
		sysRole.setEpRoleId("101");
		SysRole sysRole2 = new SysRole();
		sysRole2.setId("2");
		sysRole2.setEpRoleId("202");
		SysRole sysRole3 = new SysRole();
		sysRole3.setId("3");
		sysRole3.setId("303");
		
		list.add(sysRole);
		list.add(sysRole2);
		list.add(sysRole3);
		System.out.println(list);
		List<SysRole> rem = new ArrayList<SysRole>();
		rem.add(sysRole3);
		list.removeAll(rem);
		System.out.println(list);
	}
	
	//去不掉
	@Test
	public void removeAllPOJO2() throws Exception {
		List<SysRole> list = new ArrayList<SysRole>();
		SysRole sysRole = new SysRole();
		sysRole.setId("1");
		sysRole.setEpRoleId("101");
		SysRole sysRole2 = new SysRole();
		sysRole2.setId("2");
		sysRole2.setEpRoleId("202");
		SysRole sysRole3 = new SysRole();
		sysRole3.setId("3");
		sysRole3.setId("303");
		
		list.add(sysRole);
		list.add(sysRole2);
		list.add(sysRole3);
		System.out.println(list);
		
		
		List<SysRole> rem = new ArrayList<SysRole>();
		SysRole sysRole4 = new SysRole();
		sysRole4.setId(sysRole3.getId());
		sysRole4.setEpRoleId(sysRole3.getEpRoleId());
		rem.add(sysRole4);//去不掉
		list.removeAll(rem);
		System.out.println(list);
	}
	
	
	// 去不掉
	@Test
	public void removeAllPOJO3() throws Exception {
		List<SysRole> list = new ArrayList<SysRole>();
		SysRole sysRole = new SysRole();
		sysRole.setId("1");
//		sysRole.setId("101");
		SysRole sysRole2 = new SysRole();
		sysRole2.setId("2");
//		sysRole2.setId("202");
		SysRole sysRole3 = new SysRole();
		sysRole3.setId("3");
//		sysRole3.setId("303");

		list.add(sysRole);
		list.add(sysRole2);
		list.add(sysRole3);
		System.out.println(list);
		List<SysRole> emps = new ArrayList<SysRole>();
//		SysRole emp = new SysRole();
		for (SysRole role : list) {
			if (StringUtils.isNotEmpty(role.getId()) && StringUtils.isEmpty(role.getEpRoleId())) {
				String epRoleId = role.getId()+"0"+ role.getId();
				role.setEpRoleId(epRoleId);
				
				if("2".equals(role.getId())){
//					emp = role;
					emps.add(role);
				}
			}
		}
//		list.remove(emp);
		list.removeAll(emps);
		System.out.println(list);
	}
	
	
	
	@Test
	public void pojoListTest() throws Exception {
		String str ="[{\"rewardCompany\":\"奖励单位1\",\"reward\":\"荣誉1\",\"rewardLevel\":\"级别1\",\"rewardDate\":\"2017-08\",\"penaltyLevel\":\"惩处级别1\",\"penaltyCompany\":\"惩处单位1\",\"penaltyDate\":\"2017-07\"},{\"rewardCompany\":\"只有奖励\",\"reward\":\"荣誉2\",\"rewardLevel\":\"级别2\",\"rewardDate\":\"2017-04\",\"penaltyLevel\":\"\",\"penaltyCompany\":\"\",\"penaltyDate\":\"\"},{\"rewardCompany\":\"\",\"reward\":\"\",\"rewardLevel\":\"\",\"rewardDate\":\"\",\"penaltyLevel\":\"只有处罚级别2\",\"penaltyCompany\":\"处罚单位2\",\"penaltyDate\":\"2017-04\"}]";
		List<RewardsPenalties> res =  JSON.parseArray(str, RewardsPenalties.class);			
		System.out.println(res);
		
		List<RewardsPenalties> newRes = new ArrayList<RewardsPenalties>();
		for (RewardsPenalties re : res) {

			if ((StringUtils.isNotEmpty(re.getRewardCompany()) || StringUtils.isNotEmpty(re.getReward())
					|| StringUtils.isNotEmpty(re.getRewardLevel()) || StringUtils.isNotEmpty(re.getRewardDate()))
					&& (StringUtils.isNotEmpty(re.getPenaltyLevel()) || StringUtils.isNotEmpty(re.getPenaltyCompany())
							|| StringUtils.isNotEmpty(re.getPenaltyDate()))) {
				
				RewardsPenalties partRe = new RewardsPenalties();
				partRe.setRewardCompany(re.getRewardCompany());
				partRe.setReward(re.getReward());
				partRe.setRewardLevel(re.getRewardLevel());
				partRe.setRewardDate(re.getRewardDate());
				partRe.setPenaltyLevel("");
				partRe.setPenaltyCompany("");
				partRe.setPenaltyDate("");
				RewardsPenalties partPe = new RewardsPenalties();
				partPe.setRewardCompany("");
				partPe.setReward("");
				partPe.setRewardLevel("");
				partPe.setRewardDate("");
				partPe.setPenaltyLevel(re.getPenaltyLevel());
				partPe.setPenaltyCompany(re.getPenaltyCompany());
				partPe.setPenaltyDate(re.getPenaltyDate());
				newRes.add(partRe);
				newRes.add(partPe);
			}else{
				newRes.add(re);
			}
		}
		
		System.out.println("======================");
		res.clear();
		System.out.println(res);
		System.out.println(newRes);
		String newStr = JSON.toJSONString(newRes);
		System.out.println(newStr);
		
		
		
	}
	

}
