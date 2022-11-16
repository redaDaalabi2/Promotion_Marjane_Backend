package Servlets.SuperAdmin;

import Controllers.*;
import Entity.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DashboardSuperAdminServlet", value = "/DashboardSuperAdminServlet")
public class DashboardSuperAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        Cookie[] cookies = request.getCookies();
        String IdSuperAdmin = "0";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("IdSuperAdmin")) {
                IdSuperAdmin = cookie.getValue();
            }
        }
        if (IdSuperAdmin.equals("0")) {
            response.sendRedirect("./SuperAdminLoginServlet");
        }else {
            if (path.equals("/SuperAdminDashboardServlet.DashboardSuperAdminServlet")) {
                AdminController adminController = new AdminController();
                List<Admin> CountAdmin = adminController.countAllAdmin();
                request.setAttribute("CountAdmin", CountAdmin);
                System.out.println(CountAdmin);
                request.getRequestDispatcher("./Views/SuperAdmin/DashboardSuperAdmin.jsp").forward(request, response);
            }
            if (path.equals("/getAllProduitsServlet.DashboardSuperAdminServlet")) {
                ProduitController produitController = new ProduitController();
                List<Produit> produites = produitController.getAllProduits();
                request.setAttribute("produits", produites);
                request.getRequestDispatcher("./Views/SuperAdmin/ProduitSuperAdmin.jsp").forward(request, response);
            }
            if (path.equals("/getAllCenterServlet.DashboardSuperAdminServlet")) {
                CentreController centreController = new CentreController();
                List<Centre> centres = centreController.getAllCentres();
                request.setAttribute("centres", centres);
                request.getRequestDispatcher("./Views/SuperAdmin/CenterAdmin.jsp").forward(request, response);
            }
            if (path.equals("/getAllCategoriesServlet.DashboardSuperAdminServlet")) {
                CategorieController categorieController = new CategorieController();
                List<Categorie> categories = categorieController.getAllCategorie();
                request.setAttribute("categories", categories);
                request.getRequestDispatcher("./Views/SuperAdmin/CategorieSuperAdmin.jsp").forward(request, response);
            }
            if (path.equals("/CreateAdminServlet.DashboardSuperAdminServlet")) {
                CentreController centreController = new CentreController();
                List<Centre> centres = centreController.getAllCentres();
                request.setAttribute("centres", centres);
                request.getRequestDispatcher("./Views/SuperAdmin/CreateAdmin.jsp").forward(request, response);
            }
            if (path.equals("/getAllPromotionsServlet.DashboardSuperAdminServlet")) {
                PromotionController promotionController = new PromotionController();
                List<Promotion> promotions = promotionController.getAllPromotions();
                request.setAttribute("promotions", promotions);
                request.getRequestDispatcher("./Views/SuperAdmin/PromotionSuperAdmin.jsp").forward(request, response);
            }
            if (path.equals("/LogoutSuperAdminServlet.DashboardSuperAdminServlet")) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("IdSuperAdmin")) {
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }
                response.sendRedirect("./SuperAdminLoginServlet");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path){
            case "/CreateAdminServlet.DashboardSuperAdminServlet":
            {
                AdminController adminController = new AdminController();
                String prenom = request.getParameter("prenom");
                String nom = request.getParameter("nom");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                Integer id_centre = Integer.valueOf(request.getParameter("id_centre"));
                try {
                    if (adminController.CreateAdmin(nom, prenom, email, password, id_centre)) {
                        response.sendRedirect("./CreateAdminServlet.DashboardSuperAdminServlet");
                    } else {
                        response.sendRedirect("./SuperAdminDashboardServlet.DashboardSuperAdminServlet");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
                break;
            case "/getAllProduitsServlet.DashboardSuperAdminServlet":
                break;
            case "/getAllCenterServlet.DashboardSuperAdminServlet":
                break;
            case "/getAllCategoriesServlet.DashboardSuperAdminServlet":
                break;
        }
    }
}
