package Servlets.Admin;

import Controllers.CategorieController;
import Controllers.ProduitController;
import Controllers.ResponsableRayonController;
import Entity.Categorie;
import Entity.Produit;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DashboardAdminServlet", value = "/DashboardAdminServlet")
public class DashboardAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/AdminCategorieServlet.DashboardAdminServlet")) {
            CategorieController categorieController = new CategorieController();
            List<Categorie> categories = categorieController.getAllCategorie();
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("./Views/Admin/CategorieAdmin.jsp").forward(request, response);
        }
        if (path.equals("/AdminDashboardServlet.DashboardAdminServlet")) {
            request.getRequestDispatcher("./Views/Admin/DashboardAdmin.jsp").forward(request, response);
        }
        if (path.equals("/AdminProduitServlet.DashboardAdminServlet")) {
            ProduitController produitController = new ProduitController();
            List<Produit> produits = produitController.getAllProduits();
            request.setAttribute("produits", produits);
            request.getRequestDispatcher("./Views/Admin/ProduitAdmin.jsp").forward(request, response);
        }
        if (path.equals("/CreateResponsableRayonServlet.DashboardAdminServlet")) {
            CategorieController categorieController = new CategorieController();
            List<Categorie> categories = categorieController.getAllCategorie();
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("./Views/Admin/CreateResponsableRayon.jsp").forward(request, response);
        }
        if (path.equals("/AdminPromotionServlet.DashboardAdminServlet")){
            request.getRequestDispatcher("./Views/Admin/PromotionAdmin.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //switch case
        String path = request.getServletPath();
        switch (path) {
            case "/AdminCategorieServlet.DashboardAdminServlet":
                break;
            case "/AdminDashboardServlet.DashboardAdminServlet":
                break;
            case "/AdminProduitServlet.DashboardAdminServlet":
                break;
            case "/CreateResponsableRayonServlet.DashboardAdminServlet":
                {
                    ResponsableRayonController responsableRayonController = new ResponsableRayonController();
                    String prenom = request.getParameter("prenom");
                    String nom = request.getParameter("nom");
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    Integer categorie_id = Integer.valueOf(request.getParameter("categorie_id"));

                    try {
                        if (responsableRayonController.CreateResponsableRayon(nom, prenom, email, password, categorie_id)) {
                            response.sendRedirect("./CreateResponsableRayonServlet.DashboardAdminServlet");
                        } else {
                            response.sendRedirect("./AdminDashboardServlet.DashboardAdminServlet");
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            break;
        }
    }
}
