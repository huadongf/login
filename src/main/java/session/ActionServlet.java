package session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name = "ActionServlet",urlPatterns = {"/login.do"})
public class ActionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();//
        String uri = request.getRequestURI();
        String action;
        if(uri.lastIndexOf(".")!=-1)
        action = uri.substring(uri.lastIndexOf("/") + 1,uri.lastIndexOf("."));
        else
            action=uri.substring(uri.lastIndexOf("/")+1,uri.length()-1);
        System.out.println(action);
        if (action.equals("login")) {
            String uname = request.getParameter("uname");
            String pwd = request.getParameter("pwd");
            String vcode = request.getParameter("vcode");
            String code = session.getAttribute("code").toString();
            if (code.equals(vcode))
            {
                if(uname.equals("123") && pwd.equals("123")) {
                // 将登录的用户绑定到session
                session.setAttribute("uname", uname);
                response.sendRedirect(response.encodeRedirectURL("index.jsp"));
            }
                else {
                // 登录失败,就转发到login.jsp
                request.setAttribute("msg", "用户名或密码错误!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
            }
            else
            {
                request.setAttribute("msg", "验证码错误!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }
    }
}