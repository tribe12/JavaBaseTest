package cn.wgh.json.pojo;

import java.util.Date;

public class OpManagerRoleMenu {
    private Long id;

    private Long roleId;

    private Long menuId;

    private Integer allowUse = 0;

    private Integer allowGrant = 0;

    private String creatorId;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Integer getAllowUse() {
        return allowUse;
    }

    public void setAllowUse(Integer allowUse) {
        this.allowUse = allowUse;
    }

    public Integer getAllowGrant() {
        return allowGrant;
    }

    public void setAllowGrant(Integer allowGrant) {
        this.allowGrant = allowGrant;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}