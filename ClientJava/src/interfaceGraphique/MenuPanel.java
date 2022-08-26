package interfaceGraphique;



import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPanel extends JPanel implements ActionListener {
    
    public MenuPanel(CenterPanel p) {
        this.setPreferredSize(new Dimension(200, 100));
        this.setBackground(Color.gray);

        JButton usersList = new JButton("List Users");
        usersList.setForeground(Color.black);
        usersList.setPreferredSize(new Dimension(200,50));
        usersList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                p.removeAll();
                p.updateUI();
                p.displayUsersTable();
            }
        });
        this.add(usersList);

        JButton addUser = new JButton("New User");
        addUser.setForeground(Color.black);
        addUser.setPreferredSize(new Dimension(200, 50));
        addUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                p.removeAll();
                p.updateUI();
                p.displayUserForm();
            }
        });
        this.add(addUser);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {}
}