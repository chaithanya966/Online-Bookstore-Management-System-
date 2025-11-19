package com.vcube.handlers;
import com.vcube.repository.BookRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name="BooksHandler", urlPatterns = {"/books"})
public class BooksHandler extends HttpServlet {
    private BookRepository repo = new BookRepository();
    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("books", repo.findAll());
        req.getRequestDispatcher("/books.jsp").forward(req, resp);
    }
}
