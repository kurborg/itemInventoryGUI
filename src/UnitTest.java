import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class UnitTest {

	@Test
	void addStock()
	{
		employee test = new employee("username", "password");
		fileHandlerInventory fhi = new fileHandlerInventory();
		LinkedList<item> invent = fhi.readFile();
		int output = test.addStock(invent, "dog", 2);
		
		assertEquals(1, output);
	}
	
	@Test
	void removeStock()
	{
		employee test = new employee("username", "password");
		fileHandlerInventory fhi = new fileHandlerInventory();
		LinkedList<item> invent = fhi.readFile();
		int output = test.removeStock(invent, "dog", 2);
		
		assertEquals(1, output);
	}
	
	@Test
	void addItem()
	{
		admin test = new admin("username", "password");
		fileHandlerInventory fhi = new fileHandlerInventory();
		LinkedList<item> invent = fhi.readFile();
		String output = test.addItem(invent, "Test", 2);
		
		assertEquals("Test,2", output);
	}
	
	@Test
	void removeItem()
	{
		admin test = new admin("username", "password");
		fileHandlerInventory fhi = new fileHandlerInventory();
		LinkedList<item> invent = fhi.readFile();
		int output = test.removeItem(invent, "dog");
		
		assertEquals(1, output);
	}
	
	
	void addUser()
	{
		admin test = new admin("username", "password");
		fileHandler fh = new fileHandler();
		LinkedList<employee> users = fh.readFile();
		String output = test.addUser(users, "Username", "Password");
		
		assertEquals("Username,Password", output);
	}
	
	
	void removeUser()
	{
		admin test = new admin("username", "password");
		fileHandler fh = new fileHandler();
		LinkedList<employee> users = fh.readFile();
		int output = test.removeUser(users, "Username");
		
		assertEquals(1, output);
	}
	
	
	

}
