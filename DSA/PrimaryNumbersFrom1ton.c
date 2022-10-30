#include<stdio.h>
#include<stdlib.h>

int main()
{
    int i, j, num;
    printf("Enter the number: ");
    scanf("%d", &num);

    for(i = 2; i <= num; i++)
    {
        for(j = 2; j <= i; j++)
        {
            if(i % j == 0)
            {
                break;
            }
        }
        if( i == j)
        {
            printf("%d\n", i);
        }

    }
    return 0;
}
