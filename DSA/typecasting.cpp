//HIERARCHY:-                                     ASCII:-
//                    bytes                       A-Z : 65-90
// char               1                           a-z : 97-122
// short              2                           0-9 : 48-57
// int/long           4                          null : 0
// float              4                         space : 32
// double             8                          

//NOTE: Even though float's size= int's/long's, float is considered higher in hierarchy

//Automatic : Output in highest heirarchy (lower to higher)
//Typecasting/Manual : any desired form   (any form)

//Operation follows hierarchy. In a specific operation, variables of lesser
//hierarchy will automatically get converted to any present higher hierarchy in an operation

#include<iostream>
using namespace std;

int main(){
    char a='2';  //2.9 can't be accepted
    short b=2.9; //stores 2, equivalent to int, stores integers of lesser digits than int
    int c1=2.9;  //stores 2, instead of round off, whole decimal is eliminated
    long c2=2.9; //stores 2, equivalent to int, stores integers of greater digits than int
    float c3=2.9;//stores 2.9
    double d=2.9;//stores 2.9, equivalent to float, accepts more digits than float

    cout<<(int)a<<(short)a<<(double)a<<endl; //ascii value of char is same for every datatype

    cout<<a+b<<endl; //char '2' gets converted to short i.e. 50+2 (since short>char)

    cout<<b+10<<sizeof(b+10)<<endl; //short b gets converted to int (pc considers this 10 as int)
                                    //as we see through the sizeof function (4=int)
    cout<<c1/c3<<endl;    //int c1 convereted into float (since float>int) 
    
    cout<<(int)c1/c3<<endl;   //[2/2.2]        only c1 converted to int (no use)
    cout<<(int)(c1/c3)<<endl; //(int)[2/2.2]   whole operation converted to int    
    cout<<c1/(int)c3<<endl;   //[2/2]

    //(int)c3 --> TYPECASTING
   
    cout<<(float)(int)d<<endl;  // 2.9-->2-->2.0-->output:2
}
