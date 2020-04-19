package controllers;

import database.DBManager;
import utils.LangChange;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

@WebServlet(name = "StudentesCreating", urlPatterns = "/students-create")
public class StudentesCreating extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        LangChange langChange =new LangChange();
//        langChange.langChange(req,resp,req.getRequestURI());
        req.setAttribute("currentPage", "/WEB-INF/jsp/studentCreating.jsp");
        req.getRequestDispatcher("/WEB-INF/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String stname= req.getParameter("stname");
        String stsurname= req.getParameter("stsurname");
        String stgrupa= req.getParameter("stgrupa");
        String date = req.getParameter("stdate_aprobarse");



        SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {

            String reformattedStr = myFormat.format(fromUser.parse(date));
            DBManager.insertStudents( stname,  stsurname,  stgrupa,  reformattedStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        resp.sendRedirect("/studentsList");


    }
}
