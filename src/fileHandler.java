import java.util.LinkedList;
import java.io.*;

public class fileHandler {

		public LinkedList<employee> readFile()
		{
			LinkedList<employee> empL = new LinkedList<employee>();
			String lineRead;
			String[] splitLine;
			employee emp;
			
			try(BufferedReader reader = new BufferedReader(new FileReader("employees.csv")))
			{
				lineRead = reader.readLine();
				while(lineRead != null)	
				{ 
					splitLine = lineRead.split(",");
					emp = new employee(splitLine[0],splitLine[1]);
					
					empL.add(emp);
					lineRead = reader.readLine();
				}
				
			}
			
			catch (IOException e)
			{
				System.out.println(e.getMessage());
			}
			

			return empL;
		}
		
		public void appendFile(String emp) 
		{
			String text = emp;
			try(BufferedWriter writer = new BufferedWriter(new FileWriter("employees.csv", true)))
			{
				writer.write(text + "\n");
			}
			
			catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		public void overwriteFile(LinkedList<employee> empL)
		{
			String s;
			
			try(BufferedWriter writer = new BufferedWriter(new FileWriter("employees.temp", false)))
			{
				for (int i = 0; i < empL.size(); i++) 
				{
					s = empL.get(i).toString();
					writer.write(s + "\n");
				}
			}
			catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
			
			try
			{
				File f = new File("employees.csv");
				File tf = new File("employees.temp");
				
				f.delete();
				tf.renameTo(f);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
}