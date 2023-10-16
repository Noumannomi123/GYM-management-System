package mainpage;
import utils.MyIcon;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {

    private JPanel contentPane;
    private JPanel panel = new JPanel();
    private JPanel panel_1 = new JPanel();
    private Timer animationTimer;
    private int currentX = 500; // Starting X position
    private int targetX = 400; // Target X position

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Home frame = new Home();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Home() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        panel.setBounds(0, 0, 986, 80);
        contentPane.add(panel);

        panel_1.setBounds(367, 41, 986, 463); // Adjusted the size and position of panel_1
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        ImageIcon imageIcon = new ImageIcon("D:\\JavaDocuments\\GymSystem\\pictures\\theRock.jpg");
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new MyIcon(imageIcon.getImage(), 220, 381)); // Adjusted the image dimensions
        imageLabel.setBounds(403, 38, 220, 381); // Adjusted the bounds
      	panel_1.add(imageLabel);
//        JLabel labelIcon = new JLabel();
//        labelIcon.setIcon(imageIcon);
//        labelIcon.setBounds(0, 84, 500, 316);
//      	panel_1.add(labelIcon);
        
        

//        animationTimer = new Timer(10, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int speed = 5; // You can adjust the speed of animation
//                currentX -= speed;
//                imageLabel.setBounds(currentX, 200, 100, 800); // Adjusted the X position
//                if (currentX <= targetX) {
//                    animationTimer.stop();
//                }
//            }
//        });
//        animationTimer.start();
    }
}
