package com.vcube.repository;
import com.vcube.models.User;
import com.vcube.helpers.DBConnection;
import java.sql.*;
public class UserRepository {
    public User authenticate(String username, String password){
        String sql = "SELECT id,username,role FROM users WHERE username=? AND password=?";
        try(Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1, username);
            ps.setString(2, password);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return new User(rs.getInt("id"), rs.getString("username"), rs.getString("role"));
                }
            }
        } catch(Exception e){ e.printStackTrace(); }
        return null;
    }
}
