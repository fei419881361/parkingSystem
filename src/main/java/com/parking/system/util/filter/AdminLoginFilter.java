package com.parking.system.util.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/*

*
 * Created by 41988 on 2017/7/8.
*/


@WebFilter(filterName = "AdminLoginFilter",urlPatterns = {"/pages/index.jsp", "/pages/back/lenbook/*","/pages/back/member/MemberServlet/insert","/pages/back/item/ItemServlet/insert","/pages/back/books/BooksServlet/insertPro"})
public class AdminLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        if(session.getAttribute("aid")!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            request.setAttribute("msg","请登录后操作");
            request.setAttribute("url","/login.jsp");
            request.getRequestDispatcher("/pages/forward.jsp").forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
