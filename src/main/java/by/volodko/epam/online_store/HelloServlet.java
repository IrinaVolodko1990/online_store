package by.volodko.epam.online_store;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = {"/controller", "/do.*"})
public class HelloServlet extends HttpServlet {


    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String num = request.getParameter("input_n");
        try {
            int result = Integer.parseInt(num) * 5;
            request.setAttribute("res", result);
        } catch (NumberFormatException e ){
            throw new RuntimeException(e);

        }
        request.getRequestDispatcher("/pages/result.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void destroy() {
    }
}