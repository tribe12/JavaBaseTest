package cn.wgh.List;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @author guohui.wang
 *
 */
public class MyListUtils {
	
	/**
	 * 给list添加值,如有添加的值重复,不添加该值,保留较早的值
	 * @param list 需要添值得List
	 * @param element 添加的值
	 */
	public static <T> void addNotRepeat(List<T> list, T element) {
		if (!list.contains(element) || list.isEmpty()) {
			list.add(element);
		}
	}
	
	
	/**
	 * 检查List去掉所有重复元素
	 * 
	 * @param list  需要检查的List
	 */
	@SuppressWarnings("null")
	public static <T> void delRepeat1(List<? extends Object> list) {
		if (list != null || !list.isEmpty()) {
			List<Object> delList = new ArrayList<Object>();
			for (int i = 0; i < list.size(); i++) {
				boolean delFlag = false;
				for (int j = i + 1; j < list.size(); j++) {
					if ( list.get(i).equals(list.get(j))) {
						delFlag = true;
					}
				}
				if (delFlag) {
					delList.add(list.get(i));
				}
			}
			System.out.println("delList:" + delList);
			list.removeAll(delList);
		}
	}
	
	/**
	 * 检查List去掉的重复元素
	 * 
	 * 这两个方法最后效果一样，都是把所有重复的全部删掉了
	 * 
	 * @param list 需要检查的List
	 */
	@SuppressWarnings("null")
	public static <T> void delRepeat2(List<T> list) {
		if (list != null || !list.isEmpty()) {
			boolean delFlag = false;
			List<T> delList = new ArrayList<T>();
			List<T> empList = new ArrayList<T>();
			for (T t : list) {
				if (empList.isEmpty()) {
					empList.add(t);
				} else {
					boolean addEmp = false;
					for (T e : empList) {
						if (e.equals(t)) {
							delList.add(t);
							delFlag = true;
							break;
						} else {
							addEmp = true;
						}
					}
					if (addEmp) {
						empList.add(t);
					}
				}
			}
			System.out.println("delList:"+delList);
			if (delFlag) {
				list.removeAll(delList);
			}
		}
	}
	
	
	/**
	 * 以下是对自定义对象进行操作
	 */
	

	/**
	 * 给list添加对象,如有添加的对象重复,不添加该对象,保留较早的对象
	 * 
	 * @param list 需要添对象的List
	 * @param element 添加的对象
	 * @param fieldName 以此字段作为判断element是否重复的标准
	 * @throws IllegalAccessException 
	 * @throws Exception 
	 */
	public static <T> void addNotRepeatRetainOld(List<T> list, T element, String fieldName) throws Exception {
		if (list.isEmpty()) {
			list.add(element);
		} else {
			boolean addFlag = true;
			Class<T> clazz = (Class<T>) element.getClass();
			Field declaredField = clazz.getDeclaredField(fieldName);
			declaredField.setAccessible(true);
			Object fieldInstance = declaredField.get(element);

			for (T t : list) {
				Class<T> tclazz = (Class<T>) t.getClass();
				Field tField = tclazz.getDeclaredField(fieldName);
				tField.setAccessible(true);
				Object tfIns = tField.get(t);
				
				if (tfIns.equals(fieldInstance)) {
					addFlag = false;
				}
			}
			if(addFlag){
				list.add(element);
			}
		}
	}
	
	
	/**
	 * 给list添加对象,如有添加的对象重复,添加该对象,删除较早的对象
	 * 
	 * @param list 需要添对象的List
	 * @param element 添加的对象
	 * @param fieldName 以此字段作为判断element是否重复的标准
	 * @throws IllegalAccessException 
	 * @throws Exception 
	 */
	public static <T> void addNotRepeatRetainNew(List<T> list, T element, String fieldName) throws Exception {
		if (list.isEmpty()) {
			list.add(element);
		} else {
			boolean delFlag = false;
			List<T> delList = new ArrayList<T>();
			Class<T> clazz = (Class<T>) element.getClass();
			Field declaredField = clazz.getDeclaredField(fieldName);
			declaredField.setAccessible(true);
			Object fieldInstance = declaredField.get(element);

			for (T t : list) {
				Class<T> tclazz = (Class<T>) t.getClass();
				Field tField = tclazz.getDeclaredField(fieldName);
				tField.setAccessible(true);
				Object tfIns = tField.get(t);
				
				if (tfIns.equals(fieldInstance)) {
					delList.add(t);
					delFlag = true;
				}
			}
			if(delFlag){
				list.removeAll(delList);
			}
			list.add(element);
		}
	}
	
	
	
	/**
	 * 检查List去掉较新的重复元素,保留较老的元素
	 * 
	 * @param list 需要检查的List
	 * @param fieldName 以此字段作为判断元素是否重复的标准
	 * @throws Exception
	 */
	public static <T> void delRepeatRetainOld(List<T> list, String fieldName) throws Exception {
		if (list != null && !list.isEmpty()) {
			boolean delFlag = false;
			List<T> delList = new ArrayList<T>();
			List<Object> fieldList = new ArrayList<Object>();
			for (T t : list) {
				Class<T> tclazz = (Class<T>) t.getClass();
				Field tField = tclazz.getDeclaredField(fieldName);
				tField.setAccessible(true);
				Object tfIns = tField.get(t);
				if (fieldList.isEmpty()) {
					fieldList.add(tfIns);
				} else {
					boolean addField = false;
					for (Object field : fieldList) {
						if (field.equals(tfIns)) {
							delList.add(t);
							delFlag = true;
							break;
						} else {
							addField = true;
						}
					}
					if (addField) {
						fieldList.add(tfIns);
					}
				}
			}
			if (delFlag) {
				list.removeAll(delList);
			}
		}
	}

	/**
	 * 检查List去掉较老的重复元素,保留较新的元素
	 * 
	 * @param list 需要检查的List
	 * @param fieldName 以此字段作为判断元素是否重复的标准
	 * @throws Exception
	 */
	public static <T> void delRepeatRetainNew(List<T> list, String fieldName) throws Exception {
		if (list != null && !list.isEmpty()) {
			boolean delFlag = false;
			List<T> delList = new ArrayList<T>();
			List<Object> fieldList = new ArrayList<Object>();

			for (int i = list.size() - 1; i >= 0; i--) {
				Class<T> tclazz = (Class<T>) list.get(i).getClass();
				Field tField = tclazz.getDeclaredField(fieldName);
				tField.setAccessible(true);
				Object tfIns = tField.get(list.get(i));
				if (fieldList.isEmpty()) {
					fieldList.add(tfIns);
				} else {
					boolean addField = false;
					for (Object field : fieldList) {
						if (field.equals(tfIns)) {
							delList.add(list.get(i));
							delFlag = true;
							break;
						} else {
							addField = true;
						}
					}
					if (addField) {
						fieldList.add(tfIns);
					}
				}

			}
			if (delFlag) {
				list.removeAll(delList);
			}
		}
	}
	
	public static int getMax(List<Integer> list) throws Exception {
		int max = -1;
		if(list!=null && !list.isEmpty()){
			for (Integer i : list) {
				if(i>max){
					max = i;
				}
			}
		}
		return max;
	}
	

}
