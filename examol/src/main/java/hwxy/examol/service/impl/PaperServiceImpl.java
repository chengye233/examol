package hwxy.examol.service.impl;

import hwxy.examol.dao.PaperDao;
import hwxy.examol.entity.Paper;
import hwxy.examol.entity.User;
import hwxy.examol.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperServiceImpl implements PaperService
{
    @Autowired
    private PaperDao paperDao;

    /**
     * 查关键字
     * @param keyWord
     * @return
     */
    @Override
    public List<Paper> getPaperList(String keyWord)
    {
        if (keyWord == null ||
                keyWord.length() == 0 ||
                "".equals(keyWord.trim())) {
            return null;
        }
        List<Paper> paperList = paperDao.selectByName(keyWord);
        return paperList;
    }

    /**
     * 查所有
     * @return
     */
    @Override
    public List<Paper> selectAllPaper()
    {
        List<Paper> paperList = paperDao.selectAllPaper();
        return paperList;
    }

    /**
     * 连表查 userId, state=0
     *
     * @param user
     * @param state
     * @return
     */
    @Override
    public List<Paper> getPaperList(User user, int state)
    {
        if (user == null) {
            return null;
        }
        return paperDao.selectPaperByUserId(user.getId(), state);
    }

}
