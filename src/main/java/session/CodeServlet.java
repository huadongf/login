package session;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "CodeServlet",urlPatterns = {"/code"})
public class CodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)throws IOException {
        BufferedImage image = new BufferedImage(100,30,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random r = new Random();
        g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
        g.fillRect(0, 0, 100, 30);
        String number = getNumber();
        HttpSession session = request.getSession();
        session.setAttribute("code", number);
        g.setColor(new Color(0,0,0));
        g.setFont(new Font(null,Font.BOLD,24));
        g.drawString(number, 5, 25);
        for(int i=0;i<30;i++){
            g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255),r.nextInt(255)));
            g.drawLine(r.nextInt(100), r.nextInt(30), r.nextInt(100), r.nextInt(30));
        }
        response.setContentType("img/jpg");
        OutputStream ops = response.getOutputStream();
        ImageIO.write(image,"jpg",ops);
        ops.close();
    }
    private String getNumber() {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789qwertyuiopasdfghjklzxcvbnm";
        StringBuilder number = new StringBuilder();
        Random r = new Random();
        for(int i = 0; i< 5; i++)
            number.append(str.charAt(r.nextInt(str.length())));
        return number.toString();
    }
}