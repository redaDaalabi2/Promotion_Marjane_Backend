package Servlets.SuperAdmin;

import Controllers.CentreController;
import Entity.Centre;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "getAllCenterServlet", value = "/getAllCenterServlet")
public class getAllCenterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CentreController centreController = new CentreController();
        List<Centre> centres = centreController.getAllCentres();
        request.setAttribute("centres", centres);
        request.getRequestDispatcher("./Views/SuperAdmin/CenterAdmin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
