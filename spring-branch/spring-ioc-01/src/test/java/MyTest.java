import com.wing.dao.UserDaoImpl;
import com.wing.dao.UserDaoMySQLImpl;
import com.wing.dao.UserDaoSQLServerImpl;
import com.wing.service.UserService;
import com.wing.service.UserServiceImpl;
import org.junit.Test;

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

}
