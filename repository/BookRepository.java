package com.vcube.repository;
import com.vcube.models.Book;
import com.vcube.helpers.DBConnection;
import java.sql.*;
import java.util.*;
public class BookRepository {
    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Book b = new Book();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                b.setPrice(rs.getDouble("price"));
                b.setStock(rs.getInt("stock"));
                b.setDescription(rs.getString("description"));
                list.add(b);
            }
        } catch(Exception e){ e.printStackTrace(); }
        return list;
    }

    public Book findById(int id){
        String sql = "SELECT * FROM books WHERE id=?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)){
            ps.setInt(1,id);
            try(ResultSet rs=ps.executeQuery()){
                if(rs.next()){
                    Book b=new Book();
                    b.setId(rs.getInt("id"));
                    b.setTitle(rs.getString("title"));
                    b.setAuthor(rs.getString("author"));
                    b.setPrice(rs.getDouble("price"));
                    b.setStock(rs.getInt("stock"));
                    b.setDescription(rs.getString("description"));
                    return b;
                }
            }
        } catch(Exception e){ e.printStackTrace(); }
        return null;
    }

    public boolean save(Book b){
        String sql = "INSERT INTO books(title,author,price,stock,description) VALUES(?,?,?,?,?)";
        try(Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1,b.getTitle());
            ps.setString(2,b.getAuthor());
            ps.setDouble(3,b.getPrice());
            ps.setInt(4,b.getStock());
            ps.setString(5,b.getDescription());
            return ps.executeUpdate()>0;
        } catch(Exception e){ e.printStackTrace(); }
        return false;
    }
}
