// to_string() , sto_() works for everything except char

#include<iostream>

using namespace std;

void ANY_to_string(){
    int x=23; double y=3.14; char ch='A';
    string si=to_string(x); //int to string  (string si=x is wrong)
    string sd=to_string(y); //double to string
    string sc=""; sc=sc+ch; //char to string
    
  //string sc=""+ch;  //string+string ✓ , string+char X in initialisation only. Else ✓ 
  
  //string sc=to_string(ch);  stores ASCII value of char instead of original
    cout<<si<<endl<<sd<<endl<<sc<<endl;
}

void string_to_ANY(){
    string si="23", sd="3.140000", sc="A";
    int x=stoi(si);     //string to int   (int x=si is wrong)
    double y=stod(sd);  //string to double
    char ch=sc[0];      //string to char
  //char ch=stoc(ch)  doesn't exist  
  //∵ string to char is not possible since char variable can't accept multiple characters
  //But string to char array is possible 
    cout<<x<<endl<<y<<endl;
}

void REST_not_concerning_strings(){
    //int <-> char
    //int <-> double
    //double <-> char
    //(rest) 

    //all done by TYPECASTING
}

void ArraytoString(){
    char ch[]={'C','+','+','\0'};
    string s=string(ch);
    cout<<s<<endl;
}

int main(){
    ANY_to_string();
    string_to_ANY();
    REST_not_concerning_strings();
    ArraytoString();
}