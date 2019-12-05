import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class removeUser extends JFrame {

	private JPanel contentPane;
	private JTextField userName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					removeUser frame = new removeUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public removeUser() {
		admin boss = new admin("admin", "password");
		fileHandler fh = new fileHandler();

		LinkedList<employee> users = fh.readFile();


		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 813, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddUser = new JLabel("Remove User");
		lblAddUser.setBounds(224, 11, 351, 68);
		lblAddUser.setFont(new Font("Tahoma", Font.PLAIN, 41));
		lblAddUser.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAddUser);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(170, 118, 120, 39);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblUsername);
		
		
		
		JButton btnAdd = new JButton("Remove");
		btnAdd.setBounds(328, 202, 137, 31);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String retEmp;
				String name = userName.getText();
				
				if(boss.removeUser(users, name) ==1)
				{
				
				JOptionPane.showMessageDialog(contentPane, "User succesfully removed.");
				userName.setText("");
				fh.overwriteFile(users);
				}
				else 
				{
					JOptionPane.showMessageDialog(contentPane, "User not found.");
				}
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnAdd);
		
		userName = new JTextField();
		userName.setBounds(300, 125, 235, 31);
		contentPane.add(userName);
		userName.setColumns(10);
	}
}
