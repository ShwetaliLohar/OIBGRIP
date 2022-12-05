import java.util.Scanner;
class GuessGame
{
	public static void main(String args[])
		{
			int min=1;
			int max =100;
			int range=max-min+1;
//int random,guess;
			int guess;
			int n  =(int)(Math.random()*range)+min;
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter any number between 1 to 100");
			guess=sc.nextInt();
					do
					{
						
						
						if(guess>n)
						{
							System.out.println(" Enter lower Number");
						
						}
						else
						{
							System.out.println("Enter Higher number");
							
						}
						guess=sc.nextInt();
						if(guess==n)
						{
							System.out.println("The guess is correct");
							
						}
					
					}while(guess!=n);
		
		
		
		}




}