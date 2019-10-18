import java.util.*;
import java.io.*;
class lib
{
	String title, code;
	int q;
	float cost, total;
	Scanner inp = new Scanner(System.in);
	void read()
	{
		System.out.println("Enter book title:");
		title = inp.nextLine();
		System.out.println("Enter book code:");
		code = inp.next();
		System.out.println("Enter cost:");
		cost = inp.nextFloat();
		System.out.println("Enter quantity:");
		q = inp.nextInt();
		//total = q*cost;
	}
	void display()
	{
		System.out.println(title+"\t"+code+"\t"+cost+"\t"+q+"\t"+total);
	}
	void withdraw(int a)
	{
		if(q>=a)
		{
			q = q-a;
			total=a*cost;
			System.out.println("Name: "+title+"Cost "+cost+"Quantity "+q+"total= "+total);
			//total = total - (a*cost);
		}
		else
			System.out.println("Insufficient number of books");

	}
	void deposit(int a)
	{
		q = q+a;
		total = total + (a*cost);
	}
}
class book1
{
	public static void main(String args[])
	{
		int i,n,ch;
		String name;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of books:");
		n = sc.nextInt();
		lib ob[] = new lib[n];
		for(i=0;i<n;i++)
		{
			ob[i] = new lib();
			ob[i].read();
		}
		System.out.println("title\tcode\tcost\tquantity\ttotal");
		for(i=0;i<n;i++)
			ob[i].display();
		while(true)
		{
			System.out.println("Enter choice:\n1.Withdraw books\n2.Deposit books\n3.Display\n");
			ch = sc.nextInt();
			switch(ch)
			{
				case 1:	System.out.print("Enter the book you want to withdarw:");
						sc.nextLine();
						name = sc.nextLine();
						System.out.println("Enter the quantity:");
						int q1 = sc.nextInt();
						char flag = '0';
						for(i=0; i<n; i++)
						{
							if(name.equals(ob[i].title))
							{
								ob[i].withdraw(q1);
								flag = '1';
								break;
							}
						}
						if(flag == '0')
							System.out.println("Book not found");
						break;

				case 2: System.out.print("Enter the book you want to deposit:");
						sc.nextLine();
						name = sc.nextLine();
						System.out.println("Enter the quantity:");
						q1 = sc.nextInt();
						flag = '0';
						for(i=0; i<n; i++)
						{
							if(name.equals(ob[i].title))
							{
								ob[i].deposit(q1);
								flag = '1';
								break;
							}
						}
						if(flag == '0')
							System.out.println("Book not found");
						break;
				case 3: System.out.println("title\tcode\tcost\tquantity\ttotal");
						for(i=0;i<n;i++)
						ob[i].display();
						break;
				default: System.exit(0);
			}
		}
	}
}

