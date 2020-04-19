package controllers;

import database.DBManager;
import entity.Language;
import entity.Studentes;
import utils.LangChange;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet(name = "Autentificathion", urlPatterns = "/autentificathion")
public class Autentificathion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        LangChange langChange =new LangChange();
//        langChange.langChange(req,resp,req.getRequestURI().toString());
        req.setAttribute("currentPage", "/WEB-INF/jsp/autentifacathion.jsp");

        req.getRequestDispatcher("/WEB-INF/jsp/template.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pas = req.getParameter("pass");
        String role = req.getParameter("role");
        boolean access = DBManager.getAccauntByLoginPasswordRole(login, pas, role);
        if (access) {
            req.getSession().setAttribute("isLogin", 1);
            req.getSession().setAttribute("role", role);
            req.getSession().setAttribute("userName", login);
            req.setAttribute("currentPage", "/WEB-INF/jsp/home.jsp");
            LangChange langChange =new LangChange();
            langChange.langChange(req,resp,"/");
            req.getRequestDispatcher("/WEB-INF/jsp/template.jsp").forward(req, resp);
        } else {
            req.setAttribute("errorMassage", "1");
            req.setAttribute("currentPage", "/WEB-INF/jsp/autentifacathion.jsp");
            LangChange langChange =new LangChange();
            langChange.langChange(req,resp,"/autentificathion");
            req.getRequestDispatcher("/WEB-INF/jsp/template.jsp").forward(req, resp);
        }
//        req.setAttribute("currentPage", "/WEB-INF/jsp/autentifacathion.jsp");
//        req.getRequestDispatcher("/WEB-INF/jsp/template.jsp").forward(req, resp);
    }
}
