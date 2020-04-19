package controllers;

import database.DBManager;
import entity.DisciplinaEvalucion;
import entity.ProgresosDeStudentes;
import entity.Term;
import utils.LangChange;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

@WebServlet(name = "StudentProgressController",urlPatterns = "/studentsProgress")
public class StudentProgressController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStudent = req.getParameter("idProgStud");

        String idTerm = req.getParameter("term_name");
        List<ProgresosDeStudentes> terms = DBManager.getProgress(idStudent);
        req.setAttribute("terms",terms);
        ResourceBundle term_name = ResourceBundle.getBundle("locale");
        req.setAttribute("term_name_part", term_name.getObject("term_"));


        if (terms.size()!=0) {
            if (idTerm == null) {
                req.setAttribute("selestedTerm", terms.get(0));
            } else {
                req.setAttribute("selestedTerm", terms.get(Integer.parseInt(idTerm)));

            }
        }

        req.setAttribute("currentPage", "/WEB-INF/jsp/studentProgress.jsp");
        req.getRequestDispatcher("/WEB-INF/jsp/template.jsp").forward(req, resp);
    }
}
