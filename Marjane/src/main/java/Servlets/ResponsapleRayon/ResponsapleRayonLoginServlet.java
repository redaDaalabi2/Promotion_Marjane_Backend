package Servlets.ResponsapleRayon;

import Controllers.AuthentificationController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ResponsapleRayonLoginServlet", value = "/ResponsapleRayonLoginServlet")
public class ResponsapleRayonLoginServlet extends HttpServlet {
    AuthentificationController authentificationController = new AuthentificationController();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./Views/ResponsableRayon/LoginResponsableRayon.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get value of input
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            if(authentificationController.isResponsaplerayonAuth(email, password) != null){
                response.sendRedirect("./ResponsableRayonDashboardServlet");
            }else{
                response.sendRedirect("./ResponsapleRayonLoginServlet");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
