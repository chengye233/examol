package hwxy.examol.entity;

import java.io.Serializable;

/**
 * paper
 * @author 
 */
public class Paper implements Serializable {
    private Integer id;

    private String name;

    /**
     * 正确答案
     */
    private String trueAnswer;

    /**
     * 满分
     */
    private Integer fullScore;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(String trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    public Integer getFullScore() {
        return fullScore;
    }

    public void setFullScore(Integer fullScore) {
        this.fullScore = fullScore;
    }
}