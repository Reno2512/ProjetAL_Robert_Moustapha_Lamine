package interfaceGraphique;

import javax.swing.*;
import dao.UserRepository;

import service.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserForm {
    private static UserRepository userRepo;
    JLabel title = new JLabel("Add a New User !");
    JButton addBtn = new JButton("Add User !");
    JButton resetBtn = new JButton("Reset Form !");
    JLabel messageLabel = new JLabel();
    JLabel userEmailLabel = new JLabel("Login :");
    JLabel userRoleLabel = new JLabel("Role :");
    JLabel userPwdLabel = new JLabel("Password :");
    JLabel userPwdConfLabel = new JLabel("Confirm Password :");
    JTextField userEmailField = new JTextField();;
    JTextField userNField = new JTextField();
    JPasswordField userPwdField = new JPasswordField();
    JPasswordField userPwdConfField = new JPasswordField();
    String[] fields = {"admin","editeur"};
    final JComboBox<String> userRoleField = new JComboBox<>(fields);
    
    public AddUserForm(CenterPanel p) {
        try {
            userRepo = UserRepository.getUserRepoInstance();
        } catch (exception.WebServiceException e) {
            System.out.println(e.getMessage());
        }
        this.title.setBounds(50, 10, 250, 40);
        this.title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));

        this.userEmailLabel.setBounds(50, 100, 125, 35);
        this.userEmailField.setBounds(220, 100, 200, 35);


        this.userRoleLabel.setBounds(50, 200, 125, 35);
        this.userRoleField.setBounds(220, 200, 200, 35);

        this.userPwdLabel.setBounds(50, 300, 125, 35);
        this.userPwdField.setBounds(220, 300, 200, 35);

        this.userPwdConfLabel.setBounds(50, 400, 125, 35);
        this.userPwdConfField.setBounds(220, 400, 200, 35);

        this.messageLabel.setBounds(220,500,200,35);
        this.addBtn.setBounds(220, 450, 100, 35);
        this.resetBtn.setBounds(320, 450, 100, 35);
         
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("");
                String userEmail = userEmailField.getText();
                String userRole = String.valueOf(userRoleField.getSelectedItem()).toLowerCase();
                String userPwd = String.valueOf(userPwdField.getPassword());
                String userPwdConf = String.valueOf(userPwdConfField.getPassword());
                if (!userEmail.equals("") && !userRole.equals("") && !userPwd.equals("") && !userPwdConf.equals("")) {
                    if (userPwd.equals(userPwdConf)) {
					    AddUser request = new AddUser();
					    request.setArg0(userEmail);
					    request.setArg1(userPwd);
					    request.setArg2(userRole);
					    AddUserResponse response = userRepo.addUser(request);
//					    AddUserResponse response = userRepo.addUser(request);
					    if (response.getReturn().equalsIgnoreCase("Echec de l'insertion")) {
					    JOptionPane.showMessageDialog(p, response.getReturn()+""+userEmail+" "+userPwd+" "+userRole, "Alert",
					            JOptionPane.WARNING_MESSAGE);
					    } else {
					        messageLabel.setForeground(Color.GREEN);
					        messageLabel.setText(response.getReturn());
					        JOptionPane.showMessageDialog(p, "Added Successfully !", "Alert",
					        JOptionPane.WARNING_MESSAGE);
					        p.removeAll();
					        p.updateUI();
					        p.displayUsersTable();
					    }
					}else {
					    messageLabel.setForeground(Color.RED);
					    messageLabel.setText("Passwords Doesn't Match !");
					}
                } else {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("All Fields are Required !");
                }
            }

//          
        });
        resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userEmailField.setText("");
                userNField.setText("");
                userPwdField.setText("");
                userPwdConfField.setText("");
                messageLabel.setText("");
            }
        });
    }
}