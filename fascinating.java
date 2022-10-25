import java.io.*;
class Fascinating_2021
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the value upto which you have to find fascinating number: ");
		int size = Integer.parseInt(br.readLine());
		System.out.println("Fascinating numbers are:");
		for (int i = 1; i <= size; i++)
		{
			if (isFascinate(i))
				System.out.print(i + " ");
		}
	}
	static boolean isFascinate(int n1)
	{
		int n2=n1*2;
		int n3=n1*3;
		String s1=n1+Integer.toString(n2)+Integer.toString(n3);
		int []a={0,0,0,0,0,0,0,0,0,0};
		for(int i=0;i<s1.length();i++)
		{
			a[s1.charAt(i)-48]++;
		}
		int flag=0;
		for(int i=1;i<a.length;i++)
		{
			if(a[i]!=1)
			{
				flag=1;
				break;
			}
		}
		return flag == 0;
	}
}