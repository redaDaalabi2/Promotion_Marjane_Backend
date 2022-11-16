package Servlets.ResponsapleRayon;

import Controllers.ProduitController;
import Controllers.PromotionController;
import Entity.Produit;
import Entity.Promotion;
import Services.Variable;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.xml.validation.Validator;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DashboardResponsableRayonServlet", value = "/DashboardResponsableRayonServlet")
public class DashboardResponsableRayonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        Cookie[] cookies = request.getCookies();
        String IdResponsableRayon = "0";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("IdResponsableRayon")) {
                IdResponsableRayon = cookie.getValue();
            }
        }
        if (IdResponsableRayon.equals("0")) {
            response.sendRedirect("./ResponsapleRayonLoginServlet");
        }else {
            if (path.equals("/ResponsableRayonDashboardServlet.DashboardResponsableRayonServlet")) {
                request.getRequestDispatcher("./Views/ResponsableRayon/DashboardResponsableRayon.jsp").forward(request, response);
            }
            if (path.equals("/ResponsableRayonProduitServlet.DashboardResponsableRayonServlet")){
                ProduitController produitController = new ProduitController();
                List<Produit> produites = produitController.getAllProduits();
                request.setAttribute("produits", produites);
                request.getRequestDispatcher("./Views/ResponsableRayon/ProduitResponsableRayon.jsp").forward(request, response);
            }
            if (path.equals("/ResponsableRayonPromotionServlet.DashboardResponsableRayonServlet")) {
                PromotionController promotionController = new PromotionController();
                List<Promotion> promotions = promotionController.getAllPromotionsResponssableRayon();
                request.setAttribute("promotions", promotions);
                request.getRequestDispatcher("./Views/ResponsableRayon/PromotionResponsablerayon.jsp").forward(request, response);
            }
            if (path.equals("/ResponsableRayonLogoutServlet.DashboardResponsableRayonServlet")) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("IdResponsableRayon")) {
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }
                response.sendRedirect("./ResponsapleRayonLoginServlet");
            }
            if (path.equals("/ResponsableRayonAccepterServlet.DashboardResponsableRayonServlet")){
                int id = Integer.parseInt(request.getParameter("id_promo"));
                String status = Variable.status.Accepter.toString();
                PromotionController.updatePromotionStatus(id, status);
                response.sendRedirect("./ResponsableRayonPromotionServlet.DashboardResponsableRayonServlet");
            }
            if (path.equals("/ResponsableRayonRefuserServlet.DashboardResponsableRayonServlet")){
                int id = Integer.parseInt(request.getParameter("id_promo"));
                String status = Variable.status.Refuser.toString();
                PromotionController.updatePromotionStatus(id, status);
                response.sendRedirect("./ResponsableRayonPromotionServlet.DashboardResponsableRayonServlet");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
