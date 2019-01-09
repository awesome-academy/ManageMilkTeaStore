package app.service;

import app.bean.UserInfo;
import app.dao.impl.UserDAOImpl;
import app.model.User;
import app.service.impl.RoleServiceImpl;
import app.service.impl.UserServiceImpl;
import app.util.ConvertNewUserUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:storemilktea-servlet.xml", "classpath:configs/*.xml"})
public class UserServiceTest {


    @Mock
    private UserDAOImpl userDAO;
    @Mock
    private ConvertNewUserUtils convertNewUserUtils;

    @Mock
    private BCryptPasswordEncoder encoder;

    @Mock
    private RoleServiceImpl roleService;

    @InjectMocks
    private UserServiceImpl userService;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLoginFailure() {

        UserInfo userInfo = new UserInfo();
        userInfo.setEmail("simple@gmail.com");
        userInfo.setFullName("Nguyen11");
        userInfo.setPassword("Aa123456");
        Assert.assertFalse(userService.checkLogin(userInfo));

    }

    @Test
    public void testLoginSuccessful() {

        UserInfo userInfo = new UserInfo();
        userInfo.setEmail("tungct@gmail.com");
        userInfo.setFullName("Nguyen Van A");
        userInfo.setPassword("Aa123456");

        Assert.assertTrue(userService.checkLogin(userInfo));

    }

    @Test
    public void testCreateUserFailure_emailFormat() {

        UserInfo userInfo = new UserInfo();
        userInfo.setEmail("tungct@gmail");
        userInfo.setFullName("Nguyen11");
        userInfo.setPassword("Aa123456");
        Assert.assertFalse(userService.createUser(userInfo));

    }

    @Test
    public void testCreateUserFailure_nameFormat() {

        UserInfo userInfo = new UserInfo();
        userInfo.setEmail("tungct@gmail.com");
        userInfo.setFullName("Ngs");
        userInfo.setPassword("Aa123456");
        Assert.assertFalse(userService.createUser(userInfo));

    }

    @Test
    public void testCreateUserFailure_passwordFormat() {

        UserInfo userInfo = new UserInfo();
        userInfo.setEmail("tungct@gmail.com");
        userInfo.setFullName("Ngs");
        userInfo.setPassword("aa123456");
        Assert.assertFalse(userService.createUser(userInfo));

    }

    @Test
    public void testCreateUserSuccessful() {
        UserInfo userInfo = new UserInfo();
        User user = new User();
        Mockito.when(userDAO.saveOrUpdate(user)).thenReturn(user);
        Mockito.when(convertNewUserUtils.convertNewUser(userInfo)).thenReturn(user);
        Assert.assertTrue(userService.createUser(userInfo));

    }

    @After
    public void verify() {

    }

}

