/*Two prime number program:
WAP to print all two prime number between 1 to n:
A number is said to be two prime- when it has only two distinct prime factors
Example- 6=2,3
         36=2,2,3,3
*/

import java.io.*;
import java.util.*;
class two_prime
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the value of n:");
		int n=Integer.parseInt(br.readLine());
		System.out.println("Two prime numbers upto "+n+" are:");
		for(int i=2;i<=n;i++)
		{
			int a[]=new int[n];
			int j=2,k=0,nn=i;
			while(j<=nn)
			{
				if(nn%j==0)
				{
					nn=nn/j;
					a[k++]=j;
				}
				else if(j==2)
				{
					j=3;
				}
				else
				{
					j=j+2;
				}
			}
			Arrays.sort(a,0,k);
			int c=1;
			for(int m=0;m<k-1;m++)
			{
				if(a[m]!=a[m+1])
				{
					c++;
				}
			}
			if(c==2)
			{
				System.out.print(i+" ");
			}
		}
	}
}