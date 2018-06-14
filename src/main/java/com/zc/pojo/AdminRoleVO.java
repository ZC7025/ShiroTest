package com.zc.pojo;

public class AdminRoleVO {
    private Integer id;

    private Integer adminId;

    private Integer roleId;

    private String name;

    public AdminRoleVO() {
    }

    public AdminRoleVO(Integer id, Integer adminId, Integer roleId, String name) {
        this.id = id;
        this.adminId = adminId;
        this.roleId = roleId;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
