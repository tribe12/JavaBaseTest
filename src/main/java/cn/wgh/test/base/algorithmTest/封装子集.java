package cn.wgh.test.base.algorithmTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import cn.wgh.test.base.algorithmTest.domain.Menu;

public class 封装子集 {

	public List<Menu> getMenuList() {
//		Menu menu1 = new Menu(1, 0, "查询1", null);
//		Menu menu2 = new Menu(2, 1, "查询2", null);
//		Menu menu3 = new Menu(3, 1, "查询3", null);
//		Menu menu4 = new Menu(4, 2, "查询4", null);
//		Menu menu5 = new Menu(5, 2, "查询5", null);
//		Menu menu6 = new Menu(6, 3, "查询6", null);
//		Menu menu7 = new Menu(7, 3, "查询7", null);
//		Menu menu8 = new Menu(8, 4, "查询8", null);
//		Menu menu9 = new Menu(9, 6, "查询9", null);
//		Menu menu10 = new Menu(10, 2, "查询10", null);
		
		Menu menu1 = new Menu(1, 0, "查询1");
		Menu menu2 = new Menu(2, 1, "查询2");
		Menu menu3 = new Menu(3, 1, "查询3");
		Menu menu4 = new Menu(4, 2, "查询4");
		Menu menu5 = new Menu(5, 2, "查询5");
		Menu menu6 = new Menu(6, 3, "查询6");
		Menu menu7 = new Menu(7, 3, "查询7");
		Menu menu8 = new Menu(8, 4, "查询8");
		Menu menu9 = new Menu(9, 6, "查询9");
		Menu menu10 = new Menu(10, 2, "查询10");
		
		
		List<Menu> list = new ArrayList<Menu>();
		list.add(menu1);
		list.add(menu2);
		list.add(menu3);
		list.add(menu4);
		list.add(menu5);
		list.add(menu6);
		list.add(menu7);
		list.add(menu8);
		list.add(menu9);
		list.add(menu10);
		return list;
	}

	@Test
	public void testName() throws Exception {
		List<Menu> list1 = getMenuList();

		List<Menu> newList = new ArrayList<Menu>();

		int empId = 0;
		for (int i = 0; i < list1.size(); i++) {
			if (i == 0) {
				empId = list1.get(i).getId();
			} else {
				if (empId > list1.get(i).getId()) {
					empId = list1.get(i).getId();
				}
			}
		}

		for (Menu menu : list1) {
			if (empId == menu.getId()) {
				newList.add(menu);
			}
		}

		System.out.println(empId);
		System.out.println(newList);

	}

	@Test
	public void testName2() throws Exception {
		List<Menu> list1 = getMenuList();
		
		String jsonString = JSON.toJSONString(list1);
		System.out.println(jsonString);
		
		
		int empId = 0;
		for (int j = 0; j < list1.size(); j++) {
			for (int i = 0; i < list1.size(); i++) {
				if (i == j) {
					empId = list1.get(i).getId();
				} else {
					if (empId == list1.get(i).getpId()) {
						List<Menu> children = list1.get(j).getChildren();
						children.add(list1.get(i));
					}
				}
			}
		}
		
		
		
//		System.out.println(list1);
		
		String jsonString2 = JSON.toJSONString(list1);
		System.out.println(jsonString2);
		
	/*	
			[
				(id=1, pId=0, name=查询1, children=[
													(id=2, pId=1, name=查询2, children=[
																						(id=4, pId=2, name=查询4, children=[(id=8, pId=4, name=查询8, children=[])]),
													 									(id=5, pId=2, name=查询5, children=[]), 
													 									(id=10, pId=2, name=查询10, children=[])
													 								]),
												    (id=3, pId=1, name=查询3, children=[
												    									(id=6, pId=3, name=查询6, children=[(id=9, pId=6, name=查询9, children=[])]),
												    									 (id=7, pId=3, name=查询7, children=[])
				])]),
				(id=2, pId=1, name=查询2, children=[ 
													(id=4, pId=2, name=查询4, children=[(id=8, pId=4, name=查询8, children=[])]),
													 (id=5, pId=2, name=查询5, children=[]), 
													 (id=10, pId=2, name=查询10, children=[])
													 ]), 
				(id=3, pId=1, name=查询3, children=[
													(id=6, pId=3, name=查询6, children=[(id=9, pId=6, name=查询9, children=[])]),
													(id=7, pId=3, name=查询7, children=[])
													]),
				(id=4, pId=2, name=查询4, children=[
													(id=8, pId=4, name=查询8, children=[])]), 
				(id=5, pId=2, name=查询5, children=[]), 
				(id=6, pId=3, name=查询6, children=[(id=9, pId=6, name=查询9, children=[])]), 
				(id=7, pId=3, name=查询7, children=[]), 
				(id=8, pId=4, name=查询8, children=[]), 
				(id=9, pId=6, name=查询9, children=[]), 
				(id=10, pId=2, name=查询10, children=[])
			]



		*/
		
		
	}

}
