package cn.wgh.StringTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class EqualsTest {
	@Test
	public void testName1() throws Exception {
		String a = "a";
		String b = "a";
		System.out.println(a.equals(b));
		List<String> list = new ArrayList<String>();
		list.add(a);
		
		System.out.println(list.contains(a));
		System.out.println(list.contains(b));
		System.out.println(list.contains("a"));
	}
	
	
	@Test
	public void testName2() throws Exception {
		Set<String> hashSet = new java.util.HashSet<String>();
		String elem1 = "a";
		String elem2 = "a";
		System.out.println(elem1.equals(elem2));
		System.out.println(hashSet.add(elem1));
		System.out.println(hashSet.contains(elem2));    // returns false!</pre>
	}
	
}
