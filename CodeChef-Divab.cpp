#include <iostream>
using namespace std;

int main(){
    int t;
    cin >> t;
    while(t--){
        int a,b,n;
        cin >> a >> b >> n;
        int coun = n;
        while(a%n==0){
            n++;
        }
        while(true){
            if(!(b%n==0)){
                n+=a;
            }
            else{
                break;
            }
        }
        cout << n << endl;
    }
}