import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/")

public class HelloServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(HelloServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        // 从 session 中获取 name
        String lastName = (String) req.getSession().getAttribute("name");

        logger.info("lastName:" + lastName);

        String name = req.getParameter("name");
        if (name == null) {
            name = "world";
        }

        req.getSession().setAttribute("name", name);
        PrintWriter pw = resp.getWriter();
        pw.write("<h1>hello," + name + "</h1>");
        pw.flush();
    }
}
