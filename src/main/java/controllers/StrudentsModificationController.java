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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


@WebServlet(name = "StrudentsModificationController", urlPatterns = "/studentsModifying")
public class StrudentsModificationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idStudent = req.getParameter("idModifyStud");
        Studentes studente = DBManager.getStudentByID(idStudent);
       req.setAttribute("stud",studente);
//        LangChange langChange =new LangChange();
//        langChange.langChange(req,resp,req.getRequestURI());
        req.setAttribute("currentPage", "/WEB-INF/jsp/studentModifying.jsp");
        req.getRequestDispatcher("/WEB-INF/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String newName= req.getParameter("studname");
        String idStudent  =req.getParameter("idStudentsDiscipline");
        String newSurname= req.getParameter("studsurname");
        String newGrupa  =req.getParameter("studnumbergrup");
        String newdate = req.getParameter("stdate_aprobarse");



        SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            String stdate_aprobarse = myFormat.format(fromUser.parse(newdate));
            DBManager.changeStudents(newName,newSurname,newGrupa, stdate_aprobarse,idStudent);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/studentsList");
    }
}
