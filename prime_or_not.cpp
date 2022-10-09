#include<iostream>
using namespace std;

int main(){
	bool isprime=1;
	int n;
	cin>>n;
	for(int i=2;i<n;i++){
		if(n%i==0){
			
			isprime=0;
			break;
		}

	}
	if(isprime==0){
		cout<<"NOT A PRIME NO."<<endl;
	}
	else{
		cout<<"IS A PRIME NO."<<endl;
	}
}