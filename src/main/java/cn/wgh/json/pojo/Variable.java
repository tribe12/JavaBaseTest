package cn.wgh.json.pojo;
/**
 * 流程变量实体
 * 
 * @author wgh
 *
 */
public class Variable {
	private String name;
	private String type;
	private String value;
	private String scope;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
}
