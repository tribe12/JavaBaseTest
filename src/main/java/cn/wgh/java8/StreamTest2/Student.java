package cn.wgh.java8.StreamTest2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 生成 getter/setter/equals/canEqual/hashCode/toString
@NoArgsConstructor // 为类提供一个无参的构造方法
@AllArgsConstructor // 为类提供一个全参的构造方法
public class Student {
	private String id;
	private String name;
	private Integer age;
}
