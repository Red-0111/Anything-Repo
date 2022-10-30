class Solution {
public:
    int maximalRectangle(vector<vector<char>> &matrix)
{
    int n = matrix.size();
    if (n == 0)
        return 0;
    int m = matrix[0].size();
    int dp[n][m];
    memset(dp, 0, sizeof(dp));
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (matrix[i][j] == '1')
            {
                if (j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i][j - 1] + 1;
            }
        }
    }
    int ans = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (dp[i][j] > 0)
            {
                int width = dp[i][j];
                for (int k = i; k >= 0; k--)
                {
                    width = min(width, dp[k][j]);
                    ans = max(ans, width * (i - k + 1));
                }
            }
        }
    }
    return ans;
}
};
