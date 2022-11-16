/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.olmpiad.s;

/**
 *
 * @author Anmol
 */
import java.sql.*;

public class User {

    private static String name;
    private static String email;
    private static String password;
    private static int result;
    

    public User() {
    }

    
    

    public User(String name, String email, String password, int result) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.result = result;
    }

//    public String getEmail() {
//        return email;
//    }

//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        User.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        User.name = name;
    }

    public static int getResult() {
        return result;
    }

    public static void setResult(int result) {
        User.result = result;
    }
    
    

    
    
    
    
    
}
