package quiz.olmpiad.s;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JButton b1, b2;
    String username;
    JScrollPane scrollpane;
    JCheckBox c1;

    Rules(String username) {
        setTitle("Rules");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        this.username = username;
//        setBounds(300, 50, 800, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("quiz/olmpiad/s/icons/rules.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1366, 786, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1366, 786);
        add(img);


        l1 = new JLabel("Welcome " + username + " to Quiz Olmpiad's");
        l1.setFont(new Font("RALEWAY", Font.BOLD, 28));
        l1.setForeground(new Color(30, 144, 255));
        l1.setBounds(420, 100, 700, 30);
        img.add(l1);

        l3 = new JLabel("Please read the instructions carefully");
        l3.setFont(new Font("RALEWAY", Font.BOLD, 18));
        l3.setBounds(50, 200, 400, 20);
        img.add(l3);

        l2 = new JLabel();
        l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l2.setText(
                "<html> <body> "
                + "<u><b>General Instructions:</b></u><br><br>"
                + "<b>1.</b>Total duration of examination is 10 minutes(60 secs for each questions). <br><br>"
                + "<b>2.</b>The clock will be set at the server. The Countdown timer in the middle of the <br>"
                + "right side of the screen will display the remaining time available for you to complete the <br>"
                + "examination. When the timer reaches zero, the examination will end by itself.<br><br>"
                + "<b>3.</b>10 points is awarded for the correct answer.<br><br>"
                + "<b>4.</b> There are total <b>10</b> Questions.<br><br>"
                + "<b>5.</b> No negative points for the wrong answer.<br><br>"
                + "<b>6.</b> This game should be played at <b>1366 &#x2715; 786 Resolution</b>.<br><br>"
                + "<b>6.</b> There is a one lifeline which can be used once which is <b>50:50 Lifeline</b>.<br><br>"
                + "<b>7.Cheating:-</b> Anyone suspected by an official of cheating will be disqualified. <br>"
                + "You must not use any mobile device during this quiz competition.<br><br>"
                + "<b>Any breach of the rules will likely result in the disqualification of the <br>player(s) involved.</b> <br><br>"
                + "</body>"
                + "</html>"
        );

        scrollpane = new JScrollPane(l2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollpane.getViewport().setBackground(Color.WHITE);
        scrollpane.setBounds(50, 250, 700, 350);
        scrollpane.setBorder(BorderFactory.createEmptyBorder());
        img.add(scrollpane, BorderLayout.CENTER);

        c1 = new JCheckBox();
        c1.setBounds(50, 620, 400, 50);
        c1.setBackground(Color.WHITE);
        c1.setText("<html>I have read and understood the instructions and <br>agree to adhere to them.</html>");
        c1.addActionListener(this);

        img.add(c1);

        b1 = new JButton("Back");
        b1.setBounds(480, 700, 100, 30);
        b1.setBackground(new Color(30, 144, 255));
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
        img.add(b1);

        b2 = new JButton("Start");
        b2.setBounds(630, 700, 100, 30);
        b2.setBackground(new Color(30, 144, 255));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setEnabled(false);
        b2.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e) {
                // the mouse has entered the label
                b2.setBackground(new Color(8, 70, 207));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // the mouse has exited the label
                b2.setBackground(new Color(30, 144, 254));
            }
        });
        img.add(b2);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (c1.isSelected()) {
            b2.setEnabled(true);
        }else{
            b2.setEnabled(false);
        }

        if (ae.getSource() == b1) {
            this.setVisible(false);
            new WelcomePage().setVisible(true);

        } else if (ae.getSource() == b2) {
            this.setVisible(false);
            new QuizOption(username).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Rules("");

    }
}
