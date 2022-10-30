import java.util.Scanner;

public class magic_square
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the matrix in odd numbers: ");
        int n=sc.nextInt();
        int [][]a=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                a[i][j]=0;
            }
        }
        int r=n-1,c=n/2;
        a[r][c]=1;
        for(int i=2;i<=n*n;i++)
        {
            if(a[(r+1)%n][(c+1)%n]==0)
            {
                r=(r+1)%n;
                c=(c+1)%n;
                a[r][c]=i;
            }
            else
            {
                r=(r+n-1)%n;
                a[r][c]=i;
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
