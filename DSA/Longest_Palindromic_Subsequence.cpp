#include <bits/stdc++.h>
using namespace std;
// problem link  : https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string1956/1

void printSubStr(
    string str, int low, int high)
{
    for (int i = low; i <= high; ++i)
        cout << str[i];
}

int longestPalSubstr(string str)
{
    int n = str.size();

    bool dp[n][n];

    memset(dp, 0, sizeof(dp));

    int maxLength = 1;

    for (int i = 0; i < n; ++i)
        dp[i][i] = true;

    int start = 0;
    for (int i = 0; i < n - 1; ++i)
    {
        if (str[i] == str[i + 1])
        {
            dp[i][i + 1] = true;
            start = i;
            maxLength = 2;
        }
    }

    for (int k = 3; k <= n; ++k)
    {
        for (int i = 0; i < n - k + 1; ++i)
        {
            int j = i + k - 1;

            if (dp[i + 1][j - 1] && str[i] == str[j])
            {
                dp[i][j] = true;

                if (k > maxLength)
                {
                    start = i;
                    maxLength = k;
                }
            }
        }
    }

    cout << "Longest palindrome substring is: ";
    printSubStr(str, start, start + maxLength - 1);

    return maxLength;
}

int main()
{
    string str = "babad";
    cout << longestPalSubstr(str);
    return 0;
}
