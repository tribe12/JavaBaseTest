package cn.wgh.Algorithmic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.omg.CORBA.FREE_MEM;

public class 筛选本级和下级Test {
	@Test
	public void testName() throws Exception {
		Group group1 = new Group("1","","一级");
		Group group2 = new Group("2","","二级");
		Group group3 = new Group("3","","三级");
		Group group4 = new Group("4","","四级");
		Group group5 = new Group("5","","5级");
		Group group6 = new Group("6","","6级");
		Group group7 = new Group("7","","7级");
		Group group8 = new Group("8","","8级");
		Group group9 = new Group("9","","9级");
		Group group10 = new Group("3.1","2","3级1");
		Group group11 = new Group("3.2","2","3级2");
		Group group12 = new Group("4.1","3","4级1");
		Group group13 = new Group("4.2","3","4级2");
		
		List<Group> list = new ArrayList<Group>();
		list.add(group1);
		list.add(group2);
		list.add(group3);
		list.add(group4);
		list.add(group5);
		list.add(group6);
		list.add(group7);
		list.add(group8);
		list.add(group9);
		list.add(group10);
		list.add(group11);
		list.add(group12);
		list.add(group13);
		
		System.out.println("size:"+list.size());
		System.out.println(list);
		
		List<String> orderList = new ArrayList<String>();
//		orderList.add("");
		
		List<Group> newList = new ArrayList<Group>();
		List<Group> newList2 = new ArrayList<Group>();
		
		for (Group g : list) {
			if("3".equals(g.getId()) || "3".equals(g.getpId())){
				newList.add(g);
				if(newList!=null && !newList.isEmpty()){
					
					for (Group newg : newList) {
						if(g.getId().equals(newg.getId()) || g.getId().equals(newg.getpId())){
							newList2.add(g);
						}
					}
				}
			}
		}
		
		System.out.println("newList.size:"+newList.size());
		System.out.println("newList:"+newList);
		System.out.println("newList2:"+newList2);
		
		
	}
}
