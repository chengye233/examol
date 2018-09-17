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
@RequestMapping(value = "/paper")
public class PaperController
{
    @Autowired
    private PaperService paperService;

    @RequestMapping(value = "/searchPaper", method = RequestMethod.POST)
    private String getPaperPage(String keyWord, Model model)
    {
        if (keyWord == null ||
                "".equals(keyWord = keyWord.trim())) {
            model.addAttribute("errMsg", "没有找到试卷，试试其他关键字");
            return "paper/paperList";
        }
        List<Paper> paperList = paperService.getPaperList(keyWord);
        model.addAttribute("paperList", paperList);
        return "paper/paperList";
    }
}
