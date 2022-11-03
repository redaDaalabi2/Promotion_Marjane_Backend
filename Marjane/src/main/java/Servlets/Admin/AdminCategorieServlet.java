package Servlets.Admin;

import Controllers.CategorieController;
import Entity.Categorie;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminCategorieServlet", value = "/AdminCategorieServlet")
public class AdminCategorieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategorieController categorieController = new CategorieController();
        List<Categorie> categories = categorieController.getAllCategorie();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("./Views/Admin/CategorieAdmin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
