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
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static java.lang.System.exit;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class userSignUp implements ActionListener {

    JFrame f;
    JPanel bgPanel, loginPanel, signupPanel;
    JLabel l1, l2, l3, l4,l5 , name;
    JTextField t1, nameField;
    JPasswordField t2;
    JButton b1;

    userSignUp() {

        f = new JFrame("SignUp");
        f.getContentPane().setBackground(Color.WHITE);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setBackground(Color.white);
        f.setLayout(null);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setUndecorated(true);

//        bgPanel = new JPanel();
//        bgPanel.setBackground(Color.GRAY);
//        bgPanel.setBounds(300, 250, 800, 400);
//        f.add(bgPanel);
//        
//        loginPanel = new JPanel();
//        loginPanel.setBackground(new Color(30, 144, 254));
//        loginPanel.setBounds(700, 220, 350, 450);
//        f.add(loginPanel);
//        
//        signupPanel = new JPanel();
//        signupPanel.setBackground(new Color(30, 144, 254));
//        signupPanel.setBounds(350, 220, 350, 450);
//        f.add(signupPanel);
////        signupPanel.setVisible(false);
//        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("quiz/olmpiad/s/icons/Signup.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1366, 768);
        f.add(l3);
        
        name = new JLabel("Name");
        name.setBounds(1000, 270, 100, 30);
        l3.add(name);
        
        nameField = new JTextField("");
        nameField.setBounds(1000, 300, 200, 30);
        l3.add(nameField);
        

        l1 = new JLabel("Email");
        l1.setBounds(1000, 350, 100, 30);
        l3.add(l1);

        t1 = new JTextField();
        t1.setBounds(1000, 380, 200, 30);
        l3.add(t1);

        l2 = new JLabel("Password");
        l2.setBounds(1000, 430, 100, 30);
        l3.add(l2);

        t2 = new JPasswordField();
        t2.setBounds(1000, 460, 200, 30);
        l3.add(t2);

        b1 = new JButton("Sign Up");
        b1.setBounds(1025, 520, 150, 30);
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

        l4 = new JLabel("Already have an account? Log in");
        l4.setBounds(1000, 570, 250, 30);
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

                l4.setForeground(new Color(30, 144, 254));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                new userLogin();
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
            String name = nameField.getText();
            String email = t1.getText();
            String password = t2.getText();
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            Security secure = new Security("lv39eptlvuhaqqsr");
            String encdata = secure.encrypt(user.getPassword());
            

            
//To add data
            if (ae.getSource() == b1) {

                conn cc = new conn();
                String q = "insert into user values('"+ name +"' ,'" + email + "','" + encdata + "')";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Details Successfully Inserted");
                f.setVisible(false);
                mailApi a = new mailApi();
                new userLogin();
            }else{
            
                JOptionPane.showConfirmDialog(null, "User Already exists OR Invalid Details");
            }

//            if (ae.getSource() == b2) {
//                exit(0);
//            }
        } catch (Exception ex) {
            Logger.getLogger(userSignUp.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showConfirmDialog(null, "User Already exists OR Invalid Details");
//                JOptionPane.showConfirmDialog(this, "User Already exists OR Invalid Details",JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void main(String[] arg) {
        userSignUp l = new userSignUp();
    }

}
