import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.Scanner;


public class addUserGUI extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addUserGUI frame = new addUserGUI();
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
	public addUserGUI() {
		
		admin boss = new admin("admin", "password");
		fileHandler fh = new fileHandler();

		LinkedList<employee> users = fh.readFile();


		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 813, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddUser = new JLabel("Add User");
		lblAddUser.setFont(new Font("Tahoma", Font.PLAIN, 41));
		lblAddUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddUser.setBounds(214, 11, 351, 68);
		contentPane.add(lblAddUser);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(10, 125, 120, 39);
		contentPane.add(lblUsername);
		
		userName = new JTextField();
		userName.setBounds(122, 128, 231, 39);
		contentPane.add(userName);
		userName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(398, 125, 120, 39);
		contentPane.add(lblPassword);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(502, 128, 231, 39);
		contentPane.add(password);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String retEmp;
				String name = userName.getText();
				String pass = password.getText();
				
				retEmp = boss.addUser(users, name, pass);
				fh.appendFile(retEmp);
				
				JOptionPane.showMessageDialog(contentPane, "User succesfully added.");
				userName.setText("");
				password.setText("");
				
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(332, 202, 137, 31);
		contentPane.add(btnAdd);
	}
}
