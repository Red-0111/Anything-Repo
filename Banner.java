import java.io.*;
import java.util.*;

public class Banner
{
    public static void main(String[] args) throws IOException 
	{
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=sc.nextInt();
		if(n<=2||n>=9)
        {
            System.out.println("INVALID INPUT");
        }
		else
        {
            System.out.println("Enter team names:");
            String s[]=new String[n];
            int l=0;
            String sl="";
            for(int i=0;i<n;i++)
            {
                s[i]=br.readLine();
                if(s[i].length()>l)
                {
                    l=s[i].length();
                    sl=s[i];
                }
            }
            for(int i=0;i<n;i++)
            {
                while(s[i].length()<l)
                {
                    String ss=s[i];
                    ss=ss+' ';
                    s[i]=ss;
                }
            }
            char ch[][]=new char[n][l];
            for(int i=0;i<n;i++)
            {
                int k=0;
                for(int j=0;j<l;j++)
                {
                    ch[i][j]=s[i].charAt(k++);
                }
            }
            for(int i=0;i<l;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.print(ch[j][i]+"\t");
                }
                System.out.println();
            }
        }
    }
}
