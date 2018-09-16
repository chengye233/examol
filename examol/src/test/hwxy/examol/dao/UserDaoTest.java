package hwxy.examol.dao;

import hwxy.examol.BaseTest;
import hwxy.examol.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * 测试UserDao
 */
public class UserDaoTest extends BaseTest
{

    @Autowired
    private UserDao userDao;

    /**
     * 删
     */
    @Test
    public void deleteByPrimaryKey()
    {
        int line = userDao.deleteByPrimaryKey(2);
        assertEquals(1, line);
    }

    /**
     * 删
     */
    @Test
    public void insert()
    {
        User user = new User();
        user.setName("test");
        user.setEmail("test@test.com");
        user.setPassword("test123");
        user.setType(0);
        user.setVerify(1);
        int line = userDao.insert(user);
        assertEquals(1, line);
    }

    @Test
    public void selectByName()
    {
        User user = userDao.selectByName("test");

    }


    @Test
    public void selectByPrimaryKey()
    {
    }


    @Test
    public void updateByPrimaryKey()
    {
        User user = new User();
        user.setId(3);
        user.setName("update");
        user.setEmail("test@test.com");
        user.setPassword("test123");
        user.setType(0);
        user.setVerify(1);
        int line = userDao.updateByPrimaryKey(user);
        assertEquals(1, line);
    }
}