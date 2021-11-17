package com.revature.project0.services;

import com.revature.project0.DAOs.AccountsDAO;
import com.revature.project0.exceptions.ResourcePersistenceException;
import com.revature.project0.models.Accounts;
import com.revature.project0.models.Transactions;
import com.revature.project0.util.Collections.LinkedList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class AccountsServiceTestSuite {
    AccountsService sut;
    AccountsDAO mockAccDAO;

    @Before
    public void testCaseSetup() {
        mockAccDAO = mock(AccountsDAO.class);
        sut = new AccountsService(mockAccDAO);
    }

    @After
    public void testCaseCleanUp() {
        sut = null;
    }

    @Test
    public void test_updateFunds_validIn_deposit() {

        // Arrange
        LinkedList<Accounts> accountsList = new LinkedList<>();
        Accounts accounts = new Accounts();
        accounts.setId(1);
        accountsList.add(accounts);
        // Act
        sut.updateFunds("1","150.50",accountsList,true);

        // Assert
        verify(mockAccDAO, times(1)).deposit("1", 150.50f);
    }

    @Test
    public void test_updateFunds_validIn_withdraw() {

        // Arrange
        LinkedList<Accounts> accountsList = new LinkedList<>();
        Accounts accounts = new Accounts();
        accounts.setId(1);
        accountsList.add(accounts);
        // Act
        sut.updateFunds("1","150.50",accountsList,false);

        // Assert
        verify(mockAccDAO, times(1)).deposit("1", -150.50f);
    }

    @Test
    public void test_updateFunds_invalidAccountID() {

        // Arrange
        LinkedList<Accounts> accountsList = new LinkedList<>();
        Accounts accounts = new Accounts();
        accounts.setId(1);
        accountsList.add(accounts);
        // Act
        sut.updateFunds("2","150.50",accountsList,false);

        // Assert
        verify(mockAccDAO, times(0)).deposit(anyString(), anyFloat());
    }

    @Test
    public void test_updateFunds_amountTooLow() {

        // Arrange
        LinkedList<Accounts> accountsList = new LinkedList<>();
        Accounts accounts = new Accounts();
        accounts.setId(1);
        accountsList.add(accounts);
        // Act
        sut.updateFunds("2","0",accountsList,false);

        // Assert
        verify(mockAccDAO, times(0)).deposit(anyString(), anyFloat());
    }

}
