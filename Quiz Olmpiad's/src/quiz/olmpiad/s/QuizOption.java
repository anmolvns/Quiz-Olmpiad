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

public class QuizOption extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5;
    JLabel l1, javaImg, pythonImg, cppImg, kotlinImg, dartImg;
    String username;

    QuizOption(String username) {
        setTitle("Quiz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
//        setBounds(80, 20, 1200, 700);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        this.username = username;

        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("quiz/olmpiad/s/icons/quiz.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1366, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 1366, 400);
        add(l1);

        l1 = new JLabel();
        l1.setText("Please! Select Your Topic To Play A Quiz");
        l1.setBounds(450, 450, 900, 30);
        l1.setForeground(new Color(30, 144, 255));
        l1.setFont(new Font("RALEWAY", Font.PLAIN, 26));
        add(l1);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("quiz/olmpiad/s/icons/java.jpg"));
        Image i5 = i4.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        javaImg = new JLabel(i6);
        javaImg.setBounds(110, 500, 250, 250);
        add(javaImg);

        javaImg.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                new JavaQuiz(username).setVisible(true);
                setVisible(false);
            }
        });

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("quiz/olmpiad/s/icons/Python.jpg"));
        Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        pythonImg = new JLabel(i9);
        pythonImg.setBounds(340, 500, 250, 250);
        add(pythonImg);

        pythonImg.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                new PythonQuiz(username).setVisible(true);
                setVisible(false);
            }
        });

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("quiz/olmpiad/s/icons/cpp.jpg"));
        Image i11 = i10.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        cppImg = new JLabel(i12);
        cppImg.setBounds(570, 500, 250, 250);
        add(cppImg);
        
        
        cppImg.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                new CppQuiz(username).setVisible(true);
                setVisible(false);
            }
        });


        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("quiz/olmpiad/s/icons/Kotlin.jpg"));
        Image i14 = i13.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        kotlinImg = new JLabel(i15);
        kotlinImg.setBounds(800, 500, 250, 250);
        add(kotlinImg);
        
        
        kotlinImg.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                new KotlinQuiz(username).setVisible(true);
                setVisible(false);
            }
        });


        ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("quiz/olmpiad/s/icons/dart.jpg"));
        Image i17 = i16.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i18 = new ImageIcon(i17);
        dartImg = new JLabel(i18);
        dartImg.setBounds(1030, 500, 250, 250);
        add(dartImg);
        
        
        dartImg.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                new DartQuiz(username).setVisible(true);
                setVisible(false);
            }
        });


//        b1 = new JButton("Java");
//        b1.setBackground(new Color(30, 144, 255));
//        b1.setFont(new Font("Tahoma", Font.PLAIN, 22));
//        b1.setForeground(Color.WHITE);
//        b1.setBounds(150, 550, 180, 40);
//        b1.addActionListener(this);
//        b1.addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//                b1.setBackground(new Color(8, 70, 207));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//                b1.setBackground(new Color(30, 144, 254));
//            }
//        });
//        add(b1);
//        
//        b2 = new JButton("Python");
//        b2.setBackground(new Color(30, 144, 255));
//        b2.setFont(new Font("Tahoma", Font.PLAIN, 22));
//        b2.setForeground(Color.WHITE);
//        b2.setBounds(380, 550, 180, 40);
//        b2.addActionListener(this);
//        b2.addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//                b2.setBackground(new Color(8, 70, 207));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//                b2.setBackground(new Color(30, 144, 254));
//            }
//        });
//        add(b2);
//
//        
//        
//        b3 = new JButton("Javascript");
//        b3.setBackground(new Color(30, 144, 255));
//        b3.setFont(new Font("Tahoma", Font.PLAIN, 22));
//        b3.setForeground(Color.WHITE);
//        b3.setBounds(610, 550, 180, 40);
//        b3.addActionListener(this);
//        b3.addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//                b3.setBackground(new Color(8, 70, 207));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//                b3.setBackground(new Color(30, 144, 254));
//            }
//        });
//        add(b3);
//
//        
//        
//        b4 = new JButton("Kotlin");
//        b4.setBackground(new Color(30, 144, 255));
//        b4.setFont(new Font("Tahoma", Font.PLAIN, 22));
//        b4.setForeground(Color.WHITE);
//        b4.setBounds(840, 550, 180, 40);
//        b4.addActionListener(this);
//        b4.addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//                b4.setBackground(new Color(8, 70, 207));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//                b4.setBackground(new Color(30, 144, 254));
//            }
//        });
//        add(b4);
//
//        
//        
//        b5 = new JButton("Dart");
//        b5.setBackground(new Color(30, 144, 255));
//        b5.setFont(new Font("Tahoma", Font.PLAIN, 22));
//        b5.setForeground(Color.WHITE);
//        b5.setBounds(1070, 550, 180, 40);
//        b5.addActionListener(this);
//        b5.addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//                b5.setBackground(new Color(8, 70, 207));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//                b5.setBackground(new Color(30, 144, 254));
//            }
//        });
//        add(b5);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

//        if (ae.getSource() == b1) {
//            this.setVisible(false);
//            new JavaQuiz(username).setVisible(true);
//
//        } else if (ae.getSource() == b2) {
//            this.setVisible(false);
//            new PythonQuiz(username).setVisible(true);
//            
//        } else if (ae.getSource() == b3) {
//            this.setVisible(false);
//            new CppQuiz(username).setVisible(true);
//            
//        } else if (ae.getSource() == b4) {
//            this.setVisible(false);
//            new KotlinQuiz(username).setVisible(true);
//            
//        } else if (ae.getSource() == b5) {
//            this.setVisible(false);
//            new DartQuiz(username).setVisible(true);
//        }
    }

    public static void main(String[] args) {
        new QuizOption("");

    }

}
