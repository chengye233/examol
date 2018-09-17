package hwxy.examol.service;

import hwxy.examol.entity.User;

public interface UserService
{
    /**
     * 登陆获取用户
     * @param userName
     * @param password
     * @return
     */
    User login(String userName, String password);

    /**
     * 登陆获取用户
     * @param userName
     * @param password
     * @return
     */
    User login(User user);
}
