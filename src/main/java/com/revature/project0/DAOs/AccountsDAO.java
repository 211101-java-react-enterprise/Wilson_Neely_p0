package com.revature.project0.DAOs;

import com.revature.project0.models.Accounts;
import com.revature.project0.util.Collections.LinkedList;
import com.revature.project0.util.DataSource.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AccountsDAO implements CrudDAO<Accounts>{

    public void deposit(String accountId, float amount){
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "insert into solo_transactions (account, amount) values (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, accountId);
            pstmt.setString(2, String.valueOf(amount));
    } catch(SQLException e) {
            // TODO get a logger here
            e.printStackTrace();
        }
    }

    @Override
    public Accounts save(Accounts newAcc) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "insert into accounts (name, type, balance, creator) values (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newAcc.getName());
            pstmt.setString(2, newAcc.getType());
            pstmt.setString(3, String.valueOf(newAcc.getBalance()));
            pstmt.setString(2, newAcc.getCreator());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {
                return newAcc;
            }

        } catch (SQLException e) {
            // TODO get a logger here
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public Accounts findById(String id) {
        return null;
    }

    @Override
    public LinkedList<Accounts> findAll() {
        return null;
    }

    @Override
    public boolean update(Accounts updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }
}
