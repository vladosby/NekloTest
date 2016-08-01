package com.neklo.dao;

import com.neklo.entities.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by vladosby on 15.01.15.
 */
@Repository
public class RoleDAOImpl implements RoleDAO {
    @PersistenceContext
    private EntityManager em;
    private String SQL_FIND_ALL_ROLE = "SELECT * FROM role";
    private String SQL_FIND_ROLE_BY_ID = "from Role where roleId = :id";
    private String SQL_DELETE_ROLE = "delete Role where roleId = :id";


    public List<Role> findAllRole() {
        Query query = em.createNativeQuery(SQL_FIND_ALL_ROLE, Role.class);
        return query.getResultList();
    }


    public void saveRole(Role role) {
        em.persist(role);
    }


    public void deleteRole(int id) {
        Query query = em.createQuery(SQL_DELETE_ROLE);
        query.setParameter("id", id);
        query.executeUpdate();
    }


    public Role findRoleByID(int id) {
        TypedQuery<Role> query = em.createQuery(SQL_FIND_ROLE_BY_ID, Role.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }

}
