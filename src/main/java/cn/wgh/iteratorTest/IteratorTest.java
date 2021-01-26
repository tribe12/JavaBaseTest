package cn.wgh.iteratorTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class IteratorTest {
	@Test
	public void testName() throws Exception {
		List<Object> list = new ArrayList<Object>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		Iterator<Object> iterator = list.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("------------------------------------------");
		System.out.println(iterator.hasNext());
		
		System.out.println(list);
        
		System.out.println("------------------------------------------");

		for (Iterator iter = list.iterator(); iter.hasNext();) {
			System.out.println(iter.next());
		}
		
		System.out.println("------------------------------------------");
		 iterator = list.iterator();
	        iterator.next();
	        iterator.remove();
	        System.out.println(list);
	}
}
