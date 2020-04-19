package filters;


import utils.CoociesUtils;
import utils.LangChange;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.util.Locale;

public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest  req =(HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        Cookie [] cookies = req.getCookies();
        if (CoociesUtils.isContainCookies(cookies,"countPage")){
        int count=  Integer.parseInt(CoociesUtils.getCookieByName("countPage",cookies).getValue());
            count++;
            Cookie cookie= new Cookie("countPage",""+count);
            resp.addCookie(cookie);
        }
        else {
            Cookie cookie= new Cookie("countPage","1");
            resp.addCookie(cookie);
        }
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        LangChange langChange =new LangChange();
        langChange.langChange(req,resp,req.getRequestURI());
        filterChain.doFilter(req,resp);

    }

    @Override
    public void destroy() {

    }
}
