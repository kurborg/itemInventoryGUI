import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class employee
{
	private String name;
	

	fileHandlerTransactionHistory fht = new fileHandlerTransactionHistory();


	private String password;
	final private Scanner reader = new Scanner(System.in);
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	employee(String username, String passw)
	{
		name = username;
		password = passw;
	}
	
	public String getName() {
		return name;
	}
	
	public int login(String usern, String pass)
	{
		if(usern.equals(name) && pass.equals(password))
			return 1;
		else 
			return 0;
	}
	
	public int addStock(LinkedList<item> invent, String item, int amount)
	{
		int result = 0;
		String name = item;
		/*System.out.println("Please enter the item's name: \n");
		name = reader.nextLine();
		
		System.out.println("Please enter the amount to add: \n");
		amount = getIntInput();
		*/
		for(int i = 0; i < invent.size(); i++)
		{
			if(invent.get(i).getName().equals(name))
			{
				invent.get(i).amount += amount;
				System.out.println("Item stock has been replenished!\n");
				fht.appendFile(getName(), name, amount);
				result = 1;
			}
		}
		
		return result;
		
	}
	
	public int removeStock(LinkedList<item> invent, String item, int amount)
	{
		String name = item;
		int result = 0;
		
		/*System.out.println("Please enter the item's name: \n");
		name = reader.nextLine();
		
		System.out.println("Please enter the amount to remove: \n");
		amount = getIntInput();
		*/
		
		for(int i = 0; i < invent.size(); i++)
		{
			if(invent.get(i).getName().equals(name))
			{
				invent.get(i).amount -= amount;
				System.out.println("Item stock has been removed!\n");
				fht.appendFile(getName(), name, (-1 * amount));
				result = 1;
			}
		}

		return result;
	}
	

	
	public void receiveAlerts(LinkedList<item> invent)
	{
		for(int i = 0; i < invent.size(); i++)
		{
			System.out.println("Item: " + invent.get(i).getName() + 
					"\nAmount: " + invent.get(i).getAmount() + "\n");
			if(invent.get(i).getAmount() < 5)
				System.out.println("Item: " + invent.get(i).getName() + 
						" is low on stock.\nIt has a remaining amount of:" + invent.get(i).getAmount() + "\n\n");
		}
		
		if(invent.size() < 1)
		{
			System.out.println("The inventory contains no items!\n\n");
		}
	}
	

	
	
	public int getIntInput()
	{
		int num = 0;
		
		while(num == 0)
		{
			try
			{
				num = reader.nextInt();
				
				if (num == 0)
					throw new InputMismatchException();
				reader.nextLine();
			}
			catch(InputMismatchException e)
			{
				reader.nextLine();
				System.out.println("\nError Invalid Input: Please try again");
			}
		}
		
		return num;
	}
	

	public String toString()
	{
		return name + "," + password;
	}
	
	public int getEmployeeChoice()
	{
		int choice;
		
		System.out.print("\n\nWELCOME TO THE INVENTORY MANAGEMENT SYSTEM" + "\n" + 
				"===============================" + "\n" 
				+ "1) Add Stock\n" + "2) Remove Stock\n" + "3) Show Inventory\n\n"+ 
				"Please enter your option or -1 to quit: \n");
		
		choice = getIntInput();
		return choice;
	}
}