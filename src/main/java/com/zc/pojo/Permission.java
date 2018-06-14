package com.zc.pojo;

public class Permission {
    private Long id;

    private String permission;

    private String desZh;

    private Long moduleId;

    public Permission(Long id, String permission, String desZh, Long moduleId) {
        this.id = id;
        this.permission = permission;
        this.desZh = desZh;
        this.moduleId = moduleId;
    }

    public Permission() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public String getDesZh() {
        return desZh;
    }

    public void setDesZh(String desZh) {
        this.desZh = desZh == null ? null : desZh.trim();
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }
}