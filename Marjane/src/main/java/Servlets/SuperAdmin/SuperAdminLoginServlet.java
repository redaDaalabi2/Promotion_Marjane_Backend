package Servlets.SuperAdmin;

import Controllers.AuthentificationController;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SuperAdminLoginServlet", value = "/SuperAdminLoginServlet")
public class SuperAdminLoginServlet extends HttpServlet {
    AuthentificationController authentificationController = new AuthentificationController();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./Views/SuperAdmin/LoginSuperAdmin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get value of input
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            if(authentificationController.isSuperadminAuth(email, password) != null){
                response.sendRedirect("./SuperAdminDashboardServlet");
            }else{
                response.sendRedirect("./SuperAdminLoginServlet");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
