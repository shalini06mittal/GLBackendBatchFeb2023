package test;

import java.util.Scanner;

public class FruitNames {

	
	public void m1()
	{
		return ;
	}
	public static void main(String[] args) {
		
		char ch;
		String s = "WebWorld";
		for(int i=0;i<s.length();i++)
		{
		 	ch = s.charAt(i);
		 	for(int j=1;j<=2;j++)
		 	if(Character.isUpperCase(ch))
		 		System.out.print(ch);
		 	else System.out.print("$");
		 	System.out.println();
		}

				
		
		Scanner sc = new Scanner(System.in);
		String sent[] = new String[5];
		for (int i = 0; i < sent.length; i++) {
			System.out.println("enter a sentence");
			sent[i] = sc.nextLine();
		}
		
		for (int i = 0; i < sent.length; i++) {
			String line = sent[i];
			if(line.endsWith("fruit"))
			{
				int idx = line.indexOf(' ');
				System.out.println(line.substring(0,idx));
			}
		}

	}

}
