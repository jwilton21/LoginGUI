
// Import frame and panel related Swing libraries.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// Make a basic window, with labels, text field to enter text and a button. Put them on frame.
//Frame is window. Panel is layout.
// Reuse actionListener across multiple components.
public class GUI  implements ActionListener
{	// Global variables.
	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordTextHidden;
	private static JButton button;
	private static JLabel success; 

	public static void main(String[] args) 
	{	// Make frame and panel objects.
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		// Configure frame object
		frame.setSize(350, 200);
		// Close properly, JFrame library exit on close.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Put panel on frame.
		frame.add(panel);

		// Configure panel.
		panel.setLayout(null);
		// Make label. User label with user name text box && password label, password text box. Login button with message.
		userLabel = new JLabel("User name");
		// Set bounds/padding
		// x,  y, w,  h
		userLabel.setBounds(10, 20, 80, 25);
		// Add label to the panel.
		panel.add(userLabel);


		// Make text field. Define length of textField in this constructor.
		userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);

		// Label.
		passwordLabel = new JLabel("Password");
		// Set bounds.			// x,  y, w,  h
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);

		// Password masked out.
		passwordTextHidden = new JPasswordField();
		// Same width and height as user text box.
		passwordTextHidden.setBounds(100, 50, 165, 25);
		// Add to panel.
		panel.add(passwordTextHidden);

		// Button.
		button = new JButton("Login");
		// Set bounds.
		button.setBounds(10, 80, 80, 25);
		// Pass in new GUI object.
		button.addActionListener(new GUI());
		// Add to panel.
		panel.add(button);

		// Check user text and password text, if it matches, show successful login message.

		success = new JLabel("");
		// Set bounds.
		success.setBounds(10, 110, 300, 25);
		// Add to panel.
		panel.add(success);


		frame.setVisible(true);;
	}

	@Override
	// Button tied to this method.
	public void actionPerformed(ActionEvent e) 
	{	// Test button.
		// System.out.println("Test");
		String user = userText.getText();
		// Deprecated method but still works...maybe not in production...
		@SuppressWarnings("deprecation")
		String password = passwordTextHidden.getText();
		// If matches then success.
		if(user.equals("User") && password.equals("BadPassword123"))
		{success.setText("Login successful");

		}
		// Else login unsuccessful.
		else 
		{
			success.setText("Login unsuccessful, re-enter login details.");
		}
	}

}
