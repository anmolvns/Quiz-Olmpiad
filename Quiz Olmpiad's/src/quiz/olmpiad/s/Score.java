package quiz.olmpiad.s;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Score extends JFrame implements ActionListener {

    JButton b1, b2, b3,b4,b5;
    String username;
    int score;
    String langname;
    
    String a,b,c;
    
    Score(String username, int score,String langname) {
        username=username;
        score=score;
        langname=langname;
        
        User user = new User();
        user.setResult(score);
        
        System.out.println(username+score+langname);
        a=username;
        b=String.valueOf(score);
        c=langname;
        setTitle("Score");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
//        setSize(1000,500);
        //setBounds(200, 100, 1000, 500);
//        setLocationRelativeTo(null);//FOR CENTER THE FRAME
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("quiz/olmpiad/s/icons/score_page1.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l4 = new JLabel(i6);
        l4.setBounds(0, 0, 1366, 768);
        add(l4);

        JLabel l2 = new JLabel("Thanks for participating " + username);
        l2.setBounds(500, 250, 500, 30);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("RALEWAY", Font.PLAIN, 26));
        l4.add(l2);

        JLabel l3 = new JLabel("Your Score is " + score +" / 100");
        l3.setBounds(500, 320, 300, 30);
        l3.setFont(new Font("Sans Serif", Font.PLAIN, 26));
        l3.setForeground(new Color(199, 21, 133));
        l4.add(l3);
        

        JLabel l5 = new JLabel();
        l5.setText("www.onlinejppgc.com");
        l5.setBounds(200, 650, 150, 30);
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
        
        
        JLabel l6 = new JLabel();
        l6.setText("Get Our Premium Subscription");
        l6.setBounds(900, 630, 500, 30);
        l6.setFont(new Font("San Serif", Font.BOLD, 22));
        l6.setForeground(Color.WHITE);
        l6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        l6.addMouseListener(new MouseAdapter() {
//
//            public void mouseClicked(MouseEvent e) {
//                try {
//
//                    //new SubscribeMe().setVisible(true);
//
//                } catch (Exception e1) {
//                    e1.printStackTrace();
//                }
//            }
//
//        });
        l4.add(l6);
        
        JLabel l7 = new JLabel();
        l7.setText("https://quizsubsciption.com/");
        l7.setBounds(980, 650, 300, 30);
        l7.setFont(new Font("San Serif", Font.PLAIN, 16));
        l7.setForeground(new Color(30, 144, 254));
        l7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        l7.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                try {

                         new SubscribeMe().setVisible(true);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

        });
        l4.add(l7);
        
        
        b1 = new JButton("Play Again");
        b1.setBackground(new Color(30, 144, 254));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(320, 420, 150, 40);
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
        
        b3 = new JButton("LeaderBoard");
        b3.setBackground(new Color(30, 144, 254));
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        b3.setBounds(500, 420, 150, 40);
        b3.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e) {
                
                b3.setBackground(new Color(8, 70, 207));
//                new ScoreCard().setVisible(true);
  
            }
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                
//                b3.setBackground(new Color(8, 70, 207));
//               
//                new ScoreCard().setVisible(true);
//  
//            }
            @Override
            public void mouseExited(MouseEvent e) {
                
                b3.setBackground(new Color(30, 144, 254));
               
            }
        });
        l4.add(b3);
        
        b2 = new JButton("Exit");
        b2.setBounds(680, 420, 150, 40);
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
        
        b4 = new JButton("Save Your Score");
        b4.setBounds(860, 420, 150, 40);
        b4.setBackground(new Color(30, 144, 254));
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        b4.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e) {
                
                b4.setBackground(new Color(8, 70, 207));
                
            }
             @Override
            public void mouseClicked(MouseEvent e) {
                
                b4.setBackground(new Color(8, 70, 207));
                save_score_db();
  
            }
             @Override
            public void mouseExited(MouseEvent e) {
                
                b4.setBackground(new Color(30, 144, 254));
               
            }

        });
        l4.add(b4);
        
        b5 = new JButton("Feedback");
        b5.setBackground(new Color(30, 144, 254));
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        b5.setBounds(590, 500, 150, 40);
        b5.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e) {
                
                b1.setBackground(new Color(8, 70, 207));
                
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                
                b1.setBackground(new Color(30, 144, 254));
            }
        });
        l4.add(b5);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            
            this.setVisible(false);
            new WelcomePage();
        }
        
        if (ae.getSource()== b3){
            this.setVisible(false);
            new ScoreCard().setVisible(true);
        }
       
        if(ae.getSource()==b2){
            System.exit(0);
        }
        
        if(ae.getSource()==b5){
            new FeedbackMe().setVisible(true);
        }
//        
//        else{
//            System.exit(0);
//        }
    }
    
    public void save_score_db(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/quizolmpiad";
            String user = "root";
            String password = "";
             
            Connection con = DriverManager.getConnection(url, user, password);
            String query = "INSERT INTO result values('" + a + "','" + b + "','" + c + "')";
            System.out.println(a+b+c);
            PreparedStatement pst = con.prepareStatement(query);
            int x = pst.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(rootPane, "Sorry Your Data Is Not Saved");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Your Score is sucessfully Saved To Database");
                    }
           
            con.close();
        } catch (SQLException ex) {
//            Logger.getLogger(SignUpForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(SignUpForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        new Score("", 0,"").setVisible(true);
    }
}
