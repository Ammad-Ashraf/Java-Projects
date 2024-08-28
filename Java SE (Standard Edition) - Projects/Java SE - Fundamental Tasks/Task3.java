class Account
{
	public int accnum;
	public float balance;
	String accountype;
	public Account()
	{
		this.accnum=0;
		this.balance=0;
		this.accountype="Saving";
	}
	public Account(Account ob)
	{
		this.accnum=ob.accnum;
		this.balance=ob.balance;
		this.accountype=ob.accountype;	
	}
	void depositmoney(int amount)
	{
		this.balance+=amount;
	
	}
	void withdraw(int amount)
	{
		if(this.balance<=amount)
		{
			System.out.println("Transaction not possible");
		}else
		{
			this.balance-=amount;
			System.out.println("Transaction successful");
			
		}
	}
	void displayinfo()
	{
		System.out.println("Account Information");
		System.out.println("Account number : "+ this.accnum);
		System.out.println("Balance : "+this.balance);
		System.out.println("Account type : "+this.accountype);
	}
}
class Customers
{
	public int id;
	public String name;
	public Account [] accounts;
	public Customers()
	{
		this.id=0;
		this.name="";
	}
	public void addaccount(Account acc)
	{
		int i=0;
		accounts[i]=acc;
		i++;
	}
	void deposit(int number,int accnumber)
	{
		for(int i=0;i<2;i++)
		{
			if(accounts[i].accnum==accnumber)
			{
				accounts[i].depositmoney(number);
			}
		}
	}
	void withdraw(int number,int accnumber)
	{
		for(int i=0;i<2;i++)
		{
			if(accounts[i].accnum==accnumber)
			{
				accounts[i].withdraw(number);
			}
		}
	}
	void displayinfor(int accnum)
	{
		for(int i=0;i<2;i++)
		{
			if(accounts[i].accnum==accnum)
			{
				accounts[i].displayinfo();
			}
		}	
	}
}
public class Task3 {

	public static void main(String[] args) {
		
		Account obj1=new Account();
		obj1.accnum=12;
		obj1.balance=5000;
		obj1.accountype="Saving";
		Customers obj=new Customers();
		obj.addaccount(obj1);
		obj.deposit(5000, 12);
		obj.withdraw(5000, 12);
		obj.withdraw(10000, 12);
		obj.displayinfor(12);
		

	}

}
