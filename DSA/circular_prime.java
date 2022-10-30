import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class circular_prime
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number to check: ");
        int n=Integer.parseInt(br.readLine());
        int nn=n,c=0,n1=n,n2=n,f=0;
        while(nn>0)
        {
            c++;
            nn/=10;
        }
        do
        {
            n=n1;
            if(!isprime(n))
            {
                f=1;
                break;
            }
            int r=n%10;
            int q=n/10;
            n1=(int)Math.pow(10,c-1)*r+q;
			if(n1!=n2)
			{
				System.out.println(n1);
			}
        }
        while(n1!=n2);

        if(f==1)
            System.out.println("Not circular prime");
        else
            System.out.println("circular prime");
    }

    static boolean isprime(int n)
    {
        int c=0;
        for(int i=1;i<=n;i++)
        {
            if(n%i==0)
            {
                c++;
            }
        }
        return c == 2;
    }
}
