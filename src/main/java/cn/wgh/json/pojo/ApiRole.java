package cn.wgh.json.pojo;
/**
 * 对应ep平台角色
 * 
 * @author wgh
 * 
 *  "id": "16121510085090531187",
 *  "createTime": "2016-12-15 10:08:50",
 *  "groupId": "16121510054490530885",
 *  "name": "客户经理", 
 *  "spId": "16121310131890219167", 
 *  "type": "2", 
 *  "memberCount": "34"
 */
public class ApiRole {

	private String id;
	private String createTime;
	private String groupId;
	private String name;
	private String spId;
	private String type;
	private String memberCount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpId() {
		return spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(String memberCount) {
		this.memberCount = memberCount;
	}

	@Override
	public String toString() {
		return "ApiRole [id=" + id + ", createTime=" + createTime + ", groupId=" + groupId + ", name=" + name
				+ ", spId=" + spId + ", type=" + type + ", memberCount=" + memberCount + "]";
	}
	
}
