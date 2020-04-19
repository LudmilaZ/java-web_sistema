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
import java.util.List;

@WebServlet(name = "TermModify", urlPatterns = "/termModifying")
public class TermModify extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idTerm = req.getParameter("term_name_dublicat");
        req.setAttribute("term_name", idTerm);
        List<Term> disciplines = DBManager.getDisciplinesByTerm(idTerm);
        if (disciplines.size()!=0) {
        req.setAttribute("disces", disciplines.get(0));
            req.setAttribute("listDisciplin", disciplines.get(0).getDiscipList());
        disciplines.get(0).getDiscipList();
            for (Discipline l :disciplines.get(0).getDiscipList()
                 ) {
                int l1 =l.getIsUseInTerm();

            }
        }
        req.setAttribute("currentPage", "/WEB-INF/jsp/termModifying.jsp");
        req.getRequestDispatcher("/WEB-INF/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] disciplinesEligido = req.getParameterValues("formControlSelect[]");
        String tiempo_term = req.getParameter("tiempo_term");
        String term_name = req.getParameter("term_name");
        DBManager.updateTermByID(disciplinesEligido, tiempo_term,Integer.valueOf(term_name));
        resp.sendRedirect("/termsList?term_name="+term_name+"");
    }
}
