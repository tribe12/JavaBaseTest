package cn.wgh.Class_Feflect;

public class Student {
	private String name;
	private Student(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age="  + "]";
	}
	
}
