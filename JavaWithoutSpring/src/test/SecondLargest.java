package test;

import java.util.Scanner;
/*
 * Create an array of string to store 5 sentences
 * [
 * "apple is fruit",
 * "tomato is vegetable",
 * "banana is fruit",
 * "bread is bakery",
 * "milk is dairy",
 * ]
 */
public class SecondLargest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st no");
		int  n = sc.nextInt();
		int l=n, sl=0;
		for(int i=1;i<=4;i++)
		{
			System.out.println("Enter a no");
			n = sc.nextInt();
			if(sl==0)
			{
				sl = n;
			}
			if(n > sl && n < l)
			{
				sl =n;
			}
			else if(n > l)
			{
				sl = l;
				l = n;
			}
			System.out.println(l + " "+sl);
		}
		System.out.println(sl);

	}

}
