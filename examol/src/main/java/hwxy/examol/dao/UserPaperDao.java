package hwxy.examol.dao;

import hwxy.examol.entity.UserPaper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserPaperDao {
    int deleteByPrimaryKey(Integer id);

    /**
     * 插
     * @param record
     * @return
     */
    int insert(UserPaper record);

    /**
     * 主键查
     * @param id
     * @return
     */
    UserPaper selectByPrimaryKey(Integer id);

    /**
     * 用户id查
     * @param userId
     * @return
     */
    List<UserPaper> selectByUserId(@Param("userId") Integer userId,
                                   @Param("state") Integer state);

    /**
     * 用userId和paperId
     * @param userId
     * @param paperId
     * @return
     */
    UserPaper selectByUserIdAndPaperId(@Param("userId") Integer userId,
                                       @Param("paperId") Integer paperId,
                                       @Param("state") Integer state);

    /**
     * 主键改
     * @param record
     * @return
     */
    int updateByPrimaryKey(UserPaper record);

    /**
     * 查收藏
     * @param userId
     * @param i
     * @return
     */
    List<UserPaper> selectByUserIdAndState(@Param("userId") Integer userId,
                                           @Param("collect") int collect);
}