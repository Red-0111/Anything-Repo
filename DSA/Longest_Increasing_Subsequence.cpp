#include <iostream>
#include <vector>
using namespace std;

// practice --> https://leetcode.com/problems/longest-increasing-subsequence/

// This approach is using prev_index

// Please revise in this order
// Recursion -> Memoization -> Tabulation -> Space Optimization

//
//
// Approaches ->

// Recursive Approach ------------------------------------------

int rec(vector<int> &arr, int &n, int index, int prev_index)
{
    if (index == n)
        return 0;

    int pick = 0, non_pick;

    if (prev_index == -1 or arr[index] > arr[prev_index])
        pick = 1 + rec(arr, n, index + 1, index);

    non_pick = 0 + rec(arr, n, index + 1, prev_index);

    return max(pick, non_pick);
}

int lengthOfLIS_rec(vector<int> &nums)
{
    int n = nums.size();

    return rec(nums, n, 0, -1);
}

// Memoized Approach ------------------------------------------

int mem(vector<int> &arr, int &n, int index, int prev_index, vector<vector<int>> &dp)
{
    if (index == n)
        return 0;

    if (dp[index][prev_index + 1] != -1)
        return dp[index][prev_index + 1];

    int pick = 0, non_pick;

    if (prev_index == -1 or arr[index] > arr[prev_index])
        pick = 1 + mem(arr, n, index + 1, index, dp);

    non_pick = 0 + mem(arr, n, index + 1, prev_index, dp);

    return dp[index][prev_index + 1] = max(pick, non_pick);
}

int lengthOfLIS_mem(vector<int> &nums)
{
    int n = nums.size();
    vector<vector<int>> dp(n, vector<int>(n + 1, -1));
    // using dp[n][n+1], because -1 state of prev_index can't be accessed in array, that's why we shifted the prev_index, like we'll say -1 to 0, 0 to 1, 1 to 2 ......... n-1 to n, n to n+1
    // that's why

    return mem(nums, n, 0, -1, dp);
}

// Tabulated Approach ------------------------------------------

int lengthOfLIS_tab(vector<int> &arr)
{
    int n = arr.size();
    vector<vector<int>> dp(n + 1, vector<int>(n + 1, 0));
    // but actually, we'll use kinda like reverse triangular dp matrix

    for (int index = n - 1; index >= 0; index--)
    {
        for (int prev_index = index - 1; prev_index >= -1; prev_index--)
        {
            int pick = 0, non_pick;

            if (prev_index == -1 or arr[index] > arr[prev_index])
                pick = 1 + dp[index + 1][index + 1];

            non_pick = 0 + dp[index + 1][prev_index + 1];

            dp[index][prev_index + 1] = max(pick, non_pick);
        }
    }

    return dp[0][-1 + 1]; // dp[0]
}

// Space Optimized Approach ------------------------------------------

int lengthOfLIS_SpaceOptimized(vector<int> &arr)
{
    int n = arr.size();
    vector<int> dp(n + 1, 0);

    for (int index = n - 1; index >= 0; index--)
    {
        vector<int> temp(index + 1, 0);
        for (int prev_index = index - 1; prev_index >= -1; prev_index--)
        {
            int pick = 0, non_pick;

            if (prev_index == -1 or arr[index] > arr[prev_index])
                pick = 1 + dp[index + 1];

            non_pick = 0 + dp[prev_index + 1];

            temp[prev_index + 1] = max(pick, non_pick);
        }
        dp = temp;
    }

    return dp[-1 + 1]; // dp[0]
}