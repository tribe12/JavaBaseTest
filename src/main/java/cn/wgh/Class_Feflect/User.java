package cn.wgh.Class_Feflect;

import cn.wgh.Annotation.VIP;

@VIP(1)
public class User {
	private String name;
	private long phone;
	private int age;
	private String content;
	
	private User(String name){
		this.name = name;
	}
	
	
	private void sayHello(){
		System.out.println("Hello!");
	}
	

	private void say(String talk){
		System.out.println("---"+talk+"---");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", phone=" + phone + ", age=" + age + ", content=" + content + "]";
	}
	
}
