package Servlets.SuperAdmin;

import Controllers.AdminController;
import Controllers.CategorieController;
import Controllers.CentreController;
import Controllers.ProduitController;
import Entity.Categorie;
import Entity.Centre;
import Entity.Produit;
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
        if(path.equals("/SuperAdminDashboardServlet.DashboardSuperAdminServlet")){
            Cookie[] cookies = request.getCookies();
            String id = "0";
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id")) {
                    id = cookie.getValue();
                }
            }
            if (id.equals("0")) {
                response.sendRedirect("SuperAdminDashboardServlet.DashboardSuperAdminServlet");
            } else {
                request.getRequestDispatcher("./Views/SuperAdmin/DashboardSuperAdmin.jsp").forward(request, response);
            }
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
        if (path.equals("/getAllCategoriesServlet.DashboardSuperAdminServlet")){
            CategorieController categorieController = new CategorieController();
            List<Categorie> categories = categorieController.getAllCategorie();
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("./Views/SuperAdmin/CategorieSuperAdmin.jsp").forward(request, response);
        }
        if (path.equals("/CreateAdminServlet.DashboardSuperAdminServlet")){
            CentreController centreController = new CentreController();
            List<Centre> centres = centreController.getAllCentres();
            request.setAttribute("centres", centres);
            request.getRequestDispatcher("./Views/SuperAdmin/CreateAdmin.jsp").forward(request, response);
        }
        if (path.equals("/LogoutSuperAdminServlet.DashboardSuperAdminServlet")){
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id")) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
            response.sendRedirect("./SuperAdminLoginServlet");
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
