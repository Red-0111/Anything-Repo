import java.io.*;
import java.util.*;
class firstAndLastOccurance
{
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int len=sc.nextInt();
        int arr[]=new int[len];
        System.out.println("Enter the array elements:");
        for(int i=0;i<len;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the element you want to know the starting and the end index:");
        int key=sc.nextInt();
        int l=0,r=0;
        for(int i=0;i<len;i++)
        {
            if(arr[i]==key)
            {
                l=i;
                break;
            }
        }
        for(int i=len-1;i>=0;i--)
        {
            if(arr[i]==key)
            {
                r=i;
                break;
            }
        }
        System.out.println("First index is "+(l+1)+" and last index is "+(r+1));
        sc.close();;
    }
}