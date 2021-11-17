package com.revature.project0.services;

import com.revature.project0.DAOs.AccountsDAO;
import com.revature.project0.exceptions.ResourcePersistenceException;
import com.revature.project0.models.Accounts;
import com.revature.project0.models.Transactions;
import com.revature.project0.util.Collections.LinkedList;



public class AccountsService implements DataService<Accounts>{
    private final AccountsDAO accountsDAO;

    public AccountsService(AccountsDAO DAO) {
        accountsDAO = DAO;
    }

    public LinkedList<Accounts> findAll() {
        //segway to dao function
        return accountsDAO.findAll();
    }

    public void updateFunds(String accountId, String amt, LinkedList<Accounts> accountsList, boolean dep){
        //updates the amount field for an associated account
        //dep is used to determine if this is a deposit or withdrawal
        //dep = true is deposit
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
            try {
                if (dep) {
                    accountsDAO.deposit(accountId, amount);
                } else {
                    accountsDAO.deposit(accountId, -amount);
                }
            }catch (ResourcePersistenceException e){
                System.out.println("That amount would overdraw your account, try again.");
            }
        }else{
            System.out.println("Invalid account ID");
        }
    }

    @Override
    public boolean register(Accounts account) {
        //attempts to register an account to the db
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

    public boolean accIdInList(LinkedList<Accounts> accs, String ans){
        //checks to see if the account id is present in a list of accounts
        for (Accounts acc: accs) {
            if(acc.getId() == Integer.parseInt(ans)){
                return true;
            }
        }
        return false;
    }

    public String transactionHistString(String id, String name){
        //Provides a formatted string for the TransactionHist screen
        LinkedList<Transactions> trans = accountsDAO.transactionsList(Integer.parseInt(id));
        StringBuilder sb = new StringBuilder();
        sb.append("Viewing transactions for the account: " + name + " \n" +
                "Transaction amount\t\t\tTransaction date\n");
        for (Transactions t: trans) {
            sb.append("$" + t.getAmount() + "\t\t\t\t\t" + t.getDate() + "\n");
        }
        sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    }

    public void remove(String id){
        //removes an account by id and catches related errors
        if(!accountsDAO.removeById(id)) {
            System.out.println("There was a problem deleting the account");
            throw new ResourcePersistenceException("Failed deletion");
        }
    }
}
