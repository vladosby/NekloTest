package com.neklo.dao;

import com.neklo.entities.Role;

import java.util.List;

/**
 * Created by vladosby on 15.01.15.
 */
public interface RoleDAO {
    public List<Role> findAllRole();

    public void saveRole(Role role);

    public void deleteRole(int id);

    public Role findRoleByID(int id);
}
