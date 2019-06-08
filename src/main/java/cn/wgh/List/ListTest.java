package cn.wgh.List;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.crypto.Data;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

public class ListTest {
	@Test
	public void test1() throws Exception {
		List<Object> list = new ArrayList<Object>();
		System.out.println(list.size());//0
		System.out.println(list.isEmpty());//true
		System.out.println(list == null);//false
	}
	
	@Test
	public void testName() throws Exception {
		List<Object> list = new ArrayList<>();
		list.add(12);
		list.add("哈哈");
		System.out.println(list);
		System.out.println(list.size());
	}
	@Test
	public void testName2() throws Exception {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		//list1==list2;不相等
		
		list1.add("1");
		list1.add("2");
		list1.add("3");
		list1.add("4");
		list2.add("2");
		list2.add("1");
		list2.add("3");
//		list2.add("4");
		System.err.println(list1);
		System.err.println(list2);

		if(list1.containsAll(list2)){
			System.err.println("相等-");
		}else {
			System.err.println("不相等-");
		}
		
		
		if(list1.size()==list2.size() && list1.containsAll(list2)){
			System.err.println("相等");
		}else {
			System.err.println("不相等");
		}
		
		
		if(list1.size()!=list2.size() || !list1.containsAll(list2)){
			System.err.println("不相等");
		}else {
			System.err.println("相等");
		}
	}
	
	
	@Test
	public void testremove() throws Exception {
		List<Object> list = new ArrayList<Object>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println("list:"+list);
		list.remove(0);
		System.out.println("list:"+list);
		list.remove(0);
		System.out.println("list:"+list);
		
	}
	
	
	/**
	 * 去掉List中的某个元素情况1方法一,前提是该List中元素不重复，删除第一次出现的
	 * @throws Exception
	 */
	@Test
	public void 去掉List中的某个元素情况1方法一() throws Exception {
		List<String> list = new ArrayList<String>();
		list.add("一");
		list.add("二");
		list.add("三");
		list.add("四");
		list.add("二");
		list.add("二");
		list.add("五");
		System.out.println("原始:"+list);
		boolean remove = list.remove("二");
		System.out.println("删除后:"+list);
		System.out.println("remove:"+remove);
		
	}
	
	/**
	 * 去掉List中的某个元素情况1方法二,前提是该List中元素不重复
	 * @throws Exception
	 */
	@Test
	public void 去掉List中的某个元素情况1方法二() throws Exception {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("1");
		list.add("1");
		list.add("1");
		list.add("1");
		System.out.println("原始:"+list);
		int deleteInt = 0;
		boolean deleteFlag = false;
		for (int i = 0; i < list.size(); i++) {
			if("1".equals(list.get(i))){
				deleteInt = i;
				deleteFlag = true;
			}
		}
		if(deleteFlag){
			list.remove(deleteInt);
		}
		System.out.println("删除后:"+list);
	}
	/**
	 * 去掉List中的某个元素情况2,允许该List中元素重复,方法一不能删除多个重复的
	 * @throws Exception
	 */
	@Test
	public void 去掉List中的某个元素情况2() throws Exception {
		
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("2");
		list.add("5");
		list.add("2");
		list.add("2");
		list.add("2");
		list.add("2");
		list.add("2");
		System.out.println("原始:"+list);
		int deleteInt = 0;
		for (int i = 0; i < list.size(); i++) {
			boolean deleteFlag = false;
			if("2".equals(list.get(i))){
				deleteInt = i;
				deleteFlag = true;
			}
			if(deleteFlag){
				list.remove(deleteInt);
			}
		}
		//方法一
		System.out.println("方法一删除后:"+list);
		//方法二
		
		List<String> list2 = new ArrayList<String>();
		list2.add("1");
		list2.add("2");
		list2.add("3");
		list2.add("2");
		list2.add("5");
		list2.add("2");
		list2.add("2");
		list2.add("2");
		list2.add("2");
		list2.add("2");
		List<Object> removeList = new ArrayList<Object>();
		removeList.add("2");
		list2.removeAll(removeList);
		System.out.println("方法二删除后:"+list2);
		
	}
	
	
	
	@Test
	public void test不一样就添加到新的List里____去掉List中的某个元素() throws Exception {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> listadd = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		list1.add("4");
		list1.add("1");
		list2.add("1");
		list2.add("3");
		list2.add("1");
		list2.add("1");
		list2.add("1");
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(listadd);
		System.out.println("-------------方法一----------------");
		for (String str1 : list1) {
			if (!list2.contains(str1)) {
				listadd.add(str1);
			}
		}
		System.out.println(listadd);
		
		System.out.println("-------------方法二----------------");
		List<String> removeAll = ListUtils.removeAll(list1, list2);
		System.out.println(removeAll);
		
		
		System.out.println("-------------方法三-只去掉1次---------------");
		List<String> subtract = ListUtils.subtract(list1, list2);
		System.out.println(subtract);
		
	}
	
	@Test
	public void 得到两个List的相同之处() throws Exception {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> listadd = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		list1.add("4");
		list1.add("1");
		list1.add("1");
		list1.add("1");
		list1.add("1");
		list2.add("3");
		list2.add("1");
		list2.add("5");
		System.out.println(list1);
		System.out.println(list2);
		System.out.println("---------方法一-不重复-------------------");
		//相同之处（交集）
		List<String> intersection = ListUtils.intersection(list1, list2);
		System.out.println(intersection);
		
		
		System.out.println("----------方法二-会重复------------------");
		List<String> retainAll = ListUtils.retainAll(list1, list2);
		System.out.println(retainAll);
		
		System.out.println("-------------方法三-顺序可以写反---------------");
		List<String> newList = ListUtils.longestCommonSubsequence(list2, list1);
		System.out.println(newList);
	}
	
	@Test
	public void 得到两个List的和() throws Exception {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> listadd = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		list1.add("4");
		list1.add("1");
		list1.add("1");
		list1.add("1");
		list1.add("1");
		list1.add("1");
		list2.add("1");
		list2.add("3");
		list2.add("5");
		list2.add("1");
		list2.add("1");
		list2.add("1");
		list2.add("1");
		System.out.println(list1);
		System.out.println(list2);
		System.out.println("-----------合并-去掉重复元素（去掉一次）-----------------");
		//把两个List合在一起去掉重复项
		List<String> sum = ListUtils.sum(list1, list2);
		System.out.println(sum);
		System.out.println("------------合并-所有元素都在----------------");
		//把两个List合在一起包含重复项（并集）
		List<String> union = ListUtils.union(list1, list2);
		System.out.println(union);
	}
	
	
	@Test
	public void 固定大小() throws Exception {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		list1.add("4");
		list1.add("1");
		System.out.println(list1);
		System.out.println(list2);
		System.out.println("-----------------");
		List<String> newList = ListUtils.fixedSizeList(list1);
//		List<String> newList = new ArrayList<String>();
		newList.add("6");//固定大小后操作会报错
//		newList.remove(0);//固定大小后操作会报错
//		newList.clear();//固定大小后操作会报错
		System.out.println(newList);
		
	}
	
	
	
	
	@Test
	public void 切割() throws Exception {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		list1.add("4");
		list1.add("1");
		System.out.println(list1);
		System.out.println("-----------------");

		List<List<String>> partition = ListUtils.partition(list1, 2);
		
		System.out.println(partition);
		
	}
	
	
	
	@Test
	public void testadd() throws Exception {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		list1.add("4");
		list1.add("1");
		list2.add("1");
		list2.add("2");
		list2.add("3");
		System.out.println(list1);
		System.out.println(list2);
		System.out.println("-----------------");
		list2.clear();
		System.out.println(list2);
		list2.add("6");
		System.out.println(list2);
		
	}
	
	@Test
	public void testMaxMin() throws Exception {
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1); 
		list1.add(2); 
		list1.add(3); 
		list1.add(4); 
		list1.add(4); 
		list1.add(4); 
		list1.add(1); 
		list1.add(1); 
		list1.add(1); 
		list1.add(1); 
		list1.add(4); 
		System.out.println("最大值:"+Collections.max(list1));
		System.out.println("最小值:"+Collections.min(list1));
	}
	
	
	@Test
	public void 越界错处() throws Exception {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < 1000; i++) {
			list.add("sh" + i);
		}

		for (int i = 0; list.iterator().hasNext(); i++) {
			list.remove(i);
			System.out.println("秘密" + list.get(i));
		}
	}
	
	
	@Test
	public void arraycopyTest() throws Exception {
		
		
		List<Object> list1 = new ArrayList<Object>();
		List<Object> list2 = new ArrayList<Object>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		list1.add("4");
		list1.add("5");
		list2.add("一");
		list2.add("二");
		list2.add("三");
		list2.add("四");
		list2.add("五");
		System.out.println(list1);
		System.out.println(list2);
        System.arraycopy(list1,2 , list2, 1, 2);  
        
        System.out.println("------------------------------------------");
        System.out.println(list1);
        System.out.println(list2);
	}
	
	@Test
	public void 如果为null就把自身变为空empty() throws Exception {
//		List<Object> list = new ArrayList<Object>();
		List<Object> list = null;
//		list
		System.out.println(list);
		list = new ArrayList<Object>();
		System.out.println(list);
		list.add("1");
		System.out.println(list);
		System.out.println("-------------------");
		List<Object> list2 = null;
		System.out.println(list2);
		
		list2 = new ArrayList(ListUtils.emptyIfNull(list2));
		
		
//		list2 = ListUtils.emptyIfNull(list2);
		System.out.println(list2);
		list2.add("2");//报错：java.lang.UnsupportedOperationException
		System.out.println(list2);
		
	}
	

	@Test
	public void 判断重复的就不添加() throws Exception {
//		List<Object> list = new ArrayList<Object>();
		List<Object> list = null;
		list = new ArrayList(ListUtils.emptyIfNull(list));
		MyListUtils.addNotRepeat(list, "1");
		MyListUtils.addNotRepeat(list, "1");
		MyListUtils.addNotRepeat(list, "1");
		MyListUtils.addNotRepeat(list, "2");
		MyListUtils.addNotRepeat(list, "1");
		MyListUtils.addNotRepeat(list, "1");
		MyListUtils.addNotRepeat(list, "3");
		MyListUtils.addNotRepeat(list, "1");
		
		System.out.println(list);
		
		
		List<User> list2 = new ArrayList<User>();
		User user1 = new User("1","小明",12,"15208141231");
		User user2 = new User("2","星星",13,"15208141232");
		User user3 = new User("3","旺财",5,"15208141233");
		User user4 = new User("4","旺财",5,"15208141232");
		User user5 =  new User("1","小明",12,"15208141231");
		User user6 = new User("6","旺财",5,"15208141236");
		MyListUtils.addNotRepeat(list2, user1);
		MyListUtils.addNotRepeat(list2, user2);
		MyListUtils.addNotRepeat(list2, user3);
		MyListUtils.addNotRepeat(list2, user4);
		MyListUtils.addNotRepeat(list2, user5);
		MyListUtils.addNotRepeat(list2, user6);
		MyListUtils.addNotRepeat(list2, user1);
		MyListUtils.addNotRepeat(list2, user1);
		MyListUtils.addNotRepeat(list2, user1);
		MyListUtils.addNotRepeat(list2, user1);
		MyListUtils.addNotRepeat(list2, user1);
		MyListUtils.addNotRepeat(list2, user2);
		MyListUtils.addNotRepeat(list2, user2);
		MyListUtils.addNotRepeat(list2, user2);
		System.out.println(list2.size());
		System.out.println(list2);
	}
	
	
	@Test
	public void 检查去掉较新的重复元素() throws Exception {
		List<User> list = new ArrayList<User>();
		User user1 = new User("1","小明",12,"15208141231");
		User user2 = new User("2","星星",13,"15208141232");
		User user3 = new User("3","旺财",5,"15208141233");
		User user4 = new User("4","旺财",5,"15208141232");
		User user5 = new User("5","旺财",5,"15208141235");
		User user6 = new User("6","旺财",5,"15208141236");
//		user
		
		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		list.add(user5);
		list.add(user6);
		System.out.println(list);
		System.out.println("-------------------");
		List<User> rem = new ArrayList<User>();
		List<Object> fieldNames = new ArrayList<Object>();
		for (User user : list) {
			String phone = user.getPhone();
			if(fieldNames.contains(phone)){
				rem.add(user);
			}else{
				fieldNames.add(phone);
			}
		}
		list.removeAll(rem);
		System.out.println(list);
	}
	
	
	@Test
	public void 给list添加对象_如有添加的对象重复_不添加该对象_保留较早的对象() throws Exception {
		List<User> list = new ArrayList<User>();
		User user1 = new User("1","小明",12,"15208141231");
		User user2 = new User("2","星星",13,"15208141232");
		User user3 = new User("3","旺财",5,"15208141233");
		User user4 = new User("4","旺财",5,"15208141232");
		User user5 = new User("5","旺财",5,"15208141235");
		User user6 = new User("6","旺财",5,"15208141236");
		
		MyListUtils.addNotRepeatRetainOld(list, user1, "phone");
		MyListUtils.addNotRepeatRetainOld(list, user2, "phone");
		MyListUtils.addNotRepeatRetainOld(list, user3, "phone");
		MyListUtils.addNotRepeatRetainOld(list, user4, "phone");
		MyListUtils.addNotRepeatRetainOld(list, user5, "phone");
		MyListUtils.addNotRepeatRetainOld(list, user6, "phone");
		
		System.out.println(list);
		
	}
	
	@Test
	public void 给list添加对象_如有添加的对象重复_添加该对象_删除较早的对象() throws Exception {
		List<User> list = new ArrayList<User>();
		User user1 = new User("1","小明",12,"15208141231");
		User user2 = new User("2","星星",13,"15208141232");
		User user3 = new User("3","旺财",5,"15208141233");
		User user4 = new User("4","旺财",5,"15208141232");
		User user5 = new User("5","旺财",5,"15208141235");
		User user6 = new User("6","旺财",5,"15208141232");
		
		MyListUtils.addNotRepeatRetainNew(list, user1, "phone");
		MyListUtils.addNotRepeatRetainNew(list, user2, "phone");
		MyListUtils.addNotRepeatRetainNew(list, user3, "phone");
		MyListUtils.addNotRepeatRetainNew(list, user4, "phone");
		MyListUtils.addNotRepeatRetainNew(list, user5, "phone");
		MyListUtils.addNotRepeatRetainNew(list, user6, "phone");
		
		System.out.println(list);
		
	}
	
	@Test
	public void 检查List去掉重复元素() throws Exception {
		List<String> list1 = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("2");
		list1.add("3");
		list1.add("4");
		list1.add("1");
		list1.add("1");
		list1.add("1");
		list1.add("2");
		list1.add("1");
		list1.add("1");
		list1.add("6");
		list1.add("6");
		
		System.out.println(list1);
//		MyListUtils.delAllRepeat(list1);
//		MyListUtils.delRepeat(list1);
		MyListUtils.delRepeat1(list1);
		MyListUtils.delRepeat2(list1);
		System.out.println(list1);
	}
	
	@Test
	public void 检查List去掉较新或较老的重复元素_保留较新或较老的元素() throws Exception {
		List<User> list = new ArrayList<User>();
		User user1 = new User("1","小明",12,"15208141231");
		User user2 = new User("2","星星",13,"15208142222");
		User user3 = new User("3","旺财",5,"15208141233");
		User user4 = new User("4","旺财",5,"15208142222");
		User user5 = new User("5","旺财",5,"15208141235");
		User user6 = new User("6","旺财",5,"15208142222");
		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		list.add(user5);
		list.add(user6);
		
		System.out.println(list);
		
		//检查List去掉较新的重复元素,保留较老的元素
//		MyListUtils.delRepeatRetainOld(list,"phone");
		
		//检查List去掉较老的重复元素,保留较新的元素
		MyListUtils.delRepeatRetainNew(list,"phone");
		
		System.out.println(list);
	}
	
	
	
	@Test
	public void 矩形数据() throws Exception {
		List<String> nameList = new ArrayList<String>();
		List<String> ageList = new ArrayList<String>();
		List<String> addList = new ArrayList<String>();
		List<String> gradeList = new ArrayList<String>();
		nameList.add("小A");
		nameList.add("小B");
		nameList.add("小C");
		nameList.add("小D");

		ageList.add("8");
		ageList.add("9");
		ageList.add("7");
		ageList.add("10");

		addList.add("建设路");
		addList.add("孵化园");
		addList.add("新鸿路");
		addList.add("世纪城");
		gradeList.add("90");
		gradeList.add("85");
		gradeList.add("87");
		gradeList.add("95");
		
		System.out.println(nameList);
		System.out.println(ageList);
		System.out.println(addList);
		System.out.println(gradeList);
		
		List<Integer> numlist = new ArrayList<Integer>();
		numlist.add(nameList.size());
		numlist.add(ageList.size());
		numlist.add(addList.size());
		numlist.add(gradeList.size());
		//列数
		int lineNum = numlist.size();
		//行数
//		int rowNum = NumberUtils.max(nameList.size(), ageList.size(), addList.size(),gradeList.size());
		int rowNum = MyListUtils.getMax(numlist);
		System.out.println("lineNum:"+lineNum);
		System.out.println("rowNum:"+rowNum);
		List<String> stu = new ArrayList<String>();
		List<List<String>> stuList = new ArrayList<List<String>>();
		for (int i = 0; i < lineNum; i++) {
			if(nameList.size()==i+1 && StringUtils.isEmpty(nameList.get(i))){
				stu.add("");
			}else{
				stu.add(nameList.get(i));
			}
		}
	}
	
	@Test
	public void DataaddListLen() throws Exception {
		Data[] data = new Data[5];
		for (Data data2 : data) {
			System.out.println(data2);
		}
	}
	
	
	
	
	
	@Test
	public void newnew() throws Exception {
		List<User> list = new ArrayList<User>();
		for (int i = 0; i < 1000; i++) {
			User user = new User(String.valueOf(i),"name",i,"phone");
			list.add(user);
		}
		System.out.println(list);
		
		List<User> list2 = new ArrayList<User>();
		User user2 = new User();
		for (int i = 0; i < 1000; i++) {
			user2.setId(String.valueOf(i));
			user2.setName("name");
			user2.setAge(i);
			user2.setPhone("phone");
			list2.add(user2);
		}
		System.out.println(list2);
	}
	
	
	
	@Test
	public void newnew2() throws Exception {
		List<User> list = new ArrayList<User>();
		for (int i = 0; i < 100000; i++) {
			List<User> list1 = new ArrayList<User>();
			User user = new User(String.valueOf(i),"name",i,"phone");
			list1.add(user);
			list.addAll(list1);
//			list1.clear();
//			list1 = null;
		}
		System.out.println(list.size());
		System.out.println(list);
	}
	
	
	
	@Test
	public void 取前6个() throws Exception {
		List<String> list1 = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		list1.add("4");
		list1.add("5");
		list1.add("6");
		list1.add("7");
		list1.add("8");
		list1.add("9");
		list1.add("10");
		System.out.println(list1);
		int size = list1.size();
		for (int i = size-1; i >= 6; i--) {
			list1.remove(i);
		}
		
		
		System.out.println(list1);
	}
	
	
	@Test
	public void 不同类型数字结构() throws Exception {
		List<Long> longList = new ArrayList<Long>();
		longList.add(0l);
		longList.add(1l);
		longList.add(2l);
		longList.add(3l);
		longList.add(4l);
		longList.add(5l);
		
		for (Long l : longList) {
			if(l==1){
				System.out.println("=========1=========");
				System.out.println("等于："+l);
			}
			
			int i = 1;
			if(l==i){
				System.out.println("=========2=========");
				System.out.println("等于："+l);
			}
			
			int j = 0;
			if(l==j){
				System.out.println("=========3=========");
				System.out.println("等于："+l);
			}
		}

		
		int i = 0;
		int j = 5;
		System.out.println("===4==="+longList.contains(0l));
		System.out.println("===5==="+longList.contains(i));
		System.out.println("===6==="+longList.contains(j));
		
		
		
		
		System.out.println("===4==="+longList.contains(0l));
		System.out.println("===5==="+longList.contains(i));
		System.out.println("===6==="+longList.contains(j));
		
	}

	@Test
	public void 对比空() throws Exception {
		List<Object> list1 = new ArrayList<Object>();
		List<Object> list2 = new ArrayList<Object>();
		List<Object> list3 = null;
		
		System.out.println(list1==list2);
		System.out.println(list1==list3);
		System.out.println("----------");
		System.out.println((list1==null || list1.isEmpty()) && (list1==null || list1.isEmpty()));
		System.out.println((list1==null || list1.isEmpty()) && (list3==null || list1.isEmpty()));
		
		System.out.println("----------");
		
		System.out.println(ListUtils.isEqualList(list1, list2));
		System.out.println(ListUtils.isEqualList(list1, list3));
		System.out.println("----------");
	}
	
	@Test
	public void 对比list() throws Exception {
		List<Object> list1 = new ArrayList<Object>();
		List<Object> list2 = new ArrayList<Object>();
		List<Object> list3 = new ArrayList<Object>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		
		list3.add(1);
		list3.add(3);
		list3.add(4);
		list3.add(2);
		System.out.println(ListUtils.isEqualList(list1, list2));
		System.out.println(ListUtils.isEqualList(list1, list3));
	}
	
	
	@Test
	public void testAddAll() throws Exception {
		List<Long> list = new ArrayList<Long>();
		List<Long> list1 = new ArrayList<Long>();
		List<Long> list2 = new ArrayList<Long>();
		List<Long> list3 = new ArrayList<Long>();
		List<Long> list4 = new ArrayList<Long>();
		
		list1.add(1l);
		list1.add(2l);
		list1.add(3l);
		
//		list2.add(1l);
//		list2.add(2l);
//		list2.add(3l);
		
		list2.add(2l);
		list2.add(3l);
		list2.add(4l);
		
		list3.add(5l);
		list3.add(6l);
		list3.add(7l);
		
		list.addAll(list1);
		System.out.println(list);
		
		boolean contains = list.containsAll(list2);
		System.out.println(contains);
		
		list.addAll(list2);
		System.out.println(list);
		list.addAll(list3);
		System.out.println(list);
		list.addAll(list4);
		System.out.println(list);
		
	}
	
	
	@Test
	public void ListUtilsADD() throws Exception {
		List<Long> list = new ArrayList<Long>();
		List<Long> list1 = new ArrayList<Long>();
		List<Long> list2 = new ArrayList<Long>();
		List<Long> list3 = new ArrayList<Long>();
		List<Long> list4 = new ArrayList<Long>();
		
		list1.add(1l);
		list1.add(2l);
		list1.add(3l);
		
		list2.add(2l);
		list2.add(3l);
		list2.add(4l);
		List<Long> union = ListUtils.union(list1, list2);
		List<Long> sum = ListUtils.sum(list1, list2);
		
		System.out.println(union);
		System.out.println(sum);
	}
	
	
	
}