package practic4;

import practic2.DB;
import practic3.Human;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/deleteSecond")
public class DeleteSecond extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var db = new DB();
        try {
            ArrayList<Second> humans= new DB().getSecond2();
            req.setAttribute("humans", humans);
            getServletContext().getRequestDispatcher("/deleteSecond.jsp").forward(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        try {
            new DB().deleteSecond(Integer.parseInt(id));
            response.sendRedirect(request.getContextPath());
        } catch (Exception exception) {
            getServletContext().getRequestDispatcher("/errors.jsp").forward(request, response);
            throw new RuntimeException(exception.getMessage());
        }
    }
}
