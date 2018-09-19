package hwxy.examol.entity;

import java.io.Serializable;

/**
 * paper_question
 * @author 
 */
public class PaperQuestion implements Serializable {
    private Integer id;

    private Integer paperId;

    private Integer questionId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}