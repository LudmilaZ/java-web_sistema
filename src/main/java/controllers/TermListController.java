package controllers;

import database.DBManager;
import entity.Discipline;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "TermListController", urlPatterns = "/termsList")
public class TermListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idTerm = req.getParameter("term_name");
//        List<Term> terms = DBManager.getAllActiveTerm();
        TreeMap<Integer, Term> terms = DBManager.getAllActiveTerm();
        req.setAttribute("terms", terms.values());

//        ResourceBundle term_name = ResourceBundle.getBundle("locale");
//
//        req.setAttribute("term_name_part", term_name.getObject("term_"));
        req.setAttribute("term_name_part", "Семестр");
        if (terms.size() != 0) {
            if (idTerm == null) {

                req.setAttribute("selestedTerm", terms.get(terms.firstKey()));

            } else {
                req.setAttribute("selestedTerm", terms.get(Integer.parseInt(idTerm)));

            }
        }
        req.setAttribute("currentPage", "/WEB-INF/jsp/termsList.jsp");
        req.getRequestDispatcher("/WEB-INF/jsp/template.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idTerm = req.getParameter("term_name_dublicatDelete");
        DBManager.deleteTerm(Integer.valueOf(idTerm));
        resp.sendRedirect("/termsList");


    }
}
