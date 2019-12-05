import java.awt.BorderLayout;
import java.util.LinkedList;
import java.util.Scanner;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainMenuAdmin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField itemNameRemove;
	private JTextField amountRemoveItem;
	private JTextField itemNameAdd;
	private JTextField amountAddItem;
	private JTextField itemNameAddInv;
	private JTextField amountAddInv;
	private JTextField itemNameRemoveInv;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuAdmin frame = new MainMenuAdmin();
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
	public MainMenuAdmin() {
		
		admin boss = new admin("admin", "password");
		fileHandlerInventory fhi = new fileHandlerInventory();
		LinkedList<item> invent = fhi.readFile();
		String retItem;

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 784);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeUser = new JLabel("Welcome ");					
		lblWelcomeUser.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblWelcomeUser.setBounds(20, 0, 306, 65);
		contentPane.add(lblWelcomeUser);
		
		table = new JTable();
		table.setBounds(20, 110, 733, 359);
		contentPane.add(table);
		
		JButton btnLoadItems = new JButton("Load Items ");
		btnLoadItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//TODO: Assign a function once Database is set up
				
				
				for(int i = 0; i < invent.size(); i++)
				{
					System.out.println("Item: " + invent.get(i).getName() + 
							"\nAmount: " + invent.get(i).getAmount() + "\n");
				}
				
				
			}
		});
		btnLoadItems.setBounds(20, 66, 177, 30);
		contentPane.add(btnLoadItems);
		
		JButton btnRemoveItem = new JButton("Remove Item From Stock");
		btnRemoveItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemoveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
				String itemName = itemNameRemove.getText();
				String Amount = amountRemoveItem.getText();
				int itemAmount = Integer.parseInt(Amount);
				if (boss.removeStock(invent,itemName,itemAmount) == 1)
				{
					JOptionPane.showMessageDialog(contentPane, "Succesfully removed inventory.");
					itemNameRemove.setText("");
					amountRemoveItem.setText("");
					fhi.overwriteFile(invent);
				}
				else 
				{
					JOptionPane.showMessageDialog(contentPane, "Item not found!");
					amountRemoveItem.setText("");
					itemNameRemove.setText("");
				}
				
			}
		});
		btnRemoveItem.setBounds(519, 480, 234, 41);
		contentPane.add(btnRemoveItem);
		
		JLabel lblItemName = new JLabel("Item Name:");
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblItemName.setBounds(20, 480, 137, 41);
		contentPane.add(lblItemName);
		
		itemNameRemove = new JTextField();
		itemNameRemove.setBounds(101, 480, 177, 41);
		contentPane.add(itemNameRemove);
		itemNameRemove.setColumns(10);
		
		JLabel itemLabelRemove = new JLabel("Amount:");
		itemLabelRemove.setFont(new Font("Tahoma", Font.PLAIN, 14));
		itemLabelRemove.setBounds(297, 480, 119, 41);
		contentPane.add(itemLabelRemove);
		
		amountRemoveItem = new JTextField();
		amountRemoveItem.setBounds(359, 480, 112, 41);
		contentPane.add(amountRemoveItem);
		amountRemoveItem.setColumns(10);
		
		JLabel label = new JLabel("Item Name:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(20, 532, 137, 41);
		contentPane.add(label);
		
		itemNameAdd = new JTextField();
		itemNameAdd.setColumns(10);
		itemNameAdd.setBounds(101, 532, 177, 41);
		contentPane.add(itemNameAdd);
		
		JLabel ItemLabelAdd = new JLabel("Amount:");
		ItemLabelAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ItemLabelAdd.setBounds(297, 532, 119, 41);
		contentPane.add(ItemLabelAdd);
		
		amountAddItem = new JTextField();
		amountAddItem.setColumns(10);
		amountAddItem.setBounds(359, 532, 112, 41);
		contentPane.add(amountAddItem);
		
		JButton btnAddItem = new JButton("Add Item To Stock");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
				
				String itemName = itemNameAdd.getText();
				String Amount = amountAddItem.getText();
				int itemAmount = Integer.parseInt(Amount);
				if (boss.addStock(invent,itemName,itemAmount) == 1)
				{
					JOptionPane.showMessageDialog(contentPane, "Succesfully replenished inventory.");
					itemNameAdd.setText("");
					amountAddItem.setText("");
					fhi.overwriteFile(invent);
				}
				else 
				{
					JOptionPane.showMessageDialog(contentPane, "Item not found!");
					itemNameAdd.setText("");
					amountAddItem.setText("");
				}
				
				
			}
		});
		btnAddItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddItem.setBounds(519, 532, 234, 41);
		contentPane.add(btnAddItem);
		
		JLabel label_2 = new JLabel("Item Name:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(20, 584, 137, 41);
		contentPane.add(label_2);
		
		itemNameAddInv = new JTextField();
		itemNameAddInv.setColumns(10);
		itemNameAddInv.setBounds(101, 584, 177, 41);
		contentPane.add(itemNameAddInv);
		
		JLabel InvLabelAdd = new JLabel("Amount:");
		InvLabelAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		InvLabelAdd.setBounds(297, 584, 119, 41);
		contentPane.add(InvLabelAdd);
		
		amountAddInv = new JTextField();
		amountAddInv.setColumns(10);
		amountAddInv.setBounds(359, 584, 112, 41);
		contentPane.add(amountAddInv);
		
		JButton btnAddItemTo = new JButton("Add Item To Inventory");
		btnAddItemTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String retItem;
				String itemName = itemNameAddInv.getText();
				String Amount = amountAddInv.getText();
				int itemAmount = Integer.parseInt(Amount);
				
				retItem = boss.addItem(invent,itemName, itemAmount);
				
				if (retItem != "")
				{
					JOptionPane.showMessageDialog(contentPane, "Succesfully added item to inventory.");
					itemNameAddInv.setText("");
					amountAddInv.setText("");
					
					fhi.appendFile(retItem);
				}

				
				
			}
		});
		btnAddItemTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddItemTo.setBounds(519, 584, 234, 41);
		contentPane.add(btnAddItemTo);
		
		JLabel label_4 = new JLabel("Item Name:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(20, 636, 137, 41);
		contentPane.add(label_4);
		
		itemNameRemoveInv = new JTextField();
		itemNameRemoveInv.setColumns(10);
		itemNameRemoveInv.setBounds(101, 636, 177, 41);
		contentPane.add(itemNameRemoveInv);
		
		JButton btnRemoveItemFrom = new JButton("Remove Item From Inventory");
		btnRemoveItemFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//TODO: Assign a function 
				
			
				String retItem;
				String itemName = itemNameRemoveInv.getText();
				
				
				if (boss.removeItem(invent, itemName) == 1)
				{
					JOptionPane.showMessageDialog(contentPane, "Succesfully removed item from inventory.");
					itemNameRemoveInv.setText("");
					
					fhi.overwriteFile(invent);
				}
				else 
				{
					JOptionPane.showMessageDialog(contentPane, "Item not found.");
					itemNameRemoveInv.setText("");
				}
				
			}
		});
		btnRemoveItemFrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemoveItemFrom.setBounds(519, 636, 234, 41);
		contentPane.add(btnRemoveItemFrom);
		
		JButton AddNewUser = new JButton("Add New User Account");
		AddNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//TODO: Add function to open new JFrame to add user into database
				
				addUserGUI addUser = new addUserGUI();
				addUser.setVisible(true);
				
			}
		});
		AddNewUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		AddNewUser.setBounds(576, 11, 177, 50);
		contentPane.add(AddNewUser);
		
		JButton removeUser = new JButton("Remove User Account");
		removeUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				removeUser removeUser = new removeUser();
				removeUser.setVisible(true);
				
			}
		});
		removeUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		removeUser.setBounds(389, 11, 177, 50);
		contentPane.add(removeUser);
		
		table_2 = new JTable();
		table_2.setBounds(20, 110, 733, 359);
		contentPane.add(table_2);
		
	}
}
