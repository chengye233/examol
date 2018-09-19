package hwxy.examol.web.controller.paper;

import hwxy.examol.entity.Paper;
import hwxy.examol.entity.User;
import hwxy.examol.entity.UserPaper;
import hwxy.examol.service.PaperService;
import hwxy.examol.service.UserPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/paper", method = RequestMethod.GET)
public class PaperPageController
{
    @Autowired
    private PaperService paperService;

    @Autowired
    private UserPaperService userPaperService;

    /**
     * 点击开始一场考试时
     * @param model
     * @return
     */
    @RequestMapping(value = "/paperPage")
    private String getPaperPage(Model model)
    {
        List<Paper> paperList = paperService.selectAllPaper();
        model.addAttribute("paperList", paperList);
        return "/paper/paperList";
    }

    /**
     * 点击已报名考试
     * @param model
     * @return
     */
    @RequestMapping(value = "/paperAppliedPage")
    private String getPaperAppliedPage(HttpServletRequest request, Model model)
    {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("errMsg", "未登录!");
            return "/user/login";
        }
        //TODO: 查Paper
        List<Paper> appliedPaperList = paperService.getPaperList(user, 0);
        model.addAttribute("appliedPaperList", appliedPaperList);
        List<UserPaper> finishedPaperList = userPaperService.getUserPaperList(user.getId(), 1);
        model.addAttribute("finishedPaperList", finishedPaperList);
        return "/paper/paperApplied";
    }


    /**
     * 点击收藏
     * @param model
     * @return
     */
    @RequestMapping(value = "/paperCollectionPage")
    private String getPaperCollectionPage(HttpServletRequest request, Model model)
    {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("errMsg", "未登录!");
            return "/user/login";
        }
        List<UserPaper> collectedPaperList = userPaperService.getUserPaperCollection(user.getId(), 1);
        model.addAttribute("collectedPaperList", collectedPaperList);
        return "/paper/paperCollection";
    }

}
