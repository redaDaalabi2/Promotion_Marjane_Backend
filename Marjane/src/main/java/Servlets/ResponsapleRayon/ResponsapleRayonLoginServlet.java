package Servlets.ResponsapleRayon;

import Controllers.AuthentificationController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
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
                Cookie cookie = new Cookie("IdResponsableRayon", String.valueOf(authentificationController.isResponsaplerayonAuth(email, password).getId()));  //create cookie
                cookie.setMaxAge(60 * 60);  //set cookie age to 1 hour
                response.addCookie(cookie);  //add cookie to response
                request.setAttribute("IdResponsableRayon", authentificationController.isResponsaplerayonAuth(email, password).getId());
                response.sendRedirect("./ResponsableRayonDashboardServlet.DashboardResponsableRayonServlet");
            }else{
                response.sendRedirect("./ResponsapleRayonLoginServlet");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
