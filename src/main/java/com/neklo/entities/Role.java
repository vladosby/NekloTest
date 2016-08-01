package com.neklo.entities;

import javax.persistence.*;

/**
 * Created by vladosby on 15.01.15.
 */
@Entity
public class Role {
    @Id
    @Column(name = "id")
    private int roleId;

    private String name;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
