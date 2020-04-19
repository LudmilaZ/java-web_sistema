package controllers;


import database.DBManager;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

@WebServlet(name = "TermCreating", urlPatterns = "/termsCreating")
public class TermCreating  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Discipline> disciplines = DBManager.getAllActiveDisciplines();
        req.setAttribute("disces",disciplines);
        req.setAttribute("currentPage", "/WEB-INF/jsp/termCreating.jsp");
        req.getRequestDispatcher("/WEB-INF/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String ids = req.getParameter("idsCreatingTerm");

        String[] disciplinesEligido = req.getParameterValues("formControlSelect[]");
        String tiempo_term = req.getParameter("tiempo_term");
        DBManager.createTerms(disciplinesEligido, tiempo_term);
        resp.sendRedirect("/termsList");
    }

}
