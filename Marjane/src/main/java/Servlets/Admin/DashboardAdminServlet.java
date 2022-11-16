package Servlets.Admin;

import Controllers.CategorieController;
import Controllers.ProduitController;
import Controllers.PromotionController;
import Controllers.ResponsableRayonController;
import Entity.Categorie;
import Entity.Produit;
import Entity.Promotion;
import Services.Variable;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "DashboardAdminServlet", value = "/DashboardAdminServlet")
public class DashboardAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        Cookie[] cookies = request.getCookies();
        String IdAdmin = "0";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("IdAdmin")) {
                IdAdmin = cookie.getValue();
            }
        }
        if (IdAdmin.equals("0")) {
            response.sendRedirect("./AdminLoginServlet");
        }else {
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
            if (path.equals("/AdminPromotionServlet.DashboardAdminServlet")) {
                int id = Integer.valueOf(request.getParameter("id"));
                ProduitController produitController = new ProduitController();
                produitController.getProduitById(id).ifPresent(produit -> request.setAttribute("produit", produit));
                request.getRequestDispatcher("./Views/Admin/PromotionAdmin.jsp").forward(request, response);
            }
            if(path.equals("/AdmingetAllPromotionServlet.DashboardAdminServlet")){
                PromotionController promotionController = new PromotionController();
                List<Promotion> promotions = promotionController.getAllPromotions();
                request.setAttribute("promotions", promotions);
                request.getRequestDispatcher("./Views/Admin/getAllPromotionAdmin.jsp").forward(request, response);
            }
            if (path.equals("/CreatePromotionServlet.DashboardAdminServlet")) {
                request.getRequestDispatcher("./Views/Admin/PromotionAdmin.jsp").forward(request, response);
            }
            if (path.equals("/LogoutAdminServlet.DashboardAdminServlet")) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("IdAdmin")) {
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }
                response.sendRedirect("./AdminLoginServlet");
            }
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
            case "/CreatePromotionServlet.DashboardAdminServlet":
            {
                Promotion promotion = new Promotion();
                int produit_id = Integer.valueOf(request.getParameter("produit_id"));
                float taux = Float.valueOf(request.getParameter("taux"));
                long points_fidelite = Long.valueOf(request.getParameter("points_fidelite"));
                LocalDate date_fin = LocalDate.parse(request.getParameter("date_fin"));
                PromotionController promotionController = new PromotionController();
                String status = Variable.status.Encours.toString();
                promotionController.ajouterPromotion(produit_id, status, taux, promotion, points_fidelite, date_fin);
                response.sendRedirect("./AdmingetAllPromotionServlet.DashboardAdminServlet");
            }
            break;
        }
    }
}
