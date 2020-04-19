package controllers;

import database.DBManager;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "DisciplinasModificationController", urlPatterns = "/disciplineModifying")
public class DisciplinasModificationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idDisciplina = req.getParameter("idModifyDisc");
        Discipline discipline = DBManager.getDisciplinesByID(idDisciplina);
        req.setAttribute("disc",discipline);
        req.setAttribute("currentPage", "/WEB-INF/jsp/disciplineModifying.jsp");
        req.getRequestDispatcher("/WEB-INF/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String newName= req.getParameter("discName");
        String idDisciplina  =req.getParameter("idModifyDiscipline");
        DBManager.changeDisciplines(idDisciplina,newName);
        resp.sendRedirect("/disciplines");
    }
}
