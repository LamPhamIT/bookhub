package com.shinntl.controller.Web;

import com.shinntl.constant.SystemConstant;
import com.shinntl.model.User;
import com.shinntl.services.impl.UserService;
import com.shinntl.services.iservice.IUserService;
import com.shinntl.utils.FormUtil;
import com.shinntl.utils.SessionUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/trang-chu", "/dang-nhap"})
public class HomeController extends HttpServlet {
//    @Inject
    private IUserService userService;
    public HomeController() {
        userService = new UserService();
    }
    ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action != null && action.equals("login")) {
            String message = request.getParameter("message");
            String alert = request.getParameter("alert");
            if(message != null && alert != null) {
                request.setAttribute("message", resourceBundle.getString(message));
                request.setAttribute("alert", alert);
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher( "/views/Login.jsp");
            requestDispatcher.forward(request, response);
        } else if(action != null && action.equals("logout")) {
            SessionUtil.getInstance().removeValue(request, SystemConstant.USER_ROLE);
            response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login");
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/Home.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action != null && action.equals("login")) {
            User user = FormUtil.toModel(User.class, request);
            user = userService.findByUsernameAndPassword(user.getUserName(), user.getPassword());
            if(user != null) {
                SessionUtil.getInstance().putValue(request, SystemConstant.USER_MODEL, user);
                if(user.getRole().getName().equals(SystemConstant.USER_ROLE)) {
                    response.sendRedirect(request.getContextPath() + "/trang-chu");
                } else if(user.getRole().getName().equals(SystemConstant.ADMIN_ROLE)) {
                    response.sendRedirect(request.getContextPath() + "/admin-home");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=username_password_invalid&alert=danger");
            }
        }
    }
}
