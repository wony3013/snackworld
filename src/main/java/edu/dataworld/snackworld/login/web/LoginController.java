package edu.dataworld.snackworld.login.web;

import edu.dataworld.snackworld.standard.service.StandardService;
import edu.dataworld.snackworld.standard.service.StandardVO;
import edu.dataworld.snackworld.user.service.UserService;
import edu.dataworld.snackworld.user.service.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Controller
@RequestMapping(value="/login")
public class LoginController {

    public static UserVO currentUser;

    @Resource(name="UserService")
    private UserService userService;

    @Resource(name="StandardService")
    private StandardService standardService;

    @RequestMapping("/loginForm.do")
    public String loginForm(Model model, String ok) {
        return "/login/loginForm.view";
    }

    @RequestMapping(value = "/loginAction.do", method = RequestMethod.POST)
    public String loginAction(UserVO vo, HttpServletResponse response, HttpSession session) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        if(session.getAttribute("login") != null){
            session.removeAttribute("login");
        }
        UserVO currentUser = userService.getUserByLoginId(vo.getUserId());

        if(currentUser == null) {
            out.println("<script>");
            out.println("alert('존재하지 않는 아이디 입니다');");
            out.println("history.go(-1);");
            out.println("</script>");
            out.close();
            return "/login/loginForm.view";
        }

        if(currentUser.getUserPw().equals(vo.getUserPw()) == false) {
            out.println("<script>");
            out.println("alert('비밀번호가 일치하지 않습니다.');");
            out.println("history.go(-1);");
            out.println("</script>");
            out.close();
            return "/login/loginForm.view";
        }

        session.setAttribute("login", currentUser.getUserId());
        session.setAttribute("auth", currentUser.getAuthId());
        //카운트 로직

        StandardVO standardVo = standardService.getUserStandard(currentUser.getUserId());

        session.setAttribute("order_amt", standardVo.getOrderAmt());
        session.setAttribute("user_amt", standardVo.getUserAmt());

        return "redirect:/home/main.do";

    }

    @RequestMapping(value = "/logoutAction.do")
    public String logoutAction(HttpServletResponse response, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null)
            session.invalidate();

        return "redirect:/login/loginForm.do";
    }
}
