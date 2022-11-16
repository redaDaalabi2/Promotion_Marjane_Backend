package Servlets.Admin;

import Controllers.AuthentificationController;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", value = "/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    AuthentificationController authentificationController = new AuthentificationController();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./Views/Admin/LoginAdmin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get value of input
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            if(authentificationController.isAdminAuth(email, password) != null){
                Cookie cookie = new Cookie("IdAdmin", String.valueOf(authentificationController.isAdminAuth(email, password).getId()));  //create cookie
                cookie.setMaxAge(60 * 60);  //set cookie age to 1 hour
                response.addCookie(cookie);  //add cookie to response
                request.setAttribute("IdAdmin", authentificationController.isAdminAuth(email, password).getId());
                response.sendRedirect("./AdminDashboardServlet.DashboardAdminServlet");
            }else{
                response.sendRedirect("./AdminLoginServlet");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
