package cn.wgh.List;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;  
import java.util.List;

import org.junit.Test;  
  
/** 
 *  
 * 本类演示了Arrays类中的asList方法 
 * 通过四个段落来演示,体现出了该方法的相关特性. 
 *  
 * (1) 该方法对于基本数据类型的数组支持并不好,当数组是基本数据类型时不建议使用 
 * (2) 当使用asList()方法时，数组就和列表链接在一起了. 
 *     当更新其中之一时，另一个将自动获得更新。 
 *     注意:仅仅针对对象数组类型,基本数据类型数组不具备该特性 
 * (3) asList得到的数组是的没有add和remove方法的 
 *  
 * 阅读相关:通过查看Arrays类的源码可以知道,asList返回的List是Array中的实现的 
 * 内部类,而该类并没有定义add和remove方法.另外,为什么修改其中一个,另一个也自动 
 * 获得更新了,因为asList获得List实际引用的就是数组 
 */  
public class AsListTest {  
	@Test
	public void testName1() throws Exception {
        /* 段落一:基本数据类型使用asList中的问题 */  
  
        /* 说明:虽然在JDK1.6中能够将基本数据类型的数组转换成List,但还是有个缺陷 */  
        int[] a_int = { 1, 2, 3, 4 };  
        /* 预期输出应该是1,2,3,4,但实际上输出的仅仅是一个引用, 这里它把a_int当成了一个元素 */  
        List a_int_List = Arrays.asList(a_int);  
        foreach(a_int_List);  
        /* 为此我们需要这样遍历其中元素 */  
        foreachForBase(a_int_List);  
  
        /* 段落二:对象类型的数组使用asList,是我们预期的 */  
        Integer[] a_Integer = new Integer[] { 1, 2, 3, 4 };  
        List a_Integer_List = Arrays.asList(a_Integer);  
        foreach(a_Integer_List);  
  
        /* 段落三:当更新数组或者asList之后的List,另一个将自动获得更新 */  
        a_Integer_List.set(0, 0);  
        foreach(a_Integer_List);  
        foreach(a_Integer);  
  
        a_Integer[0] = 5;  
        foreach(a_Integer_List);  
        foreach(a_Integer);  
  
        /* 段落四:对基本类型数组,通过asList之后的List修改对应的值后,在运行时会报出异常  
         * 但是基本类型数组对应的List是会发生变化的,这是毫无疑问的 
         */  
          
        /* 
         * a_int_List.set(0, 0);  
         * foreach(a_int_List); foreach(a_int); 
         */  
  
        
        a_int[0] = 5;  
        foreachForBase(a_int_List);  
        foreach(a_int);  
  
    }  
  
    /* 打印方法 */  
    private static void foreach(List list) {  
        for (Object object : list) {  
            System.out.print(object + " ");  
        }  
        System.out.println();  
  
    }  
  
    private static void foreachForBase(List a_int_List) {  
        int[] _a_int = (int[]) a_int_List.get(0);  
        foreach(_a_int);  
    }  
  
    private static void foreach(int[] a_int) {  
        for (int i : a_int) {  
            System.out.print(i + " ");  
        }  
        System.out.println();  
    }  
  
    private static void foreach(Integer[] _a_Integer) {  
        for (int i : _a_Integer) {  
            System.out.print(i + " ");  
        }  
        System.out.println();  
    }  
    
  /***********************************************************************************************/  
    
    
    @Test
	public void testName2() throws Exception {
    	List<String> list = new ArrayList<String>();
    	list.add("张三");
    	list.add("李四");
    	list.remove(0);
    	list.add("王五");
    	System.out.println(list);
    	System.out.println(list.get(0));
		for (String str : list) {
			System.out.println(str);
		}
    	
		System.out.println("-----------------------------");
		
		List<String> asList = Arrays.asList("张三","李四");
//		asList.add("王五");
//		asList.remove(0);
		System.out.println(asList);
		System.out.println(asList.get(0));
		for (String str : asList) {
			System.out.println(str);
		}
		
		
		
	}
    
    @Test
	public void testName3() throws Exception {
    	Student student1 = new Student(1,"小明",18);
    	Student student2 = new Student(2,"旺财",3);
    	Student student3 = new Student(3,"张三",20);
    	Student student4 = new Student(4,"李四",21);
    	
		List<Student> asList = Arrays.asList(student1,student2);
//		asList得到的数组是的没有add和remove方法的 
//		asList.add(student3);//基本数据类型时不支持add和remove
//		asList.remove(0);//基本数据类型时不支持add和remove
		System.out.println(asList);
		System.out.println(asList.get(0));
		for (Student student : asList) {
			System.out.println(student);
		}
	}
    
    
    @Test
   	public void testName4() throws Exception {
    	List<Object> list = new ArrayList<>();
    	list.add("张三");
    	list.add("李四");
    	System.out.println(list);
    	List<List<Object>> asList = Arrays.asList(list);
    	System.out.println(list);
    	System.out.println(asList);
    }
    
    @Test
	public void testName() throws Exception {
		int o = 0;
		for (int t = 1; t <= 4; t++) {
			for (int u = 1; u <= 4; u++) {
				for (int i = 1; i <= 4; i++) {
					if (t != u && t != i && u != i) {
						o++;
						System.out.println("三位数：" + t + u + i);
					}
				}
			}
		}
		System.out.println("一共有" + o + "个");
	}
}  