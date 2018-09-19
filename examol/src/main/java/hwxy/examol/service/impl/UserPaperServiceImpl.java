package hwxy.examol.service.impl;

import hwxy.examol.dao.PaperDao;
import hwxy.examol.dao.UserPaperDao;
import hwxy.examol.entity.Paper;
import hwxy.examol.entity.User;
import hwxy.examol.entity.UserPaper;
import hwxy.examol.service.PaperService;
import hwxy.examol.service.UserPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPaperServiceImpl implements UserPaperService
{
    @Autowired
    private UserPaperDao userPaperDao;

    @Autowired
    private PaperDao paperDao;

    /**
     * 报名
     *
     * @param userPaper
     */
    @Override
    public boolean addUserPaper(UserPaper userPaper)
    {
        if (userPaper == null ||
                userPaper.getUserId() == null ||
                userPaper.getPaperId() == null) {
            return false;
        }
        //TODO: 添加事务 不成功回滚
        userPaperDao.insert(userPaper);
        return true;
    }

    /**
     * userId查
     *
     * @param userId
     * @param state
     * @return
     */
    @Override
    public List<UserPaper> getUserPaperList(Integer userId, Integer state)
    {
        if (userId == null) {
            return null;
        }
        List<UserPaper> userPaperList = userPaperDao.selectByUserId(userId, state);
        return userPaperList;
    }

    /**
     * 交卷 判分 插
     *
     * @param userPaper
     * @return
     */
    @Override
    public boolean finishExam(UserPaper userPaper)
    {
        if (userPaper == null || userPaper.getUserId() == null ||
                userPaper.getPaperId() == null ||
                userPaper.getExamAnswer() == null) {
            return false;
        }
        String examAnswer = userPaper.getExamAnswer().trim().toUpperCase();
        //获取考试信息
        userPaper = userPaperDao.selectByUserIdAndPaperId(userPaper.getUserId(),
                userPaper.getPaperId(), 0);
        if (userPaper == null) {
            return false;
        }
        userPaper.setExamAnswer(examAnswer);
        //判断答案正确
        Paper paper = paperDao.selectByPrimaryKey(userPaper.getPaperId());
        String trueAnswer = paper.getTrueAnswer();
        int length = examAnswer.length() < trueAnswer.length() ? examAnswer.length() : trueAnswer.length();
        int count = 0;
        for (int i = 0; i < length; i++)
        {
            if (! (trueAnswer.charAt(i) == examAnswer.charAt(i))) {
                count++;
            }
        }
        int examScore = paper.getFullScore()-count*25;
        userPaper.setExamScore(examScore);

        //更改状态
        userPaper.setState(1);

        //更新
        userPaperDao.updateByPrimaryKey(userPaper);

        return true;
    }


}
