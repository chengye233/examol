package hwxy.examol.web.controller.paper;

import hwxy.examol.entity.Paper;
import hwxy.examol.entity.User;
import hwxy.examol.entity.UserPaper;
import hwxy.examol.service.PaperService;
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
        //失败
        if (!userPaperService.addUserPaper(userPaper)) {
            model.addAttribute("errMsg", "报名失败!");
            return "/paperList";
        }
        List<Paper> appliedPaperList = paperService.getPaperList(user, 0);
        model.addAttribute("appliedPaperList", appliedPaperList);
        List<Paper> finishedPaperList = paperService.getPaperList(user, 1);
        model.addAttribute("finishedPaperList", finishedPaperList);
        //成功 转到已报名试卷页面
        return "/paper/paperApplied";
    }
}
