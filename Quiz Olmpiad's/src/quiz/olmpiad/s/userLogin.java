/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.olmpiad.s;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anmol
 */
public class userLogin implements ActionListener {
    

    JFrame f;
    JLabel l1, l2 ,l3 , l4;
    JTextField t1;
    JPasswordField t2;
    JButton b1;

    userLogin() {

        f = new JFrame("userLogin");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setBackground(Color.white);
        f.getContentPane().setBackground(Color.WHITE);
        f.setLayout(null);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setUndecorated(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("quiz/olmpiad/s/icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1366, 768);
        f.add(l3);

        l1 = new JLabel("Email");
        l1.setBounds(180, 300, 100, 30);
        l3.add(l1);

        t1 = new JTextField();
        t1.setBounds(180, 330, 200, 30);
        l3.add(t1);

        l2 = new JLabel("Password");
        l2.setBounds(180, 400, 100, 30);
        l3.add(l2);

        t2 = new JPasswordField();
        t2.setBounds(180, 430, 200, 30);
        l3.add(t2);

        b1 = new JButton("Login");
        b1.setBounds(205, 500, 150, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.addActionListener(this);
        b1.setBackground(new Color(30, 144, 254));
        b1.setForeground(Color.WHITE);
        b1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                b1.setBackground(new Color(8, 70, 207));

            }

            @Override
            public void mouseExited(MouseEvent e) {

                b1.setBackground(new Color(30, 144, 254));
            }
        });
        l3.add(b1);
        
//        JLabel text = new JLabel("Don't have an account yet?");
//        text.setBounds(190,550,330,30);

        l4 = new JLabel("Don't have an account yet? SignUp Now!");
        l4.setBounds(170, 550, 300, 30);
        l4.setFont(new Font("serif", Font.BOLD, 15));
        l4.setForeground(new Color(30, 144, 254));
//        l4.setForeground(Color.WHITE);
        l4.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                l4.setForeground(new Color(8, 70, 207));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("hello nitesh");

                l4.setForeground(new Color(30, 144, 254));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                new userSignUp();
                f.setVisible(false);
            }
        });
        l3.add(l4);

//        f.setSize(600, 300);
//        f.setLocation(400, 300);
        f.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        try {
            conn c1 = new conn();
            String u = t1.getText();
            String v = t2.getText();

            User user = new User();
            user.setPassword(v);
            Security secure = new Security("lv39eptlvuhaqqsr");
            String encdata = secure.encrypt(user.getPassword());

//        To login data
            String q = "select * from user where email='" + u + "' and password='" + encdata + "'";

            ResultSet rs = c1.s.executeQuery(q);
            if (rs.next()) {
                new WelcomePage().setVisible(true);
                f.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Details");
//                f.setVisible(false);

            }
        } catch (Exception ex) {
            Logger.getLogger(userLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] arg) {
        userLogin l = new userLogin();
    }
    
   
    

}
