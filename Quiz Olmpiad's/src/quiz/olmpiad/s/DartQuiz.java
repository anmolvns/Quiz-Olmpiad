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

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DartQuiz extends JFrame implements ActionListener {

    JButton next, submit, lifeline;
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup options;

    public static int count = 0;
    public static int timer = 60;
    public static int ans_given = 0;
    public static int score = 0;
    
    public static String question1;
    public static String option1;
    public static String option2;
    public static String option3;
    public static String option4;
    public static String answer;

    String q[][] = new String[10][5];
    String pa[][] = new String[10][1];
    String qa[][] = new String[10][2];
    String username;
    String langname="Dart";
    DartQuiz(String username) {
        this.username = username;
        setTitle("Java Quiz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        setBounds(80, 20, 1200, 700);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("quiz/olmpiad/s/icons/quiz.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1366, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 1366, 400);
        add(l1);

        qno = new JLabel("");
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        qno.setBounds(50, 450, 60, 30);
        add(qno);

        question = new JLabel("");
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        question.setBounds(90, 450, 900, 30);
        add(question);
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/quizolmpiad";
            String user = "root";
            String password = "";
             
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=(Statement) con.createStatement();
            String query = "select * from dartQuestion";
            stmt.executeQuery(query);
        
            
            ResultSet rs=(ResultSet) stmt.executeQuery(query);
            while(rs.next()){
                question1 = rs.getString("questions");
                option1 = rs.getString("option1");
                option2 = rs.getString("option2");
                option3 = rs.getString("option3");
                option4 = rs.getString("option4");
                answer = rs.getString("answer");
                
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        DartQuestion dq = new DartQuestion();
        dq.setQuestion1(question1);
        dq.setOption1(option1);
        dq.setOption2(option2);
        dq.setOption3(option3);
        dq.setOption4(option4);
        dq.setAnswer(answer);

//        q[0][0] = "Dart is originally developed by?";
//        q[0][1] = "Microsoft";
//        q[0][2] = "Google";
//        q[0][3] = "IBM";
//        q[0][4] = "Facebook";

        q[0][0] = dq.getQuestion1();
        q[0][1] = dq.getOption1();
        q[0][2] = dq.getOption2();
        q[0][3] = dq.getOption3();
        q[0][4] = dq.getOption4();

        q[1][0] = "Dart has multiple interfaces.";
        q[1][1] = "FALSE";
        q[1][2] = "TRUE";
        q[1][3] = "Both TRUE Or FALSE";
        q[1][4] = "None of the above";

        q[2][0] = "The __________ function is a predefined method in Dart.";
        q[2][1] = "declare()";
        q[2][2] = "list()";
        q[2][3] = "main()";
        q[2][4] = "return()";

        q[3][0] = "-version command is used to ?";
        q[3][1] = "Enables assertions";
        q[3][2] = "Displays VM version information";
        q[3][3] = "Specifies the path";
        q[3][4] = "Specifies where to find imported libraries";

        q[4][0] = "Which of the following command specifies where to find imported Libraries?";
        q[4][1] = "-c";
        q[4][2] = "-p";
        q[4][3] = "-h";
        q[4][4] = "All of the above";

        q[5][0] = "Dart programs run in ________ modes.";
        q[5][1] = "2";
        q[5][2] = "3";
        q[5][3] = "4";
        q[5][4] = "5";

        q[6][0] = "Dart is an Object-Oriented language.";
        q[6][1] = "Yes";
        q[6][2] = "No";
        q[6][3] = "Can be Yes or no";
        q[6][4] = "Can not say";

        q[7][0] = "An __________ is a real-time representation of any entity.";
        q[7][1] = "class";
        q[7][2] = "method";
        q[7][3] = "object";
        q[7][4] = "None of the above";

        q[8][0] = "As per Grady Brooch, every object must have __________ features.";
        q[8][1] = "0";
        q[8][2] = "1";
        q[8][3] = "2";
        q[8][4] = "3";

        q[9][0] = "Which framework uses dart progamming language?";
        q[9][1] = "React Native";
        q[9][2] = "Flutter";
        q[9][3] = "Angular";
        q[9][4] = "Vue.js";
        
        
//        qa[0][1] = "Google";
        qa[0][1] = dq.getAnswer();
        qa[1][1] = "TRUE";
        qa[2][1] = "main()";
        qa[3][1] = "Displays VM version information";
        qa[4][1] = "-p";
        qa[5][1] = "2";
        qa[6][1] = "Yes";
        qa[7][1] = "object";
        qa[8][1] = "3";
        qa[9][1] = "Flutter";

        opt1 = new JRadioButton("");
        opt1.setBounds(90, 500, 700, 30);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt1.setBackground(Color.WHITE);
        add(opt1);

        opt2 = new JRadioButton("");
        opt2.setBounds(90, 550, 700, 30);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt2.setBackground(Color.WHITE);
        add(opt2);

        opt3 = new JRadioButton("");
        opt3.setBounds(90, 600, 700, 30);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt3.setBackground(Color.WHITE);
        add(opt3);

        opt4 = new JRadioButton("");
        opt4.setBounds(90, 650, 700, 30);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt4.setBackground(Color.WHITE);
        add(opt4);

        options = new ButtonGroup();
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);

        next = new JButton("Next");
        next.setBackground(new Color(30, 144, 255));
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setForeground(Color.WHITE);
        next.setBounds(1020, 500, 170, 40);
        next.addActionListener(this);
        next.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e) {
                
                next.setBackground(new Color(8, 70, 207));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
                next.setBackground(new Color(30, 144, 254));
            }
        });
        add(next);

        lifeline = new JButton("50:50 Lifeline");
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setForeground(Color.WHITE);
        lifeline.setBounds(1020, 570, 170, 40);
        lifeline.addActionListener(this);
        lifeline.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e) {
                
                lifeline.setBackground(new Color(8, 70, 207));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
                lifeline.setBackground(new Color(30, 144, 254));
            }
        });
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBackground(new Color(30, 144, 255));
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setEnabled(false);
        submit.setForeground(Color.WHITE);
        submit.setBounds(1020, 640, 170, 40);
        submit.addActionListener(this);
        submit.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e) {
                
                submit.setBackground(new Color(8, 70, 207));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
                submit.setBackground(new Color(30, 144, 254));
            }
        });
        add(submit);

        start(0);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (options.getSelection() == null) {
                pa[count][0] = "";
            } else {
                pa[count][0] = (options.getSelection().getActionCommand());
            }
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (options.getSelection() == null) {
                pa[count][0] = "";
            } else {
                pa[count][0] = (options.getSelection().getActionCommand());
            }

            for (int i = 0; i < pa.length; i++) {
                if (pa[i][0].equals(qa[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            this.setVisible(false);
            new Score(username, score,langname).setVisible(true);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        String time = "Time Left - " + timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 20));

        if (timer > 0) {
            g.drawString(time, 1000, 450);
        } else {
            g.drawString("Times Up!!", 1000, 450);
        }

        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 60;
        } else if (timer < 0) {
            timer = 60;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) {
                if (options.getSelection() == null) {
                    pa[count][0] = "";
                } else {
                    pa[count][0] = (options.getSelection().getActionCommand());
                }

                for (int i = 0; i < pa.length; i++) {
                    if (pa[i][0].equals(qa[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                this.setVisible(false);
                new Score(username, score,langname).setVisible(true);
            } else {
                if (options.getSelection() == null) {
                    pa[count][0] = "";
                } else {
                    pa[count][0] = (options.getSelection().getActionCommand());
                }

                count++;
                start(count);
            }
        }
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(q[count][0]);
        opt1.setLabel(q[count][1]);
        opt1.setActionCommand(q[count][1]);
        opt2.setLabel(q[count][2]);
        opt2.setActionCommand(q[count][2]);
        opt3.setLabel(q[count][3]);
        opt3.setActionCommand(q[count][3]);
        opt4.setLabel(q[count][4]);
        opt4.setActionCommand(q[count][4]);
        options.clearSelection();
    }

    public static void main(String[] args) {
        new DartQuiz("").setVisible(true);
    }
}