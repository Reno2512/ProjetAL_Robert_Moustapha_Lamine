package interfaceGraphique;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//import Validations.EmailValidation;
//import Validations.NumberValidation;
import dao.UserRepository;
import exception.WebServiceException;
import service.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterUserForm {
    private static UserRepository userRepo;
    JLabel title = new JLabel("Update User!");
    JButton addBtn = new JButton("Save !");
    JButton resetBtn = new JButton("Reset Form !");
    JButton deleteBtn = new JButton("Delete User !");
    JButton blockBtn = new JButton();
    JLabel messageLabel = new JLabel();
    JLabel userEmailLabel = new JLabel("Mail :");
    JLabel userRoleLabel = new JLabel("Role :");
    JLabel userPwdLabel = new JLabel("Password :");
    JLabel userPwdConfLabel = new JLabel("Confirm Password :");
    JTextField userEmailField = new JTextField();;
    JTextField userFnField = new JTextField();
    JTextField userLnField = new JTextField();
    JTextField userNField = new JTextField();
    JPasswordField userPwdField = new JPasswordField();
    JPasswordField userPwdConfField = new JPasswordField();
    String[] fields = {"admin","editeur"};
    JComboBox<String> userRoleField = new JComboBox<>(fields);
    User user;

    public AlterUserForm(int id, CenterPanel p) {
        try {
            userRepo = UserRepository.getUserRepoInstance();
        } catch (WebServiceException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            GetUserById request = new GetUserById();
            request.setArg0(id);
            GetUserByIdResponse response = userRepo.getUserById(request);
            user = response.getReturn();
        } catch (Exception e) {}

        this.title.setBounds(50, 10, 250, 40);
        this.title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));

        this.userEmailLabel.setBounds(50, 100, 125, 35);
        this.userEmailField.setBounds(220, 100, 200, 35);
        this.userEmailField.setText(user.getEmail());



        this.userRoleLabel.setBounds(50, 300, 125, 35);
        this.userRoleField.setBounds(220, 300, 200, 35);
        if (user.getRole().equalsIgnoreCase("admin")) {
            this.userRoleField.setSelectedIndex(0);
        } else {
            this.userRoleField.setSelectedIndex(1);
        }

        this.userPwdLabel.setBounds(50, 350, 125, 35);
        this.userPwdField.setBounds(220, 350, 200, 35);

        this.userPwdConfLabel.setBounds(50, 400, 125, 35);
        this.userPwdConfField.setBounds(220, 400, 200, 35);

        this.messageLabel.setBounds(220,600,200,35);
        this.addBtn.setBounds(220, 450, 100, 35);
        this.resetBtn.setBounds(320, 450, 100, 35);

       
        this.blockBtn.setBounds(220, 500, 100, 35);
        
        
        this.deleteBtn.setBounds(320, 500, 100, 35);
         
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userEmail = userEmailField.getText();
                String userRole = String.valueOf(userRoleField.getSelectedItem()).toLowerCase();
                String userPwd = String.valueOf(userPwdField.getPassword());
                String userPwdConf = String.valueOf(userPwdConfField.getPassword());
                if (!userEmail.equals("") && !userRole.equals("") && !userPwd.equals("") && !userPwdConf.equals("")) {
                    if (userEmail!=null) {
                            if (userPwd.equals(userPwdConf)) {
                                User user = new User();
                                Update request = new Update();
                                user.setEmail(userEmail);
                                user.setRole(userRole);
                                user.setPassword(userPwd);
                                user.setId(id);
//                                request.setUser(user);
                                request.setArg0(userEmail);
                                request.setArg1(userPwd);
                                request.setArg2(userRole);
                                request.setArg3(id);
//                                setUser(user);
                                UpdateResponse response = userRepo.update(request);
                                messageLabel.setForeground(Color.GREEN);
                                messageLabel.setText(response.getReturn());
                                p.removeAll();
                                p.updateUI();
                                p.displayUsersTable();
                            }else {
                                messageLabel.setForeground(Color.RED);
                                messageLabel.setText("Passwords Doesn't Match !");
                            }
                        
                    } else {
                        messageLabel.setForeground(Color.RED);
                        messageLabel.setText("Email Invalid !");
                    }
                } else {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("All Fields are Required !");
                }
            }
        });
        resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userEmailField.setText("");
                userNField.setText("");
//                 userRoleField.setText("");
                userPwdField.setText("");
                userPwdConfField.setText("");
            }
        });
       
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(p, "Are You Sure ?");
                if (choice == JOptionPane.YES_OPTION) {
                    Delete request = new Delete();
                    request.setArg0(user.getId());
//                    request.setId(user.getId());
                    DeleteResponse response = userRepo.deleteUser(request);
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText(response.getReturn());
                    JOptionPane.showMessageDialog(p, "Successfully Deleted !", "Alert", JOptionPane.WARNING_MESSAGE);
                    p.removeAll();
                    p.updateUI();
                    p.displayUsersTable();
                }
            }
        });
    }
}