package hwxy.examol.service;

import hwxy.examol.entity.Paper;

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
}
