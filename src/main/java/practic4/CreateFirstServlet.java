package practic4;

import practic2.DB;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/createFirst")
public class CreateFirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/createFirst.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String idHuman = request.getParameter("idHuman");
        System.out.println(idHuman);
        String salary = request.getParameter("salary");
        System.out.println(salary);
        String gender = request.getParameter("gender");
        System.out.println(gender);
        try {
            new DB().createFirst(idHuman,salary,gender);
            response.sendRedirect(request.getContextPath());
        } catch (Exception exception) {
            getServletContext().getRequestDispatcher("/errors.jsp").forward(request, response);
            throw new RuntimeException(exception.getMessage());
        }
    }
}
