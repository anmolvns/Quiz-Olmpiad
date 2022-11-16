package quiz.olmpiad.s;

import java.awt.*;
import javax.swing.*;

public class FirstLoadingPage extends JFrame {

    JProgressBar bar;

    FirstLoadingPage() {
        setTitle("Quiz Olmpiad");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
//        setBounds(100, 100, 1200, 500);
        setLayout(null);
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("quiz/olmpiad/s/icons/first_page.png"));
        Image i2 = i1.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 1366, 768);
        add(l1);

        bar = new JProgressBar();
        bar.setBounds(800, 600, 420, 20);
        bar.setStringPainted(true);
        bar.setFont(new Font("MV BOLI", Font.BOLD, 20));
        bar.setForeground(new Color(000651));
        bar.setBackground(Color.WHITE);
        l1.add(bar);
        setVisible(true);
        fill();

    }

    public void fill() {
        int counter = 0;
        while (counter <= 100) {

            bar.setValue(counter);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            counter += 1;
        }

        this.setVisible(false);
//        new Login().setVisible(true);
            new userLogin();
    }

    public static void main(String[] args) {
        new FirstLoadingPage();
    }
}
