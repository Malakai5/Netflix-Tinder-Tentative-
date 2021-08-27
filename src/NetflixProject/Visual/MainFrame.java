package NetflixProject.Visual;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainFrame {
    private JPanel mainWindow;
    private JButton LoginButton;
    private JPasswordField PasswordField;
    private JTextField UsernameField;
    private JPanel InformationPanel;
    public JPanel LogoPanel;
    private JLabel Title;
    private JLabel Logo;

    public void createUIComponents() throws IOException {
        // TODO: place custom component creation code here
//        Image image = ImageIO.read(new File("C:\\Users\\malik\\IdeaProjects\\Netflix\\Resources\\netflix_logo.png"));
//        ImageIcon icon = new ImageIcon(image);
//        Logo = new JLabel();
//        Logo.setIcon(icon);
//        Logo.setVisible(true);
    }

    public JPanel getMainWindow() throws IOException {
        return mainWindow;
//        JFrame frame = new JFrame("NetflixTinder");
//        frame.add(mainWindow);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
