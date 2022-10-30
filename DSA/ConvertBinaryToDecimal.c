#include<stdio.h>
#include<stdlib.h>

int main()
{
    int bin1, decimal = 0, weight = 1, rem;
    printf("Enter the binary number: ");
    scanf("%d", &bin1);

    while(bin1 != 0)
    {
        rem = bin1 % 10;
        decimal = decimal + rem * weight;
        bin1 = bin1 / 10;
        weight = weight * 2;

    }
    printf("The decimal equivalent of binary number %d is %d", bin1, decimal);
    return 0;
}
