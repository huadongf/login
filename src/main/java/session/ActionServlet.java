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
        // 设置编码
        request.setCharacterEncoding("utf-8");
        // 获得session
        HttpSession session = request.getSession();
        // 获得请求路径
        String uri = request.getRequestURI();
        System.out.println(uri);
        // 拆分路径,只保留login.do中的login
        String action;
        if(uri.lastIndexOf(".")!=-1)
        action = uri.substring(uri.lastIndexOf("/") + 1,uri.lastIndexOf("."));
        else
            action=uri.substring(uri.lastIndexOf("/")+1,uri.length()-1);
        System.out.println(action);
        // 判断请求路径是否为登录
        if (action.equals("login")) {
            String uname = request.getParameter("uname");
            String pwd = request.getParameter("pwd");
            //获得用户提交的验证码字符
            String vcode = request.getParameter("vcode");
            //获得session中存储的最新验证码字符
            String code = session.getAttribute("code").toString();
            if (code.equals(vcode) &&uname.equals("123") && pwd.equals("123") ) {
                // 将登录的用户绑定到session
                session.setAttribute("uname", uname);
                // 重定向到index.jsp
				response.sendRedirect("index.jsp");
                //如果禁用了Cookie,使用URL重写
        //        response.sendRedirect(response.encodeRedirectURL("index.jsp"));
            } else {
                // 登录失败,就转发到login.jsp
                request.setAttribute("msg", "输入有误,请重新登录!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }else if(action.equals("logout")){
            //使session失效
            session.invalidate();
            response.sendRedirect("login.jsp");
        }
    }
}