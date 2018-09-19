package hwxy.examol.service;

import hwxy.examol.entity.UserPaper;

import java.util.List;

public interface UserPaperService
{
    /**
     * 报名
     * @param userPaper
     */
    boolean addUserPaper(UserPaper userPaper);

    /**
     * 用户查报名信息
     * @param userId
     * @return
     */
    List<UserPaper> getUserPaperList(Integer userId, Integer state);

    /**
     * 交卷 判分 更
     * @param userPaper
     * @return
     */
    boolean finishExam(UserPaper userPaper);

    /**
     * 收藏
     * @param userId
     * @param collect
     * @return
     */
    List<UserPaper> getUserPaperCollection(Integer userId, int collect);

    /**
     * 收藏
     * @param userPaper
     * @return
     */
    boolean addCollection(UserPaper userPaper);
}
