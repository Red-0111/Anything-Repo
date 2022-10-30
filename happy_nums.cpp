#include <bits/stdc++.h>
using namespace std;

int sq_sum(int n)
{
    int sum = 0;
    string s = to_string(n);
    int i = 0;
    while (s[i])
    {
        int dig = (s[i] - 48);
        sum = sum + pow(dig, 2);
        i = i + 1;
    }
    return sum;
}

bool isHappy(int n)
{
    set<int> unique = {};
    int sum = n;
    bool cond = true;
    bool happy = false;
    while (cond == true)
    {
        // cout << sum << endl;
        int len = unique.size();
        sum = sq_sum(sum);
        if (sum != 1)
        {
            unique.insert(sum);
        }
        if (len == unique.size())
        {
            cond = false;
        }
        if (sum == 1)
        {
            cond = false;
            happy = true;
        }
    }
    return happy;
}

int main()
{
    cout << isHappy(19);
}