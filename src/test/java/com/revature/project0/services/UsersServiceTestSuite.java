package com.revature.project0.services;

import com.revature.project0.DAOs.UsersDAO;
import com.revature.project0.exceptions.AuthenticationException;
import com.revature.project0.exceptions.InvalidRequestException;
import com.revature.project0.exceptions.ResourcePersistenceException;
import com.revature.project0.models.Users;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class UsersServiceTestSuite {
    UsersService sut;
    UsersDAO mockUserDAO;

    @Before
    public void testCaseSetup() {
        mockUserDAO = mock(UsersDAO.class);
        sut = new UsersService(mockUserDAO);
    }

    @After
    public void testCaseCleanUp() {
        sut = null;
    }

    @Test
    public void test_register_validUser() {

        // Arrange
        Users validUser = new Users("valid", "valid", "valid", "valid", "valid");
        when(mockUserDAO.findUserByUsername(anyString())).thenReturn(null);
        when(mockUserDAO.findUserByEmail(anyString())).thenReturn(null);
        when(mockUserDAO.save(validUser)).thenReturn(validUser);
        // Act
        boolean actualResult = sut.register(validUser);

        // Assert
        Assert.assertTrue("Expected user to be considered valid", actualResult);
    }

    @Test(expected = ResourcePersistenceException.class)
    public void test_register_takenUsername() {

        // Arrange
        Users validUser = new Users("valid", "valid", "valid", "valid", "valid");
        when(mockUserDAO.findUserByUsername(anyString())).thenReturn(validUser);
        when(mockUserDAO.findUserByEmail(anyString())).thenReturn(null);
        when(mockUserDAO.save(validUser)).thenReturn(validUser);
        // Act
        boolean actualResult = sut.register(validUser);
    }

    @Test(expected = ResourcePersistenceException.class)
    public void test_register_takenEmail() {

        // Arrange
        Users validUser = new Users("valid", "valid", "valid", "valid", "valid");
        when(mockUserDAO.findUserByUsername(anyString())).thenReturn(null);
        when(mockUserDAO.findUserByEmail(anyString())).thenReturn(validUser);
        when(mockUserDAO.save(validUser)).thenReturn(validUser);
        // Act
        boolean actualResult = sut.register(validUser);
    }

    @Test(expected = ResourcePersistenceException.class)
    public void test_register_takenUsernameEmail() {

        // Arrange
        Users validUser = new Users("valid", "valid", "valid", "valid", "valid");
        when(mockUserDAO.findUserByUsername(anyString())).thenReturn(validUser);
        when(mockUserDAO.findUserByEmail(anyString())).thenReturn(validUser);
        when(mockUserDAO.save(validUser)).thenReturn(validUser);
        // Act
        boolean actualResult = sut.register(validUser);
    }

    @Test(expected = ResourcePersistenceException.class)
    public void test_register_problemPersisting() {
        // Arrange
        Users validUser = new Users("valid", "valid", "valid", "valid", "valid");
        when(mockUserDAO.findUserByUsername(anyString())).thenReturn(null);
        when(mockUserDAO.findUserByEmail(anyString())).thenReturn(null);
        when(mockUserDAO.save(validUser)).thenReturn(null);
        // Act
        boolean actualResult = sut.register(validUser);
    }

    @Test(expected = InvalidRequestException.class)
    public void test_register_invalidUser() {
        // Arrange
        Users invalidUser = new Users("", "valid", "valid", "valid", "valid");
        when(mockUserDAO.findUserByUsername(anyString())).thenReturn(null);
        when(mockUserDAO.findUserByEmail(anyString())).thenReturn(null);
        when(mockUserDAO.save(invalidUser)).thenReturn(null);
        // Act
        boolean actualResult = sut.register(invalidUser);
    }

    @Test()
    public void test_authenticate_validUser() {
        // Arrange
        Users validUser = new Users("valid", "valid", "valid", "valid", "valid");
        String username = "valid";
        String password = "valid";
        when(mockUserDAO.findUserByUsernameAndPassword(anyString(), anyString())).thenReturn(validUser);
        // Act
        sut.authenticate(username, password);
        assert sut.getSessionUser() != null;
    }

    @Test(expected = InvalidRequestException.class)
    public void test_authenticate_nullUsername() {
        // Arrange
        String username = null;
        String password = "valid";
        // Act
        sut.authenticate(username, password);
    }

    @Test(expected = InvalidRequestException.class)
    public void test_authenticate_nullPassword() {
        // Arrange
        String username = "valid";
        String password = null;
        // Act
        sut.authenticate(username, password);
    }

    @Test(expected = AuthenticationException.class)
    public void test_authenticate_nullUser() {
        // Arrange
        String username = "valid";
        String password = "valid";
        when(mockUserDAO.findUserByUsernameAndPassword(anyString(), anyString())).thenReturn(null);
        // Act
        sut.authenticate(username, password);
    }
}
