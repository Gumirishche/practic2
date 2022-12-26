package practic4;

import practic2.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/selectSecond")
public class SelectSecond extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var db = new DB();
        var second = new Second("null","null","null");
        req.setAttribute("human", second);
        getServletContext().getRequestDispatcher("/selectSecond.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        System.out.println(id);
        try {
            Second second = new DB().findSecond(id);
            System.out.println(second.getFirstName()+"   "+ second.getLastName());
            request.setAttribute("human", second);
            getServletContext().getRequestDispatcher("/selectSecond.jsp").forward(request, response);
        } catch (Exception exception) {
            getServletContext().getRequestDispatcher("/errors.jsp").forward(request, response);
            throw new RuntimeException(exception.getMessage());
        }
    }
}