package quiz.olmpiad.s;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class QuizOlmpiadS extends JFrame {

    QuizOlmpiadS() {
        setTitle("Quiz Olmpiad");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
//        setBounds(100, 100, 1200, 500);
        setLayout(null);
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("quiz/olmpiad/s/icons/loading.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 1366, 768);
        add(l1);
        
        
        setVisible(true);
        new FirstLoadingPage();
    }

    public static void main(String[] args) {
        new QuizOlmpiadS();
    }

}
