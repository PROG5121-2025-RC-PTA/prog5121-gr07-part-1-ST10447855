/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import registrationlogin.RegistrationLogin;



/**
 *
 * @author dzivh
 */
public class RegistrationLoginTest {
    
    
   
    private RegistrationLogin registrationLogin;

    @BeforeEach
    void setUp() {
        registrationLogin = new RegistrationLogin();
    }

    @Test
    void testCheckUserName_CorrectFormat() {
        assertTrue(registrationLogin.checkUserName("kyl_1"));
    }

    @Test
    void testCheckUserName_IncorrectFormat() {
        assertFalse(registrationLogin.checkUserName("kyle!!!!!!!"));
    }

    @Test
    void testCheckPasswordComplexity_Correct() {
        assertTrue(registrationLogin.checkPasswordComplexity("Password1!"));
    }

    @Test
    void testCheckPasswordComplexity_MissingUpperCase() {
        assertFalse(registrationLogin.checkPasswordComplexity("password1!"));
    }

    @Test
    void testCheckCellPhoneNumber_Correct() {
        assertTrue(registrationLogin.checkCellPhoneNumber("+278312345"));
    }

    @Test
    void testCheckCellPhoneNumber_Incorrect() {
        assertFalse(registrationLogin.checkCellPhoneNumber("08312345"));
    }

    @Test
    void testRegisterUser_AllValid() {
        String result = registrationLogin.registerUser("kyl_1", "Password1!", "+278312345");
        assertEquals("User registered successfully.", result);
    }

    @Test
    void testRegisterUser_InvalidUsername() {
        String result = registrationLogin.registerUser("kyle!!!!!!!", "Password1!", "+278312345");
        assertEquals("Username is incorrectly formatted.", result);
    }

    @Test
    void testRegisterUser_InvalidPassword() {
        String result = registrationLogin.registerUser("kyl_1", "pass", "+278312345");
        assertEquals("Password does not meet complexity requirements.", result);
    }

    @Test
    void testLoginUser_Success() {
        registrationLogin.registerUser("kyl_1", "Password1!", "+278312345");
        assertTrue(registrationLogin.loginUser("kyl_1", "Password1!"));
    }

    @Test
    void testLoginUser_Failure() {
        registrationLogin.registerUser("kyl_1", "Password1!", "+278312345");
        assertFalse(registrationLogin.loginUser("kyl_1", "WrongPass1!"));
    }

    @Test
    void testReturnLoginStatus_Success() {
        String msg = registrationLogin.returnLoginStatus(true, "Kyle", "Smith");
        assertEquals("Welcome Kyle Smith, it is great to see you again.", msg);
    }

    @Test
    void testReturnLoginStatus_Failure() {
        String msg = registrationLogin.returnLoginStatus(false, "Kyle", "Smith");
        assertEquals("Username or password incorrect, please try again.", msg);
    }
}

