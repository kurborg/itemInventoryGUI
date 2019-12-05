import java.util.LinkedList;
import java.util.Scanner;

public class inventory
{
	
	public void inv() 
	{

		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int choice = 0;
		String usern;
		String passw;
		String retEmp;
		String retItem;
		fileHandler fh = new fileHandler();
		fileHandlerInventory fhi = new fileHandlerInventory();
		TestGui GUI = new TestGui();

		LinkedList<item> invent = fhi.readFile();
		LinkedList<employee> users = fh.readFile();
		
		admin boss = new admin("admin", "password");
		
		
		//System.out.println(boss.getName());
		//System.out.println(boss.getPassword());
		//LOGIN ACCESS GOES HERE

		//INSERT LOGIN HERE
		//ASSIGN TEXTBOX TO EQUAL STRING <usern>
		//ASSIGN TEXTBOX TO EQUAL STRING <passw>
		
		/*System.out.println("Please enter the username: \n");
		usern = reader.nextLine();
		
		System.out.println("Please enter the password: \n");
		passw = reader.nextLine();
		*/
		
		usern = GUI.getName();
		passw = GUI.getPassword();
		
		
		if(boss.login(usern, passw) == 1)
		{

			//INSERT ADMIN MAIN SCRREEN HERE AND TRIGGER
			//THE BUTTONS TO CORRESPOND TO INT <choice> FOR EACH CASE STATEMENT
			//-1 = EXIT OR LOGOUT 
			
				while(choice != -1)
				{
					switch(choice)
					{
					case 1:
						//retItem = boss.addItem(invent);
						//fhi.appendFile(retItem);
						break;
					case 2:
						//boss.removeItem(invent);
						//fhi.overwriteFile(invent);
						break;
					case 3:
						//retEmp = boss.addUser(users);
						//fh.appendFile(retEmp);
						break;
					case 4:
					//	boss.removeUser(users);
					//	fh.overwriteFile(users);
						break;
					case 5:
						//boss.addStock(invent);
						fhi.overwriteFile(invent);
						break;
					case 6:
						//boss.removeStock(invent);
						fhi.overwriteFile(invent);
						break;
					case 7:
						boss.receiveAlerts(invent);
						break;
					case 8:
						boss.showEmployees(users);
						break;
					default:
						System.out.println("\nNot a valid Input");
						break;
					}
					
					choice = boss.getAdminChoice();
				}
				
				System.out.println("\n Goodbye!");
				return;
			}
		
		
			for(int i = 0; i < users.size(); i++)
			{
				if(users.get(i).getName().equals(usern) && users.get(i).getPassword().equals(passw))
				{
					employee worker = new employee(usern,passw);
					
					if (worker.login(usern, passw) == 1)
					{
						
						//INSERT EMPLOYEE MAIN SCRREEN HERE AND TRIGGER
						//THE BUTTONS TO CORRESPOND TO INT <choice> FOR EACH CASE STATEMENT
						//-1 = EXIT OR LOGOUT 
						
						choice = worker.getEmployeeChoice();
						
						while(choice != -1)
						{
							switch(choice)
							{
							case 1:
								//worker.addStock(invent);
								fhi.overwriteFile(invent);
								break;
							case 2:
								//worker.removeStock(invent);
								fhi.overwriteFile(invent);
								break;
							case 3:
								worker.receiveAlerts(invent);
								break;
							default:
								System.out.println("\nNot a valid Input");
								break;
							}
							
							choice = worker.getEmployeeChoice();
						}
						
						System.out.println("\n Goodbye!");
						return;
					}
				}
			}
		
	}
}