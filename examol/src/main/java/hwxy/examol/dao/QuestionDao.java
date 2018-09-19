package hwxy.examol.dao;

import hwxy.examol.entity.Question;

import java.util.List;

public interface QuestionDao {
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
    int insert(Question record);


    /**
     * 主键查
     * @param id
     * @return
     */
    Question selectByPrimaryKey(Integer id);


    /**
     * paperId查
     * @param paperId
     * @return
     */
    List<Question> selectByPaperId(Integer paperId);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Question record);
}