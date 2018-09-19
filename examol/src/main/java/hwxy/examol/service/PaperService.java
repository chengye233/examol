package hwxy.examol.service;

import hwxy.examol.entity.Paper;
import hwxy.examol.entity.User;

import java.util.List;

public interface PaperService
{
    /**
     * 关键字查
     * @param keyWord
     * @return
     */
    List<Paper> getPaperList(String keyWord);

    /**
     * 查所有
     * @return
     */
    List<Paper> selectAllPaper();

    /**
     * 连表查 userId, state=0
     * @param user
     * @param state
     * @return
     */
    List<Paper> getPaperList(User user, int state);


    /**
     * id查Paper
     * @param id
     * @return
     */
    Paper getPaper(Integer id);
}
