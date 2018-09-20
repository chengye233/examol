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
     * @param
     * @param
     * @return
     */
    User login(User user);

    /**
     * 注册
     * @param user
     * @return
     */
    boolean register(User user);

    /**
     * 修改密码
     * @param user
     * @return
     */
    boolean changePassword(User user);
}
