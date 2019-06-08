package cn.wgh.Algorithmic;

public class Group {
	private String id;
	private String pId;
	private String name;
	
	public Group(String id,String pId, String name){
		this.id = id;
		this.pId = pId;
		this.name = name;
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Group [id=" + id + ", pId=" + pId + ", name=" + name + "]";
	}
	
}
