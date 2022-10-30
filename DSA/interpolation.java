import java.util.*;
class interpolation 
{
    public static int interpolationSearch(int arr[],int lo,int hi,int x)
    {
        int pos;
        if (lo<=hi && x>=arr[lo] && x<=arr[hi]) 
        {
            pos=lo+(((hi-lo)/(arr[hi]-arr[lo]))* (x-arr[lo]));
            if(arr[pos]==x)
                return pos;
            if(arr[pos]<x)
                return interpolationSearch(arr,pos+1,hi,x);
            if(arr[pos]>x)
                return interpolationSearch(arr,lo,pos-1,x);
        }
        return -1;
    }
    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("Enter the element to be searched:");
        int key=sc.nextInt();
        int index=interpolationSearch(arr, 0,n-1,key);
        if (index!=-1)
            System.out.println("Element found at index "+index);
        else
            System.out.println("Element not found.");
        sc.close();
    }
}