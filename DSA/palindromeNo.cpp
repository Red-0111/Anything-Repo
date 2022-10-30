#include <iostream>
using namespace std;

int pow(int x, int p)
{
    if (p == 0)
    {
        return 1;
    }
    else
    {
        return x * pow(x, p - 1);
    }
}
int main()
{
    int num;
    cout << "Enter number: " << endl;
    cin >> num;
    bool cond = true;
    int n = 1;
    int count = 1;
    int q;
    while (cond)
    {
        q = num / n;
        if (q <= 1)
        {
            break;
        }
        n = n * 10;
        count = count + 1;
    }
    int dup;
    int change = num;
    int list[count];
    for (int i = count; i > 0; i--)
    {
        dup = change;
        int revd = 0;
        for (int j = i - 1; j > 0; j--)
        {
            dup = dup % pow(10, j);
        }

        if (i == 1)
        {
            dup = int(num / pow(10, count - 1));
        }
        revd = dup;
        list[count - i] = revd;
        change = change / 10;
    }

    int rev = 0;
    for (int i = count; i > 0; i--)
    {
        rev = rev + pow(10, i - 1) * list[count - i];
    }
    if (rev == num)
    {
        cout << "Palindrome";
    }
    else
    {
        cout << "Not a palindrome";
    }
}