#include <stdio.h>
#include <math.h>
#include <string.h>
#define ARRAY_SIZE  20
int main()
{
    char hex[ARRAY_SIZE];
    long long decimal = 0, base = 1;
    int i = 0, value, length;
    /* Get hexadecimal value from user */
    printf("Enter hexadecimal number: ");
    fflush(stdin);
    fgets(hex,ARRAY_SIZE,stdin);
    length = strlen(hex);
    for(i = length--; i >= 0; i--)
    {
        if(hex[i] >= '0' && hex[i] <= '9')
        {
            decimal += (hex[i] - 48) * base;
            base *= 16;
        }
        else if(hex[i] >= 'A' && hex[i] <= 'F')
        {
            decimal += (hex[i] - 55) * base;
            base *= 16;
        }
        else if(hex[i] >= 'a' && hex[i] <= 'f')
        {
            decimal += (hex[i] - 87) * base;
            base *= 16;
        }
    }
    printf("\nHexadecimal number = %s", hex);
    printf("Decimal number = %lld\n", decimal);
    return 0;
}
