package Servlets.Admin;

import Controllers.CategorieController;
import Controllers.ResponsableRayonController;
import Entity.Categorie;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CreateResponsableRayonServlet", value = "/CreateResponsableRayonServlet")
public class CreateResponsableRayonServlet extends HttpServlet {
    ResponsableRayonController responsableRayonController = new ResponsableRayonController();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategorieController categorieController = new CategorieController();
        List<Categorie> categories = categorieController.getAllCategorie();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("./Views/Admin/CreateResponsableRayon.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Integer categorie_id = Integer.valueOf(request.getParameter("categorie_id"));

        try {
            if (responsableRayonController.CreateResponsableRayon(nom, prenom, email, password, categorie_id)) {
                response.sendRedirect("./CreateResponsableRayonServlet");
            } else {
                response.sendRedirect("./AdminDashboardServlet");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
