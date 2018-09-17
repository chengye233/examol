package hwxy.examol.web.controller.paper;

import hwxy.examol.entity.Paper;
import hwxy.examol.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/paper", method = RequestMethod.GET)
public class PaperPageController
{
    @Autowired
    private PaperService paperService;

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
        return "paper/paperList";
    }

}
