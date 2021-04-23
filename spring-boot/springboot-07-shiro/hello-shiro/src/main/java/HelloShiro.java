import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author memory125
 */

public class HelloShiro {

    private static final transient Logger log = LoggerFactory.getLogger(HelloShiro.class);


    public static void main(String[] args) {
       //  IniSecurityManagerFactory已经废弃
//        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
//        SecurityManager securityManager = factory.getInstance();
//        SecurityUtils.setSecurityManager(securityManager);

        // 获取本地资源文件,设置realm为本地的资源文件
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
        defaultSecurityManager.setRealm(iniRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        // get the currently executing user: 获取单前用户对象
        Subject currentUser = SecurityUtils.getSubject();
        /*通过当前用户达到session*/
        Session session = currentUser.getSession();
        session.setAttribute("someKey", "aValue");
        String value = (String) session.getAttribute("someKey");
        if (value.equals("aValue")) {
            log.info("Retrieved the correct value!  ===> [" + value + "]");
        }

        // let's login the current user so we can check against roles and permissions: 测试当前用户是否被认证
        if (!currentUser.isAuthenticated()) {
            /*令牌*/
            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
            token.setRememberMe(true); /*设置记住我*/
            try {
                currentUser.login(token); /*制定登陆操作*/
            } catch (UnknownAccountException uae) {
                log.info("There is no user with username of " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {
                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
            } catch (LockedAccountException lae) {
                log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            }
        }

        //say who they are:
        //print their identifying principal (in this case, a username):
        log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");

        //test a role: /*检测是否为什么角色*/
        if (currentUser.hasRole("schwartz")) {
            log.info("May the Schwartz be with you!");
        } else {
            log.info("Hello, mere mortal.");
        }

        //test a typed permission (not instance-level) /*测试有什么权限 粗粒度*/
        if (currentUser.isPermitted("lightsaber:wield")) {
            log.info("You may use a lightsaber ring.  Use it wisely.");
        } else {
            log.info("Sorry, lightsaber rings are for schwartz masters only.");
        }

        //a (very powerful) Instance Level permission: /*细粒度*/
        if (currentUser.isPermitted("winnebago:drive:eagle5")) {
            log.info("You are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  " +
                    "Here are the keys - have fun!");
        } else {
            log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
        }

        //all done - log out!
        currentUser.logout();

        System.exit(0);
    }
}

