package quiz.olmpiad.s;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class Score extends JFrame implements ActionListener {

    JButton b1, b2;

    Score(String username, int score) {
        setTitle("Score");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(100, 100, 1000, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("quiz/olmpiad/s/icons/score_2.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1000, 500, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l4 = new JLabel(i6);
        l4.setBounds(0, 0, 1000, 500);
        add(l4);

        JLabel l2 = new JLabel("Thanks for participating " + username);
        l2.setBounds(300, 140, 500, 30);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("RALEWAY", Font.PLAIN, 26));
        l4.add(l2);

        JLabel l3 = new JLabel("Your Score is " + score +" / 100");
        l3.setBounds(320, 200, 300, 30);
        l3.setFont(new Font("Sans Serif", Font.PLAIN, 26));
        l3.setForeground(new Color(199, 21, 133));
        l4.add(l3);

        JLabel l5 = new JLabel();
        l5.setText("www.onlinejppgc.com");
        l5.setBounds(120, 420, 150, 30);
        l5.setFont(new Font("San Serif", Font.PLAIN, 16));
        l5.setForeground(new Color(30, 144, 254));
        l5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        l5.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                try {

                    Desktop.getDesktop().browse(new URI("https://onlinejppgc.com/"));

                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }

        });
        l4.add(l5);

        b1 = new JButton("Play Again");
        b1.setBackground(new Color(30, 144, 254));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(600, 300, 120, 30);
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
        l4.add(b1);
        
        b2 = new JButton("Exit");
        b2.setBounds(770, 300, 120, 30);
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
        l4.add(b2);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            this.setVisible(false);
            new WelcomePage();
        }else{
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Score("", 0).setVisible(true);
    }
}
