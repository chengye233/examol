package hwxy.examol.service.impl;

import hwxy.examol.dao.QuestionDao;
import hwxy.examol.entity.Paper;
import hwxy.examol.entity.Question;
import hwxy.examol.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService
{
    @Autowired
    private QuestionDao questionDao;


    /**
     * 用paperId查
     *
     * @param paper
     * @return
     */
    @Override
    public List<Question> getQuestionList(Paper paper)
    {
        if (paper == null || paper.getId() == null) {
            return null;
        }
        return questionDao.selectByPaperId(paper.getId());
    }
}
