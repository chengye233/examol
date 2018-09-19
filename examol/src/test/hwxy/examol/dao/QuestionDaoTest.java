package hwxy.examol.dao;

import hwxy.examol.BaseTest;
import hwxy.examol.entity.Question;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class QuestionDaoTest extends BaseTest
{
    @Autowired
    private QuestionDao questionDao;

    @Test
    public void deleteByPrimaryKey()
    {
    }

    @Test
    public void insert()
    {
        Question question = new Question();
        question.setTitle("test4");
        question.setAnswer("A");
        question.setOption("A.不是B B.是A C.不是C");
        question.setScore(25);
        int line = questionDao.insert(question);
        assertEquals(1, line);
    }

    @Test
    public void selectByPrimaryKey()
    {
    }

    @Test
    public void updateByPrimaryKey()
    {
    }

    @Test
    public void deleteByPrimaryKey1()
    {
    }

    @Test
    public void insert1()
    {
    }

    @Test
    public void selectByTitle()
    {
    }


    @Test
    public void selectByPaperId()
    {
        List<Question> questionList = questionDao.selectByPaperId(1);
        for (Question question : questionList)
        {
            System.out.println(question.getId());

        }
    }

}