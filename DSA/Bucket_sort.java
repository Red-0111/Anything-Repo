import java.util.Scanner;
class Bucket_sort
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] a =new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        bucket(a);
//        for(int i=0;i<n;i++)
//        {
//            System.out.print(a[i]+" ");
//        }
    }
    static void bucket(int a[])
    {
        int n=a.length;
        int[] count =new int[10];
        int[] output =new int[n];
        for(int i=0;i<10;i++)
            count[i]=0;

        for(int i=0;i<n;i++)
            count[a[i]]++;

        for(int i=1;i<10;i++)
            count[i]+=count[i-1];

        for(int i=n-1;i>=0;i--)
        {
            output[count[(a[i]%10)]-1]=a[i];
            count[a[i]%10]--;
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(output[i]+" ");
        }
    }
}
