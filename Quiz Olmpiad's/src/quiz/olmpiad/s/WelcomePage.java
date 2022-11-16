package quiz.olmpiad.s;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class WelcomePage extends JFrame implements ActionListener {

    JButton b1, b2;
    JTextField t1;
    

    WelcomePage() {
        setTitle("Welcome to Quiz Olmpiad");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
//        setBounds(100, 100, 1200, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        

//        URL filepath = ClassLoader.getSystemResource("quiz/olmpiad/s/icons/start_page.jpg");
                
//        ImageIcon i1 = new ImageIcon(filepath);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("quiz/olmpiad/s/icons/welcome_page.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 1366, 768);
        add(l1);

        JLabel l2 = new JLabel();
        l2.setFont(new Font("San Serif", Font.BOLD, 16));
        l2.setForeground(new Color(30, 144, 254));
        l2.setText("www.onlinejppgc.com");
        l2.setBounds(100, 690, 180, 30);
        l2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        l2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {

                    Desktop.getDesktop().browse(new URI("https://onlinejppgc.com/"));

                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }

        });
        l1.add(l2);

        JLabel l3 = new JLabel("Enter Your Name");
        l3.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        l3.setForeground(new Color(000651));
        l3.setBounds(1030, 280, 300, 20);
        l1.add(l3);

        t1 = new JTextField();
        t1.setBounds(950, 340, 300, 25);
        t1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        l1.add(t1);

        b1 = new JButton("Rules");
        b1.setBounds(970, 410, 120, 25);
        b1.setBackground(new Color(30, 144, 254));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
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
        l1.add(b1);

        b2 = new JButton("Exit");
        b2.setBounds(1120, 410, 120, 25);
        b2.setBackground(new Color(30, 144, 254));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e) {
                
                b2.setBackground(new Color(8, 70, 207));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
                b2.setBackground(new Color(30, 144, 254));
            }
        });
        l1.add(b2);

        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String name = t1.getText();
            this.setVisible(false);
            new Rules(name);
        } else {
            System.exit(0);

        }
    }

    public static void main(String[] args) {
        new WelcomePage();
    }

}
