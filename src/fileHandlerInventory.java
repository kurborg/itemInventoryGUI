import java.util.LinkedList;
import java.io.*;

public class fileHandlerInventory {

		public LinkedList<item> readFile()
		{
			LinkedList<item> invent = new LinkedList<item>();
			String lineRead;
			String[] splitLine;
			item item1;
			
			try(BufferedReader reader = new BufferedReader(new FileReader("inventory.csv")))
			{
				lineRead = reader.readLine();
				while(lineRead != null)	
				{
					splitLine = lineRead.split(",");
					item1 = new item(splitLine[0], Integer.parseInt(splitLine[1]));
					
					invent.add(item1);
					lineRead = reader.readLine();
				}
				
			}
			
			catch (IOException e)
			{
				System.out.println(e.getMessage());
			}
			

			return invent;
		}
		
		public void appendFile(String item1) 
		{
			String text = item1;
			try(BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.csv", true)))
			{
				writer.write(text + "\n");
			}
			
			catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		public void overwriteFile(LinkedList<item> invent)
		{
			String s;
			
			try(BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.temp", false)))
			{
				for (int i = 0; i < invent.size(); i++) 
				{
					s = invent.get(i).toString();
					writer.write(s + "\n");
				}
			}
			catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
			
			try
			{
				File f = new File("inventory.csv");
				File tf = new File("inventory.temp");
				
				f.delete();
				tf.renameTo(f);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
}