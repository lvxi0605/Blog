package junit.edu.jxufe.lvxi.persist.service.impl;

import edu.jxufe.lvxi.blog.core.persist.entity.system.UserAuthEntity;
import edu.jxufe.lvxi.blog.core.persist.entity.system.UserEntity;
import edu.jxufe.lvxi.blog.core.persist.service.system.UserService;
import junit.edu.jxufe.lvxi.BaseJunit4Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>二月 7, 2017</pre>
 */
public class UserServiceImplTest extends BaseJunit4Test {
    @Autowired
    private UserService userService;


    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: register(UserEntity userEntity, UserAuthEntity userAuthEntity)
     */
   // @Test
    public void testRegister() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setAccount("test");
        userEntity.setNickname("测试");
        userEntity.setEmail("874047493@qq.com");
        userEntity.setSex((byte) 1);
        userEntity.setIcon("default.jpg");
        userEntity.setSignature("个性签名测试");

        UserAuthEntity userAuthEntity = new UserAuthEntity();
        userAuthEntity.setAccount("test");
        userAuthEntity.setPassword("adfdsfsa");
        userAuthEntity.setSalt("dsfsa");
        userService.register(userAuthEntity);
        Assert.assertTrue("注册失败",userAuthEntity.getId()>0);

    }
    @Test
    public void testFindUserAuthByAccount() throws Exception {
        String account ="root";
        UserAuthEntity userAuthEntity = userService.findUserAuthByAccount(account);
        Assert.assertEquals("查询失败",userAuthEntity.getAccount(),account);
    }

} 
