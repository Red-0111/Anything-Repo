import java.io.*;
import java.util.*;
class hello
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //int a[]=Arrays.stream(br.readLine().split("[ ]+")).mapToInt(Integer::parseInt).toArray();
        //System.out.println(Arrays.toString(a));
		
		int n=Integer.parseInt(br.readLine());
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=Integer.parseInt(br.readLine());
		}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				int ans=(a[i] & a[j]) ^ (a[i] | a[j]);
				if(ans<min)
				{
					min=ans;
				}
			}
		}
		System.out.println(min);
    }
}