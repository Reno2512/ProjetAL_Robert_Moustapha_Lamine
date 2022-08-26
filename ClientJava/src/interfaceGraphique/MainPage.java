package interfaceGraphique;



import javax.swing.JFrame;
import java.awt.BorderLayout;

import service.User;

public class MainPage extends JFrame{

    public MainPage(User u) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 1200);
        this.setLayout(new BorderLayout());
        NavPanel navPanel = new NavPanel(u,this);
        CenterPanel centerPanel = new CenterPanel();
        this.getContentPane().add(navPanel, BorderLayout.NORTH);
        this.getContentPane().add(new MenuPanel(centerPanel), BorderLayout.WEST);
        this.getContentPane().add(centerPanel, BorderLayout.CENTER);
        centerPanel.displayUsersTable();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void disposeFrame() {
        this.dispose();
    }
}