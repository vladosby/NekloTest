import com.neklo.config.JavaConfig;
import com.neklo.dao.RoleDAO;
import com.neklo.entities.Role;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vladosby on 19.01.15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaConfig.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRoleDAO {
    private final static Integer ROLE_ID = 100;

    @Autowired
    private RoleDAO roleDAO;

    @Test
    public void test00CreateDAO() {
        Assert.assertNotNull("roleDAO should not be null", roleDAO);
    }

    @Test
    @Transactional
    public void test01SaveRole() {
        Role newRole = new Role();

        newRole.setRoleId(ROLE_ID);
        newRole.setName("TestRole");

        roleDAO.saveRole(newRole);

        Assert.assertNotNull("Saving roles isn't working", findRole());
    }


    @Test
    @Transactional
    public void test02ReadUser() {
        Assert.assertNotNull("Reading roles isn't working", findRole());
    }

    @Test
    @Transactional
    public void test03DeleteUser() {
        roleDAO.deleteRole(ROLE_ID);

        Assert.assertNull("Deleting roles isn't working", findRole());
    }

    private Role findRole() {
        Role role;
        try {
            role = roleDAO.findRoleByID(ROLE_ID);
        } catch (EmptyResultDataAccessException e) {
            role = null;
        }

        return role;
    }

}
