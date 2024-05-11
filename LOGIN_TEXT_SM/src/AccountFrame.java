import javax.swing.*;

public class AccountFrame {
	
	public static void main(String[] args) {
		AccountFrame af = new AccountFrame();
        af.accountFrame();
	}
	
	public void accountFrame() {
		int width = 800, height = 800;
		
		String username = "dhaarshan";
		
		JFrame frame = new JFrame();
		frame.setSize(width, height);
		
		JPanel panel = new JPanel(null);	// holds components
	
		
		JLabel welcomeLabel = new JLabel("Welcome " + username + "!");
		welcomeLabel.setBounds(width/20, height/20, 250, 30);
		panel.add(welcomeLabel);
		
		JLabel usernameLabel = new JLabel("Welcome " + username + "!");
		usernameLabel.setBounds(width/2, height*2, 250, 30);
		panel.add(usernameLabel);
		
		//text box
		
		//post button
		
		//past posts
		
		JScrollPane scrollPane = new JScrollPane(panel);
		
		frame.add(scrollPane);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}	
