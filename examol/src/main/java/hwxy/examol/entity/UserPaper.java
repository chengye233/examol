package hwxy.examol.entity;

import java.io.Serializable;

/**
 * user_paper
 * @author 
 */
public class UserPaper implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer paperId;

    /**
     * 答题答案
     */
    private String examAnswer;

    /**
     * 0:报名未考试 1:报名已考试
     */
    private Integer state;

    /**
     * 是否收藏0:不收藏 1:搜藏
     */
    private Integer collect;

    /**
     * 得分
     */
    private Integer examScore;

    private String paperName;

    public String getPaperName()
    {
        return paperName;
    }

    public void setPaperName(String paperName)
    {
        this.paperName = paperName;
    }



    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getExamAnswer() {
        return examAnswer;
    }

    public void setExamAnswer(String examAnswer) {
        this.examAnswer = examAnswer;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public Integer getExamScore() {
        return examScore;
    }

    public void setExamScore(Integer examScore) {
        this.examScore = examScore;
    }
}