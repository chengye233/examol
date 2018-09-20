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
        User loginUser = userService.login(user);
        if (loginUser == null) {
            model.addAttribute("errMsg", "登陆失败");
            return "/user/login";
        }
        request.getSession().setAttribute("user", loginUser);
        model.addAttribute("user", loginUser);
        //普通用户
        if (loginUser.getType() == 0) {
            return "/user/home";
        }
        //管理员
        else {
            return "/admin/home";
        }
    }

    /**
     * 用户注册
     * @param
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    private String register(HttpServletRequest request, User user, Model model)
    {
        if (!userService.register(user)) {
            model.addAttribute("errMsg", "注册失败");
            return "/user/register";
        }
        model.addAttribute("errMsg", "注册成功!");
        return "/user/login";
    }


    /**
     * 修改密码
     * @param
     * @return
     */
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    private String changePassword(HttpServletRequest request, User user, Model model)
    {
        if (!userService.changePassword(user)) {
            model.addAttribute("user", user);
            model.addAttribute("errMsg", "邮箱错误");
            return "/user/changePassword";
        }
        model.addAttribute("errMsg", "修改成功!");
        return "/user/login";
    }
}
