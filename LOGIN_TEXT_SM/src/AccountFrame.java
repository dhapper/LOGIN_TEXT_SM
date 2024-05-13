import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class AccountFrame {

    public static void main(String[] args) {
        AccountFrame af = new AccountFrame();
        af.accountFrame("a");
    }

	int width = 800, height = 800;
    int panelWidth = width/2, panelHeight = height*2;
	
    public void accountFrame(String username) {

        Color dark = new Color(0, 0, 255, 125);
        Color light = new Color(0, 0, 255, 100);
        
        JFrame frame = new JFrame();
        frame.setSize(width, height);
        frame.setLayout(null);
        
        // post panel
        JPanel postPanel = new JPanel();
        postPanel.setBounds(0, 0, width/2, height);
        postPanel.setBackground(dark);

        JLabel welcomeLabel = new JLabel("Welcome " + username + "!");
        welcomeLabel.setFont(new Font(welcomeLabel.getFont().getName(), Font.BOLD, 20));
        postPanel.add(welcomeLabel);
        
        JTextArea postTextArea = new JTextArea(10, 35);
        postTextArea.setBackground(Color.LIGHT_GRAY);
        postTextArea.setLineWrap(true);
        postTextArea.setWrapStyleWord(true);
        postPanel.add(postTextArea);

        JButton postButton = new JButton("Post");
		postPanel.add(postButton);
        
		postButton.addActionListener(e-> {
			UseMongoDB useMongoDB = new UseMongoDB();
			useMongoDB.addPost(username, postTextArea.getText());
			postTextArea.setText("");
		});
		
        // history panel
        JPanel feedPanel = new JPanel();
        feedPanel.setLayout(new GridLayout(6, 1));
        feedPanel.setBounds(panelWidth, 0, width/2, height);
        feedPanel.setBackground(light);

        JLabel yourHistoryLabel = new JLabel(username + "'s Post History:");
        //yourHistoryLabel.setBounds(panelWidth/2, height/2, 250, 30);
        yourHistoryLabel.setFont(new Font(yourHistoryLabel.getFont().getName(), Font.BOLD, 20));
        feedPanel.add(yourHistoryLabel);

        // past posts
        UseMongoDB useMongoDB = new UseMongoDB();
        for(int i = 0; i < useMongoDB.collectUserPosts(username).size(); i++) {
        	System.out.println("x");
        	historyUI(useMongoDB.collectUserPosts(username).get(i), feedPanel, i);
        	System.out.println("y");
        }
        
        frame.add(postPanel);
        frame.add(feedPanel);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public void historyUI(String content, JPanel panel, int postNum) {
    	JLabel pastPost = new JLabel("<html><div style='width:200px;'>" + content + "</div></html>");
    	pastPost.setFont(new Font(pastPost.getFont().getName(), Font.BOLD, 12));
    	panel.add(pastPost);
    	System.out.println(postNum);
    }
}
