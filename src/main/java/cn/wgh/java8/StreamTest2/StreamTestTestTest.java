package cn.wgh.java8.StreamTest2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamTestTestTest {
	@Test
	public void count() throws Exception {
		List<Integer> list = Arrays.asList(1,2,null,4,null,6);
		Stream<Integer> filter = list.stream().filter(num -> num!=null);
		System.out.println("notNullCount:"+filter.count());
	}
	
	@Test
	public void distinct() throws Exception {
		List<Integer> list = Arrays.asList(1,2,null,4,null,6,1,2,null,4,null,6);
		Stream<Integer> filter = list.stream().filter(num -> num!=null);
		Stream<Integer> distinct = filter.distinct();
		System.out.println("distinct:"+distinct.count());
	}
	
	@Test
	public void limit() throws Exception {
		List<Integer> list = Arrays.asList(1,2,null,4,null,6,1,2,null,4,null,6);
		Stream<Integer> limit = list.stream().filter(num -> num!=null).limit(5);
		Object[] array = limit.toArray();
		for (Object i : array) {
			System.out.println("i:"+i);
		}
	}
	
	@Test
	public void toArray() throws Exception {
		List<Integer> list = Arrays.asList(1,2,null,4,null,6,1,2,null,4,null,6);
		Stream<Integer> filter = list.stream().filter(num -> num!=null);
		Object[] array = filter.toArray();
		for (Object i : array) {
			System.out.println("i:"+i);
		}
	}
	
	@Test
	public void sorted() throws Exception {
		List<Integer> list = Arrays.asList(1,2,null,4,null,6,1,2,null,4,null,6);
		Stream<Integer> filter = list.stream().filter(num -> num!=null);
		Stream<Integer> sorted = filter.sorted();
		Object[] array = sorted.toArray();
		for (Object object : array) {
			System.out.println("object:"+object);
		}
	}
	
	
	@Test
	public void skip() throws Exception {
		List<Integer> list = Arrays.asList(1,2,null,4,null,6,1,2,null,4,null,6);
		Stream<Integer> filter = list.stream().filter(num -> num!=null);
		Stream<Integer> skip = filter.skip(2);
		Object[] array = skip.toArray();
		for (Object object : array) {
			System.out.println("object:"+object);
		}
	}
	
	//===================================================

	@Test
	public void x() throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Stream<Integer> stream = numbers.stream();
		Stream<Integer> filter = stream.filter(x -> {
			return x % 2 == 0;
		});
		filter.forEach(System.out::println);
	}
	

	@Test
	public void map() throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Stream<Integer> stream = numbers.stream();
		Stream<Integer> map = stream.map((x) -> {
			return x * 2;
		});
		
		map.forEach(System.out::println);
		
	}
	
	
}
