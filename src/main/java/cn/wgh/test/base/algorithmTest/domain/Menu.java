package cn.wgh.test.base.algorithmTest.domain;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private int id;
	private int pId;
	private String name;
	private List<Menu> children = new ArrayList<Menu>();

	public Menu() {

	}

	public Menu(int id, int pId, String name) {
		this.id = id;
		this.pId = pId;
		this.name = name;
	}
	
	public Menu(int id, int pId, String name, List<Menu> children) {
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.children = children;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	@Override
	public String toString() {
//		return "[id=" + id + ", pId=" + pId + ", name=" + name + ", children=" + children + "]";
		return "(id=" + id + ", pId=" + pId + ", name=" + name + ", children=" + children + ")";
	}
}
