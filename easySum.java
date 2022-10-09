import java.io.*;
import java.util.*;
class easySum
{
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int a[]=new int[m];
        for(int i=0;i<m;i++)
        a[i]=sc.nextInt();
        int n=sc.nextInt();
        int c[]=new int[n];
        for(int i=0;i<n;i++)
        c[i]=sc.nextInt();
        Arrays.sort(a);
        Arrays.sort(c);
        int bup=c[n-1]-a[m-1];
        int blow=c[0]-a[0];
        HashSet<Integer> st=new HashSet<Integer>();
        for(int i=0;i<n;i++)
        {
            int k=c[i];
            if(!st.contains(k))
            st.add(k);
        }
        LinkedHashSet<Integer> hs=new LinkedHashSet<Integer>();
        for(int i=0;i<m;i++)
        {
            for(int j=blow;j<=bup;j++)
            {
                if(st.contains(a[i]+j))
                {
                    if(!hs.contains(j))
                    hs.add(j);
                }
            }
        }
        // Iterator it=hs.iterator();
        // while(it.hasNext())
        // System.out.print(it.next()+" ");
         sc.close();
    }
}