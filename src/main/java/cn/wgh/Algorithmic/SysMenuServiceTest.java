package cn.wgh.Algorithmic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;

import cn.wgh.Algorithmic.domain.SysMenu;
import cn.wgh.Algorithmic.domain.SysMenuData;

public class SysMenuServiceTest  {

	@Test
	public void testName() throws Exception {
		List<SysMenuData> listAll = listAll2(null);
		
		System.out.println();
		System.out.println("======================================");
		System.out.println(listAll);
		System.out.println("结束");
	}
	
	public List<SysMenuData> listAll2(SysMenu menu) {
		List<SysMenuData> list = new ArrayList<SysMenuData>();
		List<SysMenu> menuDatas = getTestMenuDatas();
		if(menuDatas!=null && !menuDatas.isEmpty()){
//			Long baseId = 0l;
//			for (SysMenu sysMenu : menuDatas) {
//				if(0>sysMenu.getId()){
//					baseId = sysMenu.getId();
//				}
//			}
			Long basePid = menuDatas.get(0).getParentId();
			for (SysMenu sysMenu : menuDatas) {
				if(0>sysMenu.getId()){
					basePid = sysMenu.getParentId();
				}
			}
			
			List<Long> nextPids = new ArrayList<Long>();
			List<Long> addedIds = new ArrayList<Long>();
			for (int i = 0; i < menuDatas.size(); i++) {
				if (basePid == menuDatas.get(i).getParentId()) {
					list.add(sysMenuToSysMenuData(menuDatas.get(i)));
					nextPids.add(menuDatas.get(i).getId());
					addedIds.add(menuDatas.get(i).getId());
				}
			}
			
			for (int j = 0; j < menuDatas.size(); j++) {
				List<Long> newNextPids = new ArrayList<Long>();
				for (Long l = 0l; l < menuDatas.size(); l++) {
					if (!addedIds.contains(l) && nextPids.contains(menuDatas.get(l.intValue()).getParentId())) {
						
						int size = list.size()-1;
						
						SysMenuData sysMenuData = getDataById(list, menuDatas.get(l.intValue()).getParentId());
						
//						SysMenuData sysMenuData = list.get(size);
						packChildrenMenu(sysMenuData, sysMenuToSysMenuData(menuDatas.get(l.intValue())));
						addedIds.add(menuDatas.get(l.intValue()).getId());
						newNextPids.add(menuDatas.get(l.intValue()).getId());
					}
					if (l == (menuDatas.size() - 1)) {
						nextPids.clear();
						nextPids = newNextPids;
					}
				}
			}
		}
		
		return list;
	}
	
	
	
	private SysMenuData getDataById(List<SysMenuData> list, Long pId) {
		for (SysMenuData sysMenuData : list) {
			if(pId==sysMenuData.getId()){
				return sysMenuData;
			}else if(!sysMenuData.getChildren().isEmpty()){
				List<SysMenuData> children = sysMenuData.getChildren();
				SysMenuData dataById = getDataById(children,pId);
				if(dataById!=null){
					return dataById;
				};
			}
		}
		return null;
	}

	
	private List<SysMenu> getTestMenuDatas() {
		String str = 
				"[{"
				+"\"channelId\": 1,\"id\": 0,\"menuCode\": \"测试内容mzh7\",\"menuIcon\": 1,\"menuType\": 1,\"menuUrl\": 1,\"name\": \"某菜单\",\"parentId\": 0,\"platformType\": \"10\",\"privilegeId\": \"11\",\"status\": 1"
				+"},{"+"\"channelId\": 1,\"id\": 1,\"menuCode\": \"测试内容mzh7\",\"menuIcon\": 1,\"menuType\": 1,\"menuUrl\": 1,\"name\": \"某菜单\",\"parentId\": 0,\"platformType\": \"10\",\"privilegeId\": \"11\",\"status\": 1"
				+"},{"+"\"channelId\": 1,\"id\": 2,\"menuCode\": \"测试内容mzh7\",\"menuIcon\": 1,\"menuType\": 1,\"menuUrl\": 1,\"name\": \"某菜单\",\"parentId\": 0,\"platformType\": \"10\",\"privilegeId\": \"11\",\"status\": 1"
				+"},{"+"\"channelId\": 1,\"id\": 3,\"menuCode\": \"测试内容mzh7\",\"menuIcon\": 1,\"menuType\": 1,\"menuUrl\": 1,\"name\": \"某菜单\",\"parentId\": 1,\"platformType\": \"10\",\"privilegeId\": \"11\",\"status\": 1"
				+"},{"+"\"channelId\": 1,\"id\":4,\"menuCode\": \"测试内容mzh7\",\"menuIcon\": 1,\"menuType\": 1,\"menuUrl\": 1,\"name\": \"某菜单\",\"parentId\": 2,\"platformType\": \"10\",\"privilegeId\": \"11\",\"status\": 1"
				+"},{"+"\"channelId\": 1,\"id\": 5,\"menuCode\": \"测试内容mzh7\",\"menuIcon\": 1,\"menuType\": 1,\"menuUrl\": 1,\"name\": \"某菜单\",\"parentId\": 3,\"platformType\": \"10\",\"privilegeId\": \"11\",\"status\": 1"
				+"},{"+"\"channelId\": 1,\"id\": 6,\"menuCode\": \"测试内容mzh7\",\"menuIcon\": 1,\"menuType\": 1,\"menuUrl\": 1,\"name\": \"某菜单\",\"parentId\": 3,\"platformType\": \"10\",\"privilegeId\": \"11\",\"status\": 1"
				+"},{"+"\"channelId\": 1,\"id\": 7,\"menuCode\": \"测试内容mzh7\",\"menuIcon\": 1,\"menuType\": 1,\"menuUrl\": 1,\"name\": \"某菜单\",\"parentId\": 4,\"platformType\": \"10\",\"privilegeId\": \"11\",\"status\": 1"
				+"}]";
				;
				
				System.out.println("1=========");
				System.out.println(str);
				
				
				List<SysMenu> parseArray = JSONArray.parseArray(str, SysMenu.class);
				System.out.println("2=========");
				System.out.println(parseArray);
				
				
				
		return parseArray;
	}

	private SysMenuData sysMenuToSysMenuData(SysMenu sysMenu){
		SysMenuData sysMenuData = new SysMenuData();
		if(sysMenu!=null){
			Long id = sysMenu.getId();
			
			sysMenuData.setId(sysMenu.getId());
			sysMenuData.setChannelId(sysMenu.getChannelId());
			sysMenuData.setParentId(sysMenu.getParentId());
			sysMenuData.setName(sysMenu.getName());
			sysMenuData.setMenuUrl(sysMenu.getMenuUrl());
			sysMenuData.setServiceId(sysMenu.getServiceId());
			sysMenuData.setPrivilegeId(sysMenu.getPrivilegeId());
			sysMenuData.setPlatformType(sysMenu.getPlatformType());
			sysMenuData.setMenuType(sysMenu.getMenuType());
			sysMenuData.setMenuCode(sysMenu.getMenuCode());
			sysMenuData.setMenuIcon(sysMenu.getMenuIcon());
			sysMenuData.setUpdateTime(sysMenu.getUpdateTime());
			sysMenuData.setCreateTime(sysMenu.getCreateTime());
			sysMenuData.setStatus(sysMenu.getStatus());
		}
		return sysMenuData;
	}

	
	private void packChildrenMenu(SysMenuData menu,SysMenuData childrenMenu){
		List<SysMenuData> children = menu.getChildren();
		children.add(sysMenuToSysMenuData(sysMenuToSysMenuData(childrenMenu)));
		menu.setChildren(children);
	}
}
