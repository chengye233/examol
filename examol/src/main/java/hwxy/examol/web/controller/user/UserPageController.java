package hwxy.examol.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 路由
 */
@Controller
@RequestMapping(value = "/user", method = {RequestMethod.GET})
public class UserPageController
{
    /**
     * 跳转到login.jsp
     * @return
     */
    @RequestMapping(value = "/loginPage")
    public String getLoginPage()
    {
        return "user/login";
    }

    /**
     * 跳转到home.jsp
     * @return
     */
    @RequestMapping(value = "/homePage")
    public String getHomePage(HttpServletRequest request)
    {
        if (request.getSession().getAttribute("user") == null) {
            return "/user/login";
        }
        return "/user/home";
    }


    /**
     * 跳转到register.jsp
     * @return
     */
    @RequestMapping(value = "/registerPage")
    public String getRegisterPage()
    {
        return "user/register";
    }

}
