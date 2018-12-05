package com.lc.entity;

import org.springframework.security.core.GrantedAuthority;

public class SysRole implements GrantedAuthority {

    /**
     * 返回角色的名称
     * @return
     */
    @Override
    public String getAuthority() {
        return this.getName();
    }

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
