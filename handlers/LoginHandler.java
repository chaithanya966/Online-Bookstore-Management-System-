package com.vcube.handlers;
import com.vcube.repository.UserRepository;
import com.vcube.models.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;

@WebServlet(name="LoginHandler", urlPatterns = {"/handlers/LoginHandler"})
public class LoginHandler extends jakarta.servlet.http.HttpServlet {
    private UserRepository repo = new UserRepository();
    protected void doGet(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    protected void doPost(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        String u = req.getParameter("username");
        String p = req.getParameter("password");
        User user = repo.authenticate(u,p);
        if(user!=null){
            HttpSession s = req.getSession();
            s.setAttribute("user", user);
            resp.sendRedirect(req.getContextPath()+"/books");
        } else {
            req.setAttribute("error","Invalid credentials");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
