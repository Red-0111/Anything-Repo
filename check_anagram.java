import java.util.*;
import java.io.*;  
class Anagram 
{  
	public static void main(String[] args)
	{
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the number of test case:");
			int t =Integer.parseInt(br.readLine());
			String s1="",s2="",s="";
			String[] ans =new String[t];
			for(int i=0;i<t;i++)
			{
				System.out.println("Enter the "+(i+1)+" string separated by single space:");
				s=br.readLine();
				int l=s.lastIndexOf(' ');
				s1=s.substring(0,l);
				s2=s.substring(l+1);
				
				if(anagrams(s1,s2)==1)
				{
					ans[i]="Yes";
				}
				else
				{
					ans[i]="No";
				}
			}
			for(int i1=0;i1<t;i1++)
			{
				System.out.println(ans[i1]);
			}
	   }

		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	static int anagrams(String s1,String s2)
	{
		if(s1.length()!=s2.length())
			return 0;
		else
		{
			if(s1.equals(s2))
			{
				return 1;
			}
			else
			{
				char ss1[]=s1.toCharArray();
				char ss2[]=s2.toCharArray();
				Arrays.sort(ss1);
				Arrays.sort(ss2);
				if(Arrays.equals(ss1, ss2))
					return 1;
				else
					return 0;
			}
		}
	}
}
