package cn.wgh.json.pojo;

public class Course {
	private int id;
	private String name;
	private String totalPoint;
	private String grade;
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTotalPoint() {
		return totalPoint;
	}
	public void setTotalPoint(String totalPoint) {
		this.totalPoint = totalPoint;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", totalPoint=" + totalPoint + ", grade=" + grade + ", remark="
				+ remark + "]";
	}
	
}
