package com.neklo.services;

import com.neklo.entities.Role;

import java.util.List;

/**
 * Created by vladosby on 15.01.15.
 */
public interface RoleService {
    public List<Role> findAllRole();

    public void saveRole(Role role);

    public void deleteRole(int id);

    public Role findRoleByID(int id);
}
