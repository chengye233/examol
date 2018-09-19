package hwxy.examol.entity;

import java.io.Serializable;

/**
 * question
 * @author 
 */
public class Question implements Serializable {
    private Integer id;

    /**
     * 题目
     */
    private String title;

    /**
     * 选项
     */
    private String option;

    /**
     * 答案
     */
    private String answer;

    /**
     * 分值
     */
    private Integer score;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}