package Servlets.SuperAdmin;

import Controllers.AdminController;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CreateAdminServlet", value = "/CreateAdminServlet")
public class CreateAdminServlet extends HttpServlet {
    AdminController adminController = new AdminController();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./Views/SuperAdmin/CreateAdmin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            if(adminController.CreateAdmin(nom, prenom, email, password, 10)){
                response.sendRedirect("./CreateAdminServlet");
            }else {
                response.sendRedirect("./SuperAdminDashboardServlet");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
