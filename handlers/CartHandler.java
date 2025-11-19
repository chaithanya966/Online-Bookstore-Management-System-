package com.vcube.handlers;
import com.vcube.repository.BookRepository;
import com.vcube.models.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.*;

@WebServlet(name="CartHandler", urlPatterns = {"/handlers/CartHandler"})
public class CartHandler extends jakarta.servlet.http.HttpServlet {
    private BookRepository repo = new BookRepository();
    protected void doPost(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        int qty = Integer.parseInt(req.getParameter("qty"));
        Book b = repo.findById(bookId);
        if(b==null){ resp.sendRedirect(req.getContextPath()+"/books"); return; }
        List<CartItem> cart = (List<CartItem>) req.getSession().getAttribute("cart");
        if(cart==null){ cart = new ArrayList<>(); req.getSession().setAttribute("cart", cart); }
        cart.add(new CartItem(b, qty));
        resp.sendRedirect(req.getContextPath()+"/cart.jsp");
    }
}
