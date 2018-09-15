package hwxy.examol.dao;

import hwxy.examol.entity.User;

import java.util.List;

public interface UserDao {
    /**
     * 删
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 增
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * id查
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 用户名查
     * @param name
     * @return
     */
    List<User> selectByName(String name);

    /**
     * 主键查
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);
}