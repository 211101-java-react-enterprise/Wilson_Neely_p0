package com.revature.project0.DAOs;

import com.revature.project0.exceptions.ResourcePersistenceException;
import com.revature.project0.models.Accounts;
import com.revature.project0.services.UsersService;
import com.revature.project0.util.Collections.LinkedList;
import com.revature.project0.util.DataSource.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AccountsDAO implements CrudDAO<Accounts>{

    private final UsersService usersService;


    public AccountsDAO(UsersService usersService){
        super();
        this.usersService = usersService;
    }

    public void deposit(String accountId, float amount){
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT balance FROM accounts WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(accountId));
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            if (rs.getFloat("balance") + amount <= 0){
                throw new ResourcePersistenceException("Attempt to overdraw balance");
            }
            sql = "insert into solo_transactions (account, amount) values (?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(accountId));
            pstmt.setFloat(2, amount);
            pstmt.executeUpdate();
            sql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(2, Integer.parseInt(accountId));
            pstmt.setFloat(1, amount);
            pstmt.executeUpdate();
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
            pstmt.setFloat(3, newAcc.getBalance());
            pstmt.setString(4, newAcc.getCreator());

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
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM accounts WHERE creator = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, usersService.getSessionUser().getId());
            ResultSet rs = pstmt.executeQuery();
            LinkedList<Accounts> accList = new LinkedList<>();
            while(rs.next()) {
                Accounts acc = new Accounts();
                acc.setId(rs.getInt("id"));
                acc.setName(rs.getString("name"));
                acc.setType(rs.getString("type"));
                acc.setBalance(rs.getFloat("balance"));
                acc.setCreator(rs.getString("creator"));
                if(rs.getArray("accessors") == null){
                    acc.setAccessors(null);
                }
                //TODO: fix when have actual accessors on account
                //else{acc.setAccessors(new LinkedList<String>(rs.getArray("accessors").toString().split()));}
                accList.add(acc);
            }
            return accList;
        }catch (SQLException e) {
            // TODO get a logger here
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public boolean update(Accounts updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "DELETE FROM solo_transactions WHERE account = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(id));
            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted == 0) {
                return false;
            }

            sql = "DELETE FROM accounts WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(id));
            rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {
                return true;
            }
        }catch (SQLException e) {
            // TODO get a logger here
            e.printStackTrace();
        }
        return false;
    }
}
