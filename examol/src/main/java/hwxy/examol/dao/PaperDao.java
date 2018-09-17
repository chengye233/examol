package hwxy.examol.dao;

import hwxy.examol.entity.Paper;

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