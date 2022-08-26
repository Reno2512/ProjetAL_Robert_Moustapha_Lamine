package interfaceGraphique;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//import Validations.EmailValidation;
import dao.UserLogin;
import dao.UserRepository;
import exception.WebServiceException;
import service.*;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class LoginPage implements ActionListener {
    UserLogin logService;
    UserRepository userRepo;
    JFrame frame = new JFrame();
    JButton loginBtn = new JButton("Login");
    JButton resetBtn = new JButton("Reset");
    JTextField userLoginField = new JTextField();
    JPasswordField userPwdField = new JPasswordField();
    JLabel userLoginLabel = new JLabel("Email :");
    JLabel userPwdLabel = new JLabel("Password :");
    JLabel messageLabel = new JLabel();
    JLabel title = new JLabel("Log In");

    public LoginPage() {
        try {
            userRepo = UserRepository.getUserRepoInstance();
        } catch (WebServiceException e) {
            messageLabel.setForeground(Color.RED);
            messageLabel.setText(e.getMessage());
        }
        try {
            logService = UserLogin.getUserLoginInstance();
        } catch (WebServiceException e) {
            messageLabel.setForeground(Color.RED);
            messageLabel.setText(e.getMessage());
        }
        title.setBounds(180, 50, 75, 30);
        title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));

        userLoginLabel.setBounds(50,100,75,25);
		userPwdLabel.setBounds(50,150,75,25);
		
		messageLabel.setBounds(120,250,400,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,15));
		
		userLoginField.setBounds(125,100,200,25);
		userPwdField.setBounds(125,150,200,25);
		
		loginBtn.setBounds(125,200,100,25);
		loginBtn.setFocusable(false);
		loginBtn.addActionListener(this);
		
		resetBtn.setBounds(225,200,100,25);
		resetBtn.setFocusable(false);
        resetBtn.addActionListener(this);
        
        frame.add(title);
        frame.add(userLoginLabel);
        frame.add(userPwdLabel);
        frame.add(messageLabel);
        frame.add(userLoginField);
        frame.add(userPwdField);
        frame.add(loginBtn);
        frame.add(resetBtn);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetBtn) {
            userLoginField.setText("");
            userPwdField.setText("");
            messageLabel.setText("");
        }
        if (e.getSource() == loginBtn) {
            String userEmail = userLoginField.getText();
            String userPassword = String.valueOf(userPwdField.getPassword());
            if (userEmail!=null){
                Authentification_Type loginRequest = new Authentification_Type();
                loginRequest.setEmail(userEmail);
                loginRequest.setPassword(userPassword);
                AuthentificationResponse response; 
                try {
                    response = logService.login(loginRequest);
                    if (response.getReturn() != null) {
                        if (response.getReturn().getRole().equalsIgnoreCase("admin")) {
                            messageLabel.setForeground(Color.GREEN);
                            messageLabel.setText("Logged In Successfully !");
                            frame.dispose();
                            GetUser userRequest = new GetUser();
                            userRequest.setArg0(userEmail);
                            userRequest.setArg1(userPassword);
//                            new MainPage(userRepo.getUser(userRequest.));
                            new MainPage(userRepo.getUser(userRequest).getReturn());

                        } else {
                            messageLabel.setForeground(Color.RED);
                            messageLabel.setText("You Are Not An Admin !");
                        }
                    }
                    else {
                        messageLabel.setForeground(Color.RED);
                        //LOG OR PASS INCORRECT
                        messageLabel.setText("Login ou mot de passe incorrect");
//                        messageLabel.setText(""+loginRequest);
                        
                    }
                } catch (Exception ex) {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("WebService indisponible veuilleaz reessayer...");
                }
            } else {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Invalid Email !");
            }

        }
    }
}