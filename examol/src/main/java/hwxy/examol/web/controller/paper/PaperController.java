package hwxy.examol.web.controller.paper;

import hwxy.examol.dao.QuestionDao;
import hwxy.examol.entity.Paper;
import hwxy.examol.entity.Question;
import hwxy.examol.entity.User;
import hwxy.examol.entity.UserPaper;
import hwxy.examol.service.PaperService;
import hwxy.examol.service.QuestionService;
import hwxy.examol.service.UserPaperService;
import hwxy.examol.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/paper")
public class PaperController
{
    @Autowired
    private PaperService paperService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserPaperService userPaperService;

    /**
     * 关键字搜索试卷
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/searchPaper", method = RequestMethod.POST)
    private String getPaperPage(HttpServletRequest request, Model model)
    {
        String keyWord = HttpServletRequestUtil.getString(request, "keyWord");
        List<Paper> paperList = null;
        if (keyWord == null ||
                "".equals(keyWord = keyWord.trim())) {
            paperList = paperService.selectAllPaper();
            model.addAttribute("paperList", paperList);
            return "/paper/paperList";
        }
        paperList = paperService.getPaperList(keyWord);
        model.addAttribute("paperList", paperList);
        return "/paper/paperList";
    }

    /**
     * 报名
     * @param paper
     * @param model
     * @return
     */
    @RequestMapping(value = "/applyPaper", method = RequestMethod.POST)
    private String applyPaper(HttpServletRequest request, Paper paper, Model model)
    {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("errMsg", "请登录!");
            return "/user/login";
        }
        UserPaper userPaper = new UserPaper();
        userPaper.setUserId(user.getId());
        userPaper.setPaperId(paper.getId());
        userPaper.setState(0);
        userPaper.setPaperName(paper.getName());
        //失败
        if (!userPaperService.addUserPaper(userPaper)) {
            model.addAttribute("errMsg", "报名失败!");
            return "/paperList";
        }
        List<Paper> appliedPaperList = paperService.getPaperList(user, 0);
        model.addAttribute("appliedPaperList", appliedPaperList);
        List<UserPaper> finishedPaperList = userPaperService.getUserPaperList(user.getId(), 1);
        model.addAttribute("finishedPaperList", finishedPaperList);
        //成功 转到已报名试卷页面
        return "/paper/paperApplied";
    }

    /**
     * 开始考试
     * @param request
     * @param paper
     * @param model
     * @return
     */
    @RequestMapping(value = "/startExam", method = RequestMethod.POST)
    private String startExam(HttpServletRequest request, Paper paper, Model model)
    {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("errMsg", "请登录!");
            return "/user/login";
        }
        if (paper == null || paper.getId() == null) {
            model.addAttribute("errMsg", "试卷错误!");
            return "/paper/paperApplied";
        }
        paper = paperService.getPaper(paper.getId());
        if (paper == null) {
            model.addAttribute("errMsg", "无试卷!");
            return "/paper/paperApplied";
        }
        //用Paper查questions
        List<Question> questionList = questionService.getQuestionList(paper);
        model.addAttribute("questionList", questionList);
        model.addAttribute("paper", paper);
        return "/paper/examPaper";
    }

    /**
     * 交卷
     * @param userPaper
     * @param model
     * @return
     */
    @RequestMapping(value = "/finishExam", method = RequestMethod.POST)
    private String finishExam(HttpServletRequest request, UserPaper userPaper, Model model)
    {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("errMsg", "请登录!");
            return "/user/login";
        }
        if (userPaper == null || userPaper.getPaperId() == null ||
                userPaper.getExamAnswer() == null) {
            model.addAttribute("errMsg", "交卷错误!");
            return "/paper/paperApplied";
        }
        userPaper.setUserId(user.getId());
        if (!userPaperService.finishExam(userPaper)) {
            model.addAttribute("errMsg", "交卷错误!");
            return "/paper/paperApplied";
        }

        List<Paper> appliedPaperList = paperService.getPaperList(user, 0);
        model.addAttribute("appliedPaperList", appliedPaperList);
        List<UserPaper> finishedPaperList = userPaperService.getUserPaperList(user.getId(), 1);
        model.addAttribute("finishedPaperList", finishedPaperList);
        //成功 转到已报名试卷页面
        return "/paper/paperApplied";

    }

}
