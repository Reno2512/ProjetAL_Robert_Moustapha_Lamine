package interfaceGraphique;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import java.awt.Dimension;


public class CenterPanel extends JPanel {


    public void displayUsersTable(String... a) {
        UsersTable table = new UsersTable(this);
        JScrollPane tableContainer;
        if (a.length == 0) {
            this.removeAll();
            tableContainer = new JScrollPane(table.getUsersTable(this, ""));
        } else {
            this.remove(this.getComponentCount()-1);
            tableContainer = new JScrollPane(table.getUsersTable(this, a[0]));
        }
        tableContainer.setPreferredSize(new Dimension(900, 600));
        tableContainer.setColumnHeader(new JViewport() {
            @Override
            public Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                d.height = 32;
                return d;
            }
        });
        tableContainer.setViewportBorder(BorderFactory.createLineBorder(Color.lightGray));
        tableContainer.setBounds(50, 130, 900, 600);
        this.setLayout(null);
        this.add(table.title);
        this.add(tableContainer);
        // this.updateUI();
    }
    
    public void displayFilteredUsers() {}

    public void displayUserForm() {
        AddUserForm userForm = new AddUserForm(this);
        this.removeAll();
        this.add(userForm.title);
        this.add(userForm.userEmailLabel);
        this.add(userForm.userRoleLabel);
        this.add(userForm.userPwdLabel);
        this.add(userForm.userPwdConfLabel);
        this.add(userForm.userEmailField);
        this.add(userForm.userNField);
        this.add(userForm.userRoleField);
        this.add(userForm.userPwdField);
        this.add(userForm.userPwdConfField);
        this.add(userForm.addBtn);
        this.add(userForm.resetBtn);
        this.add(userForm.messageLabel);
        this.setLayout(null);
        this.updateUI();
    }

    public void displayAlterUserForm(int id) {
        AlterUserForm userForm = new AlterUserForm(id, this);
        this.removeAll();
        this.add(userForm.title);
        this.add(userForm.userEmailField);
        this.add(userForm.userRoleLabel);
        this.add(userForm.userPwdLabel);
        this.add(userForm.userPwdConfLabel);
        this.add(userForm.userEmailField);
        this.add(userForm.userNField);
        this.add(userForm.userRoleField);
        this.add(userForm.userPwdField);
        this.add(userForm.userPwdConfField);
        this.add(userForm.addBtn);
        this.add(userForm.resetBtn);
        this.add(userForm.deleteBtn);
        this.add(userForm.messageLabel);
        this.setLayout(null);
        this.updateUI();
    }
    
}