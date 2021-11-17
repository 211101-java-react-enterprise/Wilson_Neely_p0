package com.revature.project0.DAOs;

import com.revature.project0.models.Users;
import com.revature.project0.util.Collections.List;
import com.revature.project0.util.DataSource.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UsersDAO implements CrudDAO<Users> {
    public Users findUserByUsername(String username) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select * from users where username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Users user = new Users();
                user.setId(rs.getString("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public Users findUserByEmail(String email) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select * from users where email = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Users user = new Users();
                user.setId(rs.getString("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public Users findUserByUsernameAndPassword(String username, String password) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select * from users where username = ? and password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Users user = new Users();
                user.setId(rs.getString("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public Users save(Users newUser) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            newUser.setId(UUID.randomUUID().toString());

            String sql = "insert into users (id, first_name, last_name, email, username, password) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newUser.getId());
            pstmt.setString(2, newUser.getFirstName());
            pstmt.setString(3, newUser.getLastName());
            pstmt.setString(4, newUser.getEmail());
            pstmt.setString(5, newUser.getUsername());
            pstmt.setString(6, newUser.getPassword());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {
                return newUser;
            }

        } catch (SQLException e) {
            // TODO get a logger here
            e.printStackTrace();

        }

        return null;

    }

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public Users findById(String id) {
        return null;
    }

    @Override
    public boolean update(Users updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }
}
