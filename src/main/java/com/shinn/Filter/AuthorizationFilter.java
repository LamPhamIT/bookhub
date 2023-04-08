package com.shinn.Filter;

import com.shinn.constant.SystemConstant;
import com.shinn.model.User;
import com.shinn.utils.SessionUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.servlet.*;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    private ServletContext servletContext;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        if(url.startsWith("/admin")) {
            User user = (User) SessionUtil.getInstance().getValue(request, SystemConstant.USER_ROLE);
            if(user != null) {
                if(user.getRole().getName().equals(SystemConstant.ADMIN_ROLE)) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else if(user.getRole().getName().equals(SystemConstant.USER_ROLE)){
                    response.sendRedirect("/dang-nhap?action=login&message=not_permission&alert=danger");
                }
            } else {
                response.sendRedirect("/dang-nhap?action=login&message=not_login&alert=danger");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
