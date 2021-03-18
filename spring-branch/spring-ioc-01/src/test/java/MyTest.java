import com.wing.pojo.UserDaoImpl;
import com.wing.service.UserService;
import com.wing.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author memory125
 */
public class MyTest {
    @Test
    public void getUserDao() {
        UserService userService = new UserServiceImpl();

        ((UserServiceImpl) userService).setUserDao(new UserDaoImpl());
        //((UserServiceImpl) userService).setUserDao(new UserDaoMySQLImpl());
        //((UserServiceImpl) userService).setUserDao(new UserDaoSQLServerImpl());

        userService.getUser();
    }

    @Test
    public void testUserDao() {
        // 获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        UserService userServiceImpl = (UserService) context.getBean("userServiceImpl");

        userServiceImpl.getUser();
    }

}
