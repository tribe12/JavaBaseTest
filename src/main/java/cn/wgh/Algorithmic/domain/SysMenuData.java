package cn.wgh.Algorithmic.domain;

import java.util.ArrayList;
import java.util.List;

public class SysMenuData extends SysMenu {
	private List<SysMenuData> children = new ArrayList<SysMenuData>();

	public List<SysMenuData> getChildren() {
		return children;
	}

	public void setChildren(List<SysMenuData> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "SysMenuData···id :"+this.getId()+" [children=" + children + "]";
	}
	
}
