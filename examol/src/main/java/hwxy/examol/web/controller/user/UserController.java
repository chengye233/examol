package hwxy.examol.web.controller.user;

import hwxy.examol.entity.User;
import hwxy.examol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/user")
public class UserController
{
    @Autowired
    private UserService userService;

    /**
     * 用户登陆
     * @param
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private String login(HttpServletRequest request, User user, Model model)
    {
        System.out.println(user.getName() +"\t" +user.getPassword());

        User loginUser = userService.login(user);
        if (loginUser == null) {
            model.addAttribute("errMsg", "登陆失败");
            return "/user/login";
        }
        request.getSession().setAttribute("user", user);
        model.addAttribute("user", loginUser);
        return "user/home";
    }

}
