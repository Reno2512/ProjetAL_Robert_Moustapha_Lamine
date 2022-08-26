package interfaceGraphique;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import service.User;

public class NavPanel extends JPanel{
    public NavPanel(User u,MainPage p) {
        JLabel userInfo = new JLabel();
        userInfo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
        userInfo.setForeground(Color.WHITE);
        userInfo.setText("Hello " + u.getEmail() + " !");
        JButton logout = new JButton("Logout");
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.disposeFrame();
                JOptionPane.showMessageDialog(p, "Logged Out Successfully", "Alert", JOptionPane.WARNING_MESSAGE);
                new LoginPage();
            }
        });
        this.setLayout(new BorderLayout());
        this.add(logout, BorderLayout.EAST);
        this.add(userInfo,BorderLayout.WEST);
        this.setBackground(Color.cyan);
        this.setPreferredSize(new Dimension(100, 50));
    }
}