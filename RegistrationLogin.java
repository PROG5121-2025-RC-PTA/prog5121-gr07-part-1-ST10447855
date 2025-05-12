/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registrationlogin;

/**
 *
 * @author dzivh
 */
public class RegistrationLogin {

    /**
     * @param args the command line arguments
     */
    
    private String registeredUsername;
    private String registeredPassword;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[a-z].*") &&
               password.matches(".*\\d.*") &&
               password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }

    public boolean checkCellPhoneNumber(String phoneNumber) {
        return phoneNumber.startsWith("+") && phoneNumber.length() <= 10;
    }

    public String registerUser(String username, String password, String phoneNumber) {
        if (!checkUserName(username)) {
            return "Username is incorrectly formatted.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password does not meet complexity requirements.";
        }
        if (!checkCellPhoneNumber(phoneNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        this.registeredUsername = username;
        this.registeredPassword = password;
        return "User registered successfully.";
    }

    public boolean loginUser(String username, String password) {
        return username.equals(registeredUsername) && password.equals(registeredPassword);
    }

    public String returnLoginStatus(boolean success, String firstName, String lastName) {
        if (success) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}

    
    

