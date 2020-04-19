package utils;

import database.DBManager;
import entity.Language;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class LangChange {
    public void langChange(HttpServletRequest req, HttpServletResponse resp, String urlPatterns){
        String shortLeng_sis = "";
        if (req.getSession().getAttribute("language") ==null) {
            if (req.getLocale().getLanguage().equals("es")) {
                shortLeng_sis = "es_ES";
            } else if (req.getLocale().getLanguage().equals("en")) {
                shortLeng_sis = "en_EN";
            } else {
                shortLeng_sis = "ru_RU";
            }
        }
        else{
            shortLeng_sis = req.getSession().getAttribute("language").toString();
        }

        String duble_language_page = req.getParameter("duble_language_page");

           if  (duble_language_page == null  ) {
           req.getSession().setAttribute("language", shortLeng_sis);
            req.setAttribute("language_ch",shortLeng_sis);
        } else {
            req.getSession().setAttribute("language", duble_language_page);
            req.setAttribute("language_ch",duble_language_page);
        }
        req.setAttribute("urlPatterns",urlPatterns);
//        req.setAttribute("language_ch", req.getSession().getAttribute("language"));
        List<Language> language_list = DBManager.language();
        req.setAttribute("language_list", language_list);
    }

}
