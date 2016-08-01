import com.neklo.config.JavaConfig;
import com.neklo.dao.UserDAO;
import com.neklo.entities.Role;
import com.neklo.entities.User;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
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
public class TestUserDAO extends AbstractTransactionalJUnit4SpringContextTests {

    private final static Integer USER_ID = 100;

    @Autowired
    private UserDAO userDAO;

    @Test
    public void test00CreateDAO() {
        Assert.assertNotNull("userDAO should not be null", userDAO);
    }

    @Test
    @Transactional
    public void test01SaveUser() {
        Role role = new Role();
        User newUser = new User();

        role.setRoleId(1);

        newUser.setUserId(USER_ID);
        newUser.setPassword("123456");
        newUser.setFirstName("TestFirstName");
        newUser.setLastName("TestLastName");
        newUser.setRole(role);

        userDAO.saveUser(newUser);

        Assert.assertNotNull("Saving users isn't working", findUser());
    }


    @Test
    @Transactional
    public void test02ReadUser() {
        Assert.assertNotNull("Reading users isn't working", findUser());
    }

    @Test
    @Transactional
    public void test03DeleteUser() {
        userDAO.deleteUser(USER_ID);

        Assert.assertNull("Deleting users isn't working", findUser());
    }

    private User findUser() {
        User user;
        try {
            user = userDAO.findUserById(USER_ID);
        } catch (EmptyResultDataAccessException e) {
            user = null;
        }

        return user;
    }
}
