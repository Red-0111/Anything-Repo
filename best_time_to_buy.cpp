#include <bits/stdc++.h>
using namespace std;
int Best(vector<int> &prices)
{
    int l = 0;
    int r = 1;

    int val = 0;
    for (int i = 0; i < prices.size() - 2; i++)
    {
        int diff = prices.at(r) - prices.at(l);
        if (diff > 0)
        {
            r = r + 1;
            if (diff > val)
            {
                val = diff;
            }
        }

        else
            l = l + 1;
    }
    return val;
}