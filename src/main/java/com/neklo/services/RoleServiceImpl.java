package com.neklo.services;

import com.neklo.dao.RoleDAO;
import com.neklo.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vladosby on 15.01.15.
 */

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDAO roleDAO;

    public List<Role> findAllRole() {
        return roleDAO.findAllRole();
    }

    public void saveRole(Role role) {
        roleDAO.saveRole(role);
    }

    public void deleteRole(int id) {
        roleDAO.deleteRole(id);
    }

    public Role findRoleByID(int id) {
        return roleDAO.findRoleByID(id);
    }
}
