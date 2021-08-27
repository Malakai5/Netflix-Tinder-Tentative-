package NetflixProject.Visual;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class VisualTest {
        public static void main(String[] args) throws IOException {

            JFrame frame = new JFrame("NetflixTinder");
            frame.setVisible(true);
            MainFrame main = new MainFrame();

            JPanel panel = main.getMainWindow();
            frame.add(panel);
//
//            JPanel informationPanel = new JPanel();
//            informationPanel.setBackground(new Color(141,11,0));
//            frame.add(informationPanel, BorderLayout.PAGE_END);
//
//            JButton loginButton = new JButton();
//            loginButton.setSize(200,frame.getHeight()/10);
//            loginButton.setBackground(Color.BLACK);
//            loginButton.setForeground(Color.WHITE);
//            loginButton.setText("Login");
//
//            Dimension entryField = new Dimension();
//            entryField.height = 20;
//            entryField.width = 300;
//            JTextField usernameField = new JTextField();
//            usernameField.setText("Username");
//            usernameField.setPreferredSize(entryField);
//
//            JPasswordField passwordField = new JPasswordField();
//            passwordField.setPreferredSize(entryField);
//
//
//            informationPanel.add(loginButton,Component.CENTER_ALIGNMENT);
//            informationPanel.add(usernameField,Component.RIGHT_ALIGNMENT);
//            informationPanel.add(passwordField,BorderLayout.PAGE_END);
//
//            frame.pack();
//            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
