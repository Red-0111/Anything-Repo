#include<stdio.h>
#include<stdlib.h>

int main()
{
    int i,j ;
    int startnum;
    int finishnum;

    printf("Enter the starting number: ");
    scanf("%d", &startnum);
    printf("Enter the finishing number: ");
    scanf("%d", &finishnum);
    for(i = startnum; i <= finishnum; i++)
    {
        for(j = startnum; j <= i; j++)
        {
            if(i%j == 0)
            {
                break;
            }
        }
        if(i == j)
        {
            printf("%d\n", i);
        }
    }
    return 0;
}
