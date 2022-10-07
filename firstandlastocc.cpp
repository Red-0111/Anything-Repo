#include <bits/stdc++.h>
using namespace std;
int firstOcc(int arr[], int size, int key)
{
    int start = 0;
    int end = size - 1;
    int mid = start + (end - start) / 2;
    int ans = -1;

    while (start <= end)
    {
        if (arr[mid] == key)
        {
            ans = mid;
            end = mid - 1;
        }
        // go to right part
        else if (key > arr[mid])
        {
            start = mid + 1;
        }
        // go to left part(key < mid)
        else if(key < arr[mid])
        {
            end = mid - 1;
        }
        mid = start + (end - start) / 2;
    }
    return ans;
}
int lastOcc(int arr[], int size, int key)
{
    int start = 0;
    int end = size - 1;
    int mid = start + (end - start) / 2;
    int ans = -1;

    while (start <= end)
    {
        if (arr[mid] == key)
        {
            ans = mid;
            start = mid + 1;
        }
        // go to right part
        else if (key > arr[mid])
        {
            start = mid + 1;
        }
        // go to left part(key < mid)
        else if(key < arr[mid])
        {
            end = mid - 1;
        }
        mid = start + (end - start) / 2;
    }
    return ans;
}
int main()
{
    int even[5] = {1, 2, 3, 3, 5};

    cout << "Fisrt occurence  of 3 is: " << firstOcc(even, 5, 3) << endl;
    cout << "last occurence  of 3 is: " << lastOcc(even, 5, 3);

    return 0;
}