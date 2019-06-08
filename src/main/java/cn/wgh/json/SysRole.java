package cn.wgh.json;

public class SysRole {
    private String id;

    private String name;

    private String description;
    
    private String enable;

    private String createBy;

    private String createDate;

    private String updateBy;

    private String updateDate;

    private String delFlag;

    private String type;

    private String epRoleId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
    
    public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
    
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getEpRoleId() {
		return epRoleId;
	}

	public void setEpRoleId(String epRoleId) {
		this.epRoleId = epRoleId;
	}

	@Override
	public String toString() {
		return "SysRole [id=" + id + ", name=" + name + ", description=" + description + ", enable=" + enable
				+ ", delFlag=" + delFlag + ", type=" + type + ", epRoleId=" + epRoleId + "]";
	}
	
}