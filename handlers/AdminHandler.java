package com.vcube.handlers;
import com.vcube.repository.BookRepository;
import com.vcube.models.Book;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;

@WebServlet(name="AdminHandler", urlPatterns = {"/handlers/AdminHandler"})
public class AdminHandler extends jakarta.servlet.http.HttpServlet {
    private BookRepository repo = new BookRepository();
    protected void doGet(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("books", repo.findAll());
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }
    protected void doPost(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        Book b = new Book();
        b.setTitle(req.getParameter("title"));
        b.setAuthor(req.getParameter("author"));
        b.setPrice(Double.parseDouble(req.getParameter("price")));
        b.setStock(Integer.parseInt(req.getParameter("stock")));
        repo.save(b);
        resp.sendRedirect(req.getContextPath()+"/handlers/AdminHandler");
    }
}
