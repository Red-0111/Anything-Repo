 #include<iostream>
using namespace std;

class Complex{
    public:
    int x,y;
    Complex(){this->x=0; this->y=0;}
    Complex(int x,int y){this->x=x; this->y=y;}
    
 //<return type> operator<operator>(arguments){<body>}
    // Complex operator++(){    //pre-increment
    //     Complex temp;
    //     temp.x=++this->x ;
    //     temp.y=++y;   //this not required
    //     return temp;
    // } 
    
    Complex operator++(int){  //post-increment
        Complex temp;
        temp.x=this->x++ ;
        temp.y=y++;   //this not required
        return temp;
    } 
};

int main(){
    Complex c1(10,20),c2;
    //c2=c1.operator++();
    
    // c2=++c1; //pre
    c2=c1++; //post
    
    cout<<c2.x<<endl<<c2.y<<endl;
    cout<<c1.x<<endl<<c1.y<<endl;
}