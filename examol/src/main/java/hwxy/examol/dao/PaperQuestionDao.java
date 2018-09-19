package hwxy.examol.dao;

import hwxy.examol.entity.PaperQuestion;

public interface PaperQuestionDao {
    /**
     * 主键删
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插
     * @param record
     * @return
     */
    int insert(PaperQuestion record);

    /**
     * 主键查
     * @param id
     * @return
     */
    PaperQuestion selectByPrimaryKey(Integer id);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(PaperQuestion record);
}