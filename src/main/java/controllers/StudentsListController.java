package controllers;

import database.DBManager;
import entity.Discipline;
import entity.Studentes;
import utils.LangChange;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentsListController",urlPatterns = "/studentsList")
public class StudentsListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Studentes> studentes = DBManager.getAllActiveStudentes();
        req.setAttribute("student",studentes);
//        LangChange langChange =new LangChange();
//        langChange.langChange(req,resp,req.getRequestURI());

        req.setAttribute("currentPage", "/WEB-INF/jsp/studentsList.jsp");
        req.getRequestDispatcher("/WEB-INF/jsp/template.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("idsDeleteStud");
        DBManager.deleteStudentes(ids);
        resp.sendRedirect("/studentsList");
    }
}
