/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrationlogin;

import java.util.Scanner;

/**
 *
 * @author dzivh
 */
public class Login {
    public class RegistrationLogin {
    // ... all your existing methods here

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        registrationlogin.RegistrationLogin reg = new registrationlogin.RegistrationLogin();

        System.out.println("----- User Registration -----");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter phone number (with international code): ");
        String phone = scanner.nextLine();

        String registerMessage = reg.registerUser(username, password, phone);
        System.out.println(registerMessage);

        if (registerMessage.equals("User registered successfully.")) {
            System.out.println("\n----- User Login -----");

            System.out.print("Enter username: ");
            String loginUser = scanner.nextLine();

            System.out.print("Enter password: ");
            String loginPass = scanner.nextLine();

            boolean loginSuccess = reg.loginUser(loginUser, loginPass);
            String loginMessage = reg.returnLoginStatus(loginSuccess, "John", "Doe"); // Replace with real names
            System.out.println(loginMessage);
        }

        scanner.close();
    }

        public boolean checkCellPhoneNumber(String string) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

}
