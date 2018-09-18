package hwxy.examol.dao;

import hwxy.examol.entity.Paper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperDao {
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
    int insert(Paper record);

    /**
     * 主键查
     * @param id
     * @return
     */
    Paper selectByPrimaryKey(Integer id);

    /**
     * 连表查usrId的Paper
     * @param userId
     * @param state
     * @return
     */
    List<Paper> selectPaperByUserId(@Param("userId") Integer userId,
                                    @Param("state") Integer state);

    /**
     * 改
     * @param record
     * @return
     */
    int updateByPrimaryKey(Paper record);

    /**
     * 试卷名
     * @param name
     * @return
     */
    List<Paper> selectByName(String name);

    /**
     * 查所有试卷
     * @return
     */
    List<Paper> selectAllPaper();
}