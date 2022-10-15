import java.util.Arrays;

public class threeConsecutive{
    public static void main(String[] args) {
        int x = 5;
        int y = 5;
        int z = 4;
        int w = 5;
        int dp[][][][]=new int[x+1][y+1][z+1][w+1];
        for(int arr1[][][]:dp) for(int arr2[][]:arr1) for(int arr3[]:arr2) Arrays.fill(arr3, -1);
        System.out.println(solve(x, y, z, w, -1,dp));
    }

    private static int solve(int x,int y,int z,int w,int last,int dp[][][][]){
        if(x==0 && y==0 && z==0 && w==0) return 1;
        if(x<0 || y<0 || z<0 || w<0) return 0;
        if(dp[x][y][z][w]!=-1) return dp[x][y][z][w];
        int ans=0;
            if(last!=0)ans+= solve(x-1,y,z,w,0,dp);
            if(last!=1)ans+= solve(x,y-1,z,w,1,dp);
            if(last!=2)ans+= solve(x,y,z-1,w,2,dp);
            if(last!=3)ans+= solve(x,y,z,w-1,3,dp);
        return dp[x][y][z][w]=ans;
    }
}
