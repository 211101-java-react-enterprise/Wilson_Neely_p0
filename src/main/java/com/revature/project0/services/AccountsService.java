package com.revature.project0.services;

import com.revature.project0.DAOs.AccountsDAO;
import com.revature.project0.exceptions.ResourcePersistenceException;
import com.revature.project0.models.Accounts;
import com.revature.project0.util.Collections.LinkedList;



public class AccountsService implements DataService<Accounts>{
    private final AccountsDAO accountsDAO;

    public AccountsService(AccountsDAO DAO) {
        accountsDAO = DAO;
    }

    public Accounts authenticate(Accounts account) {
        return null;
    }

    public LinkedList<Accounts> findAll() {
        return accountsDAO.findAll();
    }

    public void updateFunds(String accountId, String amt, LinkedList<Accounts> accountsList, boolean dep){

        float amount = Float.parseFloat(amt.replaceAll("[^0-9.]",""));

        if (amount <= 0){
            System.out.println("Incorrect amount.");
            return;
        }
        boolean idFound = false;
        for(int i = 0; i < accountsList.size(); i++){
            if(accountId.equals(String.valueOf(accountsList.get(i).getId()))){
                idFound = true;
            }
        }
        if(idFound){
            if(dep) {
                accountsDAO.deposit(accountId, amount);
            } else{
                accountsDAO.deposit(accountId, -amount);
            }
        }else{
            System.out.println("Invalid account ID");
        }
    }

    @Override
    public boolean register(Accounts account) {
        Accounts registeredAccount = accountsDAO.save(account);
        if(registeredAccount == null){
            throw new ResourcePersistenceException("The user could not be persisted to the datasource!");
        }
        return true;
    }

    @Override
    public boolean validate(Accounts account) {
        return false;
    }
}
