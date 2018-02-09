package com.parking.system.util.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 41988 on 2017/7/20.
 */
@WebFilter(filterName = "MemberFilter", urlPatterns = "/pages/back/member/MemberServlet/searchMember")
public class MemberFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        Cookie[] cookie = request.getCookies();

        String name=null;
        for (int i = 0; i < cookie.length; i++) {
            Cookie cook = cookie[i];
            if(cook.getName().equalsIgnoreCase("name")){ //获取键
               name = cook.getValue().toString();    //获取值
                break;
            }
        }
        if(name!=null||session.getAttribute("aid")!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }/*else {
            request.setAttribute("url","/pages/back/index.jsp");
            request.getRequestDispatcher("/pages/forward.jsp").forward(servletRequest,servletResponse);
        }*/
    }

    @Override
    public void destroy() {

    }
}
