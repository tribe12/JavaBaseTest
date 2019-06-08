package cn.wgh.streamTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamTest {

	@Test
	public void testName1() throws Exception {
		List<Integer> nums = Arrays.asList(1, null, 3, 4, null, 6);
		long count = nums.stream().filter(num -> num != null).count();
		System.out.println(count);//4
	}

	@Test
	public void testName2() throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Stream<Integer> stream = numbers.stream();
		stream.filter((x) -> {
			return x % 2 == 0;
		}).map((x) -> {
			return x * x;
		}).forEach(System.out::println);
	}

	@Test
	public void testName3() throws Exception {
		Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);
	}

	@Test
	public void testName4() throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3);
		Stream<Integer> stream = numbers.stream();
		Object[] array1 = stream.toArray();
		System.out.println(array1.length);
		Stream<Integer> distinct = stream.distinct();
		Object[] array = distinct.toArray();
		System.out.println(array.length);
	}

	@Test
	public void testName() throws Exception {
		List<String> tags1 = Arrays.asList("C语言", "C++", "Java");
		Article articles1 = new Article("编程语言", "小明", tags1);
		List<String> tags2 = Arrays.asList("语文", "数学", "英语");
		Article articles2 = new Article("科目", "小明", tags2);
		List<String> tags3 = Arrays.asList("Java", "JS", "Pyh");
		Article articles3 = new Article("编程之路", "周星星", tags3);
		List<Article> articles = new ArrayList<Article>();
		articles.add(articles1);
		articles.add(articles2);
		articles.add(articles3);

		System.out.println("------------------------------------------1");
		/**
		 * 在集合中查找包含“Java”标签的第一篇文章。
		 */
		// 使用for循环的解决方案:
		System.out.println("在集合中查找包含“Java”标签的第一篇文章。使用for循环的解决方案:");
		for (Article article : articles) {
			if (article.getTags().contains("Java")) {
				System.out.println(article.getTags());
				break;
			}
		}
		// 使用Stream API的相关操作来解决这个问题。
		System.out.println("在集合中查找包含“Java”标签的第一篇文章。使用Stream API的相关操作来解决这个问题:");
		Optional<Article> findFirst = articles.stream().filter(article -> article.getTags().contains("Java"))
				.findFirst();
		System.out.println(findFirst.get().getTags());

		System.out.println("------------------------------------------2");
		/**
		 * 在集合中查找包含“Java”标签的所以文章。
		 */
		// 使用for循环方案。
		System.out.println("在集合中查找包含“Java”标签的所以文章。使用for循环方案:");
		List<Article> result = new ArrayList<>();
		for (Article article : articles) {
			if (article.getTags().contains("Java")) {
				result.add(article);
			}
		}
		for (Article article : result) {
			System.out.println(article.getTags());
		}
		// 使用Stream操作的方案。
		System.out.println("在集合中查找包含“Java”标签的所以文章。使用Stream API的相关操作来解决方案:");
		List<Article> collect = articles.stream().filter(article -> article.getTags().contains("Java"))
				.collect(Collectors.toList());

		for (Article article : collect) {
			System.out.println(article.getTags());
		}

		System.out.println("------------------------------------------3");
		/**
		 * 根据作者来把所有的文章分组。
		 */
		// 用for循环方案
		System.out.println("根据作者来把所有的文章分组,用for循环方案:");
		Map<String, List<Article>> result_2 = new HashMap<>();
		for (Article article : articles) {
			if (result_2.containsKey(article.getAuthor())) {
				result_2.get(article.getAuthor()).add(article);
			} else {
				ArrayList<Article> articles_2 = new ArrayList<>();
				articles_2.add(article);
				result_2.put(article.getAuthor(), articles_2);
			}
		}
		System.out.println(result_2);

		// 使用Stream操作的方案
		System.out.println("根据作者来把所有的文章分组,使用Stream操作的方案:");
		Map<String, List<Article>> collect_2 = articles.stream().collect(Collectors.groupingBy(Article::getAuthor));
		System.out.println(collect_2);

		System.out.println("------------------------------------------4");
		/**
		 * 查找集合中所有不同的标签。
		 */
		// 用for循环方案
		System.out.println("查找集合中所有不同的标签,用for循环方案:");
		Set<String> result_3 = new HashSet<>();
		for (Article article : articles) {
			result_3.addAll(article.getTags());
		}
		System.out.println(result_3);

		// 使用Stream操作的方案
		System.out.println("查找集合中所有不同的标签,使用Stream操作的方案:");
		Set<String> collect_3 = articles.stream().flatMap(article -> article.getTags().stream())
				.collect(Collectors.toSet());
		System.out.println(collect_3);
	}

	@Test
	public void testName5() throws Exception {
		Stream.of("3", "1", "5", "4", "2").sorted((s1, s2) -> {
			System.out.printf("sort: %s; %s\n", s1, s2);
			System.out.println("----------------");
			return s1.compareTo(s2);
		}).map(s -> {
			System.out.println("map: " + s);
			System.out.println("================");
			return s;
		}).forEach(s -> System.out.println("forEach: " + s));
	}

	
	/**
	 * 缺点：需要重新创建一个List
	 * @throws Exception
	 */
	@Test
	public void 排序() throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 7, 8, 9, 10, 5, 6, 7, 8, 9, 10, 1, 2, 3);
		System.out.println(numbers);
		// numbers.stream().sorted(Comparator.comparing(numbers));
		numbers.stream().sorted().forEach(System.out::print);
		
		List<Integer> list = new ArrayList<Integer>();
		Iterator<Integer> iterator = numbers.stream().sorted().iterator();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
		System.out.println(list);
	}
	
	/**
	 * 缺点：需要重新创建一个List
	 * @throws Exception
	 */
	@Test
	public void 对类排序() throws Exception {
		Student student1 = new Student("2", "小明", 10);
		Student student2 = new Student("1", "旺财", 9);
		Student student3 = new Student("3", "周星星", 17);
		Student student4 = new Student("4", "包子", 12);
		List<Student> stus = Arrays.asList(student1, student2, student3, student4);
		System.out.println(stus);
		Iterator<Student> iterator = stus.stream().sorted(Comparator.comparing(Student::getId)).iterator();
		List<Student> newStus = new ArrayList<Student>();
		while (iterator.hasNext()) {
			Student next = iterator.next();
			newStus.add(next);
			System.out.println(next);
		}
		System.out.println(newStus);
		
	}
	
	
	
	
	@Test
	public void 对类排序2() throws Exception {
		Student student1 = new Student("2", "小明", 10);
		Student student2 = new Student("1", "旺财", 9);
		Student student3 = new Student("3", "周星星", 17);
		Student student4 = new Student("4", "包子", 12);
		List<Student> stus = Arrays.asList(student1, student2, student3, student4);
		System.out.println(stus);
		
		
		Iterator<Student> iterator2 = stus.stream().iterator();
		
		
		
		Iterator<Student> iterator = stus.stream().sorted(Comparator.comparing(Student::getId)).iterator();
		List<Student> newStus = new ArrayList<Student>();
		while (iterator.hasNext()) {
			Student next = iterator.next();
			newStus.add(next);
			System.out.println(next);
		}
		System.out.println(newStus);
		
	}
}
