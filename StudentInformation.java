import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentInformation extends JFrame {
	JButton adminButton = new JButton("Admin");
	// adminButton.setBounds(0,0,100, 40);
	JButton userButton = new JButton("User");
	// userButton.setBounds(0,0,100, 40);

	StudentInformation(String name) {
		super(name);
		setLocation(400, 500);

		Clicklistener click = new Clicklistener();
		JPanel p1 = new JPanel(new GridLayout(1, 2));
		p1.setBounds(70, 200, 200, 50);
		p1.add(adminButton);
		p1.add(userButton);
		adminButton.addActionListener(click);
		userButton.addActionListener(click);
		this.setVisible(true);
		add(p1);

		setSize(400, 500);
		// setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		new StudentInformation("Welcome");
	}

	private class Clicklistener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == adminButton) {
				new AdminForm("Admin");

			} else if (e.getSource() == userButton) {
				new UserForm("User");

			}

		}
	}
}

	class AdminForm extends JFrame {
		JButton a1 = new JButton("Add details");
	    JButton a2 = new JButton("Delete details");
	    JButton a3 = new JButton("Modify details.");

		
		AdminForm(String name) {
			super(name);
			setLocation(400, 500);

			Clicklistener AdminClick = new Clicklistener();
			JPanel adminPanel = new JPanel(new GridLayout(3, 1));
			adminPanel.setBounds(70, 200, 200, 50);
			adminPanel.add(a1);
			adminPanel.add(a2);
			adminPanel.add(a3);
			a1.addActionListener(AdminClick);
			a2.addActionListener(AdminClick);
			a3.addActionListener(AdminClick);
			this.setVisible(true);
			add(adminPanel);

			setSize(400, 500);
			// setLayout(null);
			setVisible(true);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		}
		
		
		private class Clicklistener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == a1) {
					

				} else if (e.getSource() == a2) {
					

				}
				else if (e.getSource() == a3) {
					

				}

			}
		}
		
	}
	
	
	class UserForm extends JFrame {
		JButton u1 = new JButton("View details by roll number");
	    JButton u2 = new JButton("View details by name.");
	    

		
		UserForm(String name) {
			super(name);
			setLocation(400, 500);

			Clicklistener UserClick = new Clicklistener();
			JPanel userPanel = new JPanel(new GridLayout(2, 1));
			userPanel.setBounds(70, 200, 200, 50);
			userPanel.add(u1);
			userPanel.add(u2);
			
			u1.addActionListener(UserClick);
			u2.addActionListener(UserClick);
			
			this.setVisible(true);
			add(userPanel);

			setSize(400, 500);
			// setLayout(null);
			setVisible(true);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		}
		
		private class Clicklistener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == u1) {
					

				} else if (e.getSource() == u2) {
					

				}

			}
		}
	}