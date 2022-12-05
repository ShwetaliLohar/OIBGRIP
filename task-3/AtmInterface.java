import java.util.Scanner;
import java.util.*;
class BankAccount
{
	String name;
	String userName;
	String password;
	String accountNo;
	float balance=200000f;
	int transaction=0;
	String transactionHistory="";
	
	public void register()
	{
		Scanner sc=new Scanner(System.in);
		this.name=sc.nextLine();
		System.out.println("Enter username");
		this.userName=sc.nextLine();
		System.out.println("Enter password");
		this.password=sc.nextLine();
		System.out.println("Enter accountNo");
		this.accountNo=sc.nextLine();
		System.out.println("\n Registration completed..kindly Login");
	}
	public boolean login()
	{
		boolean isLogin=false;
		Scanner sc=new Scanner(System.in);
		while(!isLogin)
		{
			System.out.println("Enter username=");
			String Username=sc.nextLine();
			if(Username.equals(userName))
			{
			while(!isLogin)
				{
					System.out.print("Enter Password=");
					String Password=sc.nextLine();
					if(Password.equals(password))
					{
						System.out.println("\n Login succesful");
						isLogin=true;
					}
					else
					{
						System.out.println("Password is incorrect");
					}
				}
            }
			else{
				System.out.println("\n Username is not found");
			}
		}
		return isLogin;
	}
	public void withdraw()
	{
		System.out.println("\n Enter amount to withdraw=");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		try
		{
			if(balance>=amount)
			{
				transaction++;
				balance-=amount;
				System.out.println("\n Withdraw is succesful");
				String str=amount+"Rs withdrawed\n";
				transactionHistory=transactionHistory.concat(str);
			}
			else{
				System.out.println("\n Insufficient balance");
			}
		}
		catch(Exception e)
		{
		}
	}
	public void deposit()
	{
		System.out.println("\n Enter amount to deposit=");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		try
		{
			if(amount<=200000)
			{
				transaction++;
				balance+=amount;
				System.out.println("\n deposit is succesful");
				String str=amount+"Rs deposit\n";
				transactionHistory=transactionHistory.concat(str);
			}
			else{
				System.out.println("\n Sorry ......Limit is 200000.00");
			}
		}	
			catch(Exception e)
			{
			}
	}
	public void transfer()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter receipent's name");
		String receipent =sc.nextLine();
		System.out.println("Enter amount to transfer =");
		float amount=sc.nextFloat();
		try
		{
			if(balance>=amount)
			{
				if(amount<50000f)
				{
					transaction++;
					balance-=amount;
					System.out.println("\n  succesful Transefer to" + receipent);
					String str=amount+"Rs transferd to"+receipent +"\n";
					transactionHistory=transactionHistory.concat(str);
				}
				else{
				System.out.println("\n sorry Limit is 50000.00");
				}
			}
			else{
				System.out.println("\n Insufficient balance");
			}
			
		}
		catch(Exception e)
		{
		
		}
	}
	public void checkBalance()
	{
		System.out.println("\n"+balance+"Ra");	
	}
	public void  transHistory()
	{
		if(transaction ==0)
		{
			System.out.println("\n Empty");
		
		}
		else{
			System.out.println("\n"+transactionHistory);
		}
	}
}
public class AtmInterface
{
public 	static void main(String[] args)
{
	BankAccount b=new BankAccount();
	Scanner sc=new Scanner(System.in);
	System.out.println("..............welcome to Atm System.......");
	System.out.println("1.Register\n2.exit");
	System.out.println("Enter your choice");
	 int choice=sc.nextInt();
	if(choice==1)
	{
				b.register(); 
				while(true)
				{
					if(b.login())
					{
						System.out.println("..............welcome to bank"+b.name+"......");
						boolean isFinished=false;
						while(!isFinished)
						{
							System.out.println("\n 1.withdraw\n2.deposit\n3.Transfer\n4.check Balance\n5.transHistory");
							int c=sc.nextInt();
							switch(c)
							{
								case 1:
								b.withdraw();
								break;
								case 2:
								b.deposit();
								break;
								case 3:
								b.transfer();
								break;
								case 4:
								b.checkBalance();
								break;
								case 5:
								b.transHistory();
								break;
								case 6:
								isFinished=true;
								break;
							}
						}
					}
					else
					{
						System.exit(0);
					}
				}
	}
		else
		{
		System.exit(0);
		}
	}
}