package app.service;

import app.bean.RoleInfo;
import app.bean.UserInfo;
import app.dao.UserDAO;
import app.dao.impl.UserDAOImpl;
import app.model.Role;
import app.model.User;
import app.service.impl.UserServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserServiceTest {

    @Configuration
    static class UserServiceTestContextConfiguration {
        @Bean(name = "userServiceTest")
        public UserService userServiceTest() {
            return new UserServiceImpl();
        }

        @Bean(name = "userDAOTest")
        public UserDAO userDAOTest() {
            return Mockito.mock(UserDAOImpl.class);
        }
    }

    @Autowired
    private UserService userServiceTest;
    @Autowired
    private UserDAO userDAOTest;

    private Role role;
    private RoleInfo roleInfo;
    private User userCorrect;
    private User userFail;
    private UserInfo userInfoCorrect;
    private UserInfo userInfoFail;

    @Before
    public void setUp() {
        role = new Role(1, "ROLE_CUSTOMER");
        roleInfo = new RoleInfo(1, "ROLE_CUSTOMER");
        userCorrect = new User(1, "thanhtung@gmail.com", "Aa123456", "tungct", "1234567", "Male", role);
        userFail = new User(1, "thanhtung1@gmail.com", "Aa123456777", "tungct", "1234567", "Male", role);
        userInfoCorrect = new UserInfo(1, "thanhtung@gmail.com", "Aa123456", "tungct", "1234567", "Male", roleInfo);
        userInfoFail = new UserInfo(1, "thanhtung1@gmail.com", "Aa123456", "tungct", "1234567", "Male", roleInfo);
        Mockito.when(userDAOTest.loadUserByEmail("thanhtung@gmail.com")).thenReturn(userCorrect);
        Mockito.when(userDAOTest.checkLogin(userCorrect)).thenReturn(true);
    }

    @Test
    public void testLoginFailure() {
        Assert.assertEquals(false, userServiceTest.checkLogin(userInfoFail));
    }

    @Test
    public void testLoginSuccessful() {
        Assert.assertEquals(true, userServiceTest.checkLogin(userInfoCorrect));
    }

    @Test
    public void testLoadUerByEmailFailure() {
        Assert.assertEquals(false, userServiceTest.createUser(userInfoCorrect));
    }

    @Test
    public void testLoadUerByEmailSuccessful() {
        Assert.assertEquals(true, userServiceTest.createUser(userInfoFail));
    }

    @After
    public void verify() {
        Mockito.verify(userDAOTest, VerificationModeFactory.times(1)).checkLogin(Mockito.any());
        Mockito.reset(userDAOTest);
    }

}
