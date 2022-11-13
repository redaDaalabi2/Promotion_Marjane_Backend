package Servlets.ResponsapleRayon;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DashboardResponsableRayonServlet", value = "/DashboardResponsableRayonServlet")
public class DashboardResponsableRayonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/ResponsableRayonDashboardServlet.DashboardResponsableRayonServlet")){
            request.getRequestDispatcher("./Views/ResponsableRayon/DashboardResponsableRayon.jsp").forward(request, response);
        }
        if(path.equals("/ResponsableRayonPromotionServlet.DashboardResponsableRayonServlet")){
            request.getRequestDispatcher("./Views/ResponsableRayon/PromotionResponsablerayon.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
