package com.vcube.handlers;
import com.vcube.models.CartItem;
import com.vcube.models.User;
import com.vcube.helpers.DBConnection;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

@WebServlet(name="CheckoutHandler", urlPatterns = {"/handlers/CheckoutHandler"})
public class CheckoutHandler extends jakarta.servlet.http.HttpServlet {
    protected void doPost(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        HttpSession s = req.getSession(false);
        if(s==null || s.getAttribute("user")==null){
            resp.sendRedirect(req.getContextPath()+"/handlers/LoginHandler"); return;
        }
        User user = (User) s.getAttribute("user");
        List<CartItem> cart = (List<CartItem>) s.getAttribute("cart");
        if(cart==null || cart.isEmpty()){ resp.sendRedirect(req.getContextPath()+"/books"); return; }

        double total = cart.stream().mapToDouble(ci -> ci.getBook().getPrice()*ci.getQty()).sum();

        try(Connection c = DBConnection.getConnection()){
            c.setAutoCommit(false);
            String insertOrder = "INSERT INTO orders(user_id,total) VALUES(?,?)";
            try(PreparedStatement ps = c.prepareStatement(insertOrder, PreparedStatement.RETURN_GENERATED_KEYS)){
                ps.setInt(1, user.getId());
                ps.setDouble(2, total);
                ps.executeUpdate();
                var rs = ps.getGeneratedKeys();
                if(rs.next()){
                    int orderId = rs.getInt(1);
                    String insertItem = "INSERT INTO order_items(order_id,book_id,qty,price) VALUES(?,?,?,?)";
                    try(PreparedStatement psi = c.prepareStatement(insertItem)){
                        for(CartItem it: cart){
                            psi.setInt(1, orderId);
                            psi.setInt(2, it.getBook().getId());
                            psi.setInt(3, it.getQty());
                            psi.setDouble(4, it.getBook().getPrice());
                            psi.addBatch();
                        }
                        psi.executeBatch();
                    }
                }
            }
            c.commit();
            s.removeAttribute("cart");
            req.getRequestDispatcher("/checkout-success.jsp").forward(req, resp);
        } catch(Exception e){
            e.printStackTrace();
            resp.sendError(500, "Checkout failed");
        }
    }
}
