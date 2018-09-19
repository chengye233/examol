package hwxy.examol.service;

import hwxy.examol.entity.Paper;
import hwxy.examol.entity.Question;

import java.util.List;

public interface QuestionService
{
    /**
     * 用paperId查
     * @param paper
     * @return
     */
    List<Question> getQuestionList(Paper paper);
}
