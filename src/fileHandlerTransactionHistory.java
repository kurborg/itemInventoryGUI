import java.io.*;

public class fileHandlerTransactionHistory {
		
		public void appendFile(String item1, String name1, int amt1) 
		{
			String text = item1;
			String name = name1;
			int amt = amt1;
			
			try(BufferedWriter writer = new BufferedWriter(new FileWriter("transactionHistory.csv", true)))
			{
				writer.write(text + ", " + name + ", " + amt + "\n");
			}
			
			catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		public void appendFileEmp(String name1) 
		{
			String name = name1;
			
			try(BufferedWriter writer = new BufferedWriter(new FileWriter("transactionHistory.csv", true)))
			{
				writer.write("Admin added new employee: " + name + "\n");
			}
			
			catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		public void appendFileRemEmp(String name1) 
		{
			String name = name1;
			
			try(BufferedWriter writer = new BufferedWriter(new FileWriter("transactionHistory.csv", true)))
			{
				writer.write("Admin removed employee: " + name + "\n");
			}
			
			catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		
}