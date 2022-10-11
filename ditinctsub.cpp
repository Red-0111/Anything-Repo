// class Solution {
// public:
//     int helper(string &s,string &t,int x,int y,vector<vector<int>> &dp)
//     {
//         if(y==t.size())return 1;
//         if(x==s.size())return 0;
//         if(dp[x][y]!=-1)return dp[x][y];
//         if(s[x]==t[y])return dp[x][y]=helper(s,t,x+1,y+1,dp)+helper(s,t,x+1,y,dp);
//         else return dp[x][y]=helper(s,t,x+1,y,dp);
//     }
//     int numDistinct(string s, string t) {
//         vector<vector<int>> dp(s.size()+1,vector<int>(t.size()+1,-1));
//         return helper(s,t,0,0,dp);
//     }
// };

class Solution {
public:
    int numDistinct(string s, string t) {
	//we use unsigned int because there is a case with a quite large data
        vector<vector<unsigned int>> dp(t.size() + 1, vector<unsigned int>(s.size() + 1));
        
		//set as default value of  the first line as 1
        for (int j = 0; j <= s.size(); j++)dp[0][j] = 1;

//logic of the loop is above
        for (int i = 1; i <= t.size(); i++) {
            for (int j = 1; j <= s.size(); j++) {

					if (t[i - 1] == s[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }
                else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[dp.size() - 1][dp[0].size() - 1];
    }
};
