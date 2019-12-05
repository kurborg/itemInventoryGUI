public class item
{
	public String name;
	public int amount;
	
	item(String itemName, int startAmount)
	{
		name = itemName;
		amount = startAmount;
	}
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getAmount() 
	{
		return amount;
	}
	public void setAmount(int amount) 
	{
		this.amount = amount;
	}
	
	public String toString()
	{
		return name + "," + amount;
	}
	

}