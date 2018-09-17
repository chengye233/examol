package hwxy.examol.service.impl;

import hwxy.examol.dao.UserDao;
import hwxy.examol.entity.User;
import hwxy.examol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao userDao;

    /**
     * 获取登陆用户
     * @param userName
     * @param password
     * @return
     */
    @Override
    public User login(String userName, String password)
    {
        if (userName == null || password == null ||
                "".equals(userName.trim()) ||
                "".equals(password.trim())) {
            return null;
        }
        User user = userDao.selectByName(userName);
        if (user == null ||
                !password.equals(user.getPassword())) {
            return null;
        }
        return user;
    }

    /**
     * 获取登陆用户
     * @param user
     * @return
     */
    @Override
    public User login(User user)
    {
        if (user == null || user.getName() == null ||
                user.getPassword() == null ) {
            return null;
        }
        User loginUser = userDao.selectByName(user.getName());
        if (loginUser == null) {
            return null;
        }
        if (!user.getPassword().equals(loginUser.getPassword())) {
            return null;
        }
        return loginUser;
    }
}
