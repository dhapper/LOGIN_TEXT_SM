import java.awt.FlowLayout;

import javax.swing.*;

public class LoginFrame {

	public void loginFrame(){

		int textFieldWidth = 160, textFieldHeight = 20;
		int buttonWidth = 100, buttonHeight = 30;
		int width = (int) (1.5*textFieldWidth), height = textFieldHeight*16;
		
		JFrame frame = new JFrame();
		frame.setSize(width, height);
		
		JPanel panel = new JPanel(null);	// holds components
		
		JLabel loginLabel = new JLabel("Login or Register");
		loginLabel.setBounds(width/2-textFieldWidth/2, textFieldHeight, textFieldWidth, textFieldHeight);
		panel.add(loginLabel);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(width/2-textFieldWidth/2, 2*textFieldHeight, textFieldWidth, textFieldHeight);
		panel.add(usernameLabel);
		
		JTextField usernameField = new JTextField();
		usernameField.setBounds(width/2-textFieldWidth/2, 3*textFieldHeight, textFieldWidth, textFieldHeight);
		panel.add(usernameField);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(width/2-textFieldWidth/2, 4*textFieldHeight, textFieldWidth, textFieldHeight);
		panel.add(passwordLabel);
		
		JTextField passwordField = new JTextField();
		passwordField.setBounds(width/2-textFieldWidth/2, 5*textFieldHeight, textFieldWidth, textFieldHeight);
		panel.add(passwordField);
		
		JButton loginButton = new JButton("Sign in");
		loginButton.setBounds(width/2-buttonWidth/2, 6*textFieldHeight+10, buttonWidth, buttonHeight);
		panel.add(loginButton);
		
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(width/2-buttonWidth/2, 8*textFieldHeight+10, buttonWidth, buttonHeight);
		panel.add(registerButton);
		
		JLabel errorLabel = new JLabel();
		errorLabel.setBounds(width/2-textFieldWidth/2, 10*textFieldHeight, textFieldWidth, textFieldHeight);
		panel.add(errorLabel);
		errorLabel.setVisible(false);
		
		Authenticator auth = new Authenticator();
		
		loginButton.addActionListener(e-> {
			String username = usernameField.getText();
            String password = passwordField.getText();
            
            auth.setCredentials(username, password);
            
            if(auth.authenticate()) {
            	errorLabel.setText("Login Sucessful!");
            }else {
            	errorLabel.setText("Error: Invalid Credentials");
            }
            errorLabel.setVisible(true);
		});
		
		frame.add(panel);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
