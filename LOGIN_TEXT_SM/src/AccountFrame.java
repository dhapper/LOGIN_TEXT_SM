import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class AccountFrame {

    public static void main(String[] args) {
        AccountFrame af = new AccountFrame();
        af.accountFrame();
    }

    public void accountFrame() {
        int width = 800, height = 800;
        int panelWidth = width/2, panelHeight = height*2;

        String username = "dhaarshan";

        Color dark = new Color(0, 0, 255, 125);
        Color light = new Color(0, 0, 255, 100);
        
        JFrame frame = new JFrame();
        frame.setSize(width, height);
        frame.setLayout(null);
        
        // post panel
        JPanel postPanel = new JPanel();						// null
        postPanel.setBounds(0, 0, width/2, height);
        postPanel.setBackground(dark);

        JLabel welcomeLabel = new JLabel("Welcome " + username + "!");
        welcomeLabel.setFont(new Font(welcomeLabel.getFont().getName(), Font.BOLD, 20));
        postPanel.add(welcomeLabel);
        
        JTextArea postTextArea = new JTextArea(5, 35);
        postTextArea.setBackground(Color.LIGHT_GRAY);
        postPanel.add(postTextArea);

        JButton postButton = new JButton("Post");
		postPanel.add(postButton);
        
		postButton.addActionListener(e-> {
			// counter = 0
			// counter++
			// get text from text area and put it in db along with counter?
			// iterate through 0-100?
			// pull and display messages in that order
			
		});
		
        // history panel
        JPanel feedPanel = new JPanel();						// null
        feedPanel.setBounds(width/2, 0, width/2, height);
        feedPanel.setBackground(light);

        JLabel yourHistoryLabel = new JLabel(username + "'s Post History:");
        yourHistoryLabel.setBounds(panelWidth/2, height/2, 250, 30);
        yourHistoryLabel.setFont(new Font(yourHistoryLabel.getFont().getName(), Font.BOLD, 20));
        feedPanel.add(yourHistoryLabel);

        // past posts
        
        
        frame.add(postPanel);
        frame.add(feedPanel);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
