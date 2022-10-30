#include <iostream>
using namespace std;

bool son(int* arr,int n){
	if(n==0||n==1){
		return true;
	}
	else if(arr[0]>arr[1]){
		return false;
		
	}
	else{
		son(arr+1,n-1);
	}
	
}
int main(){
	int n;
	cin>>n;
	int arr[n];
	for(int i=0;i<n;i++){
		cin>>arr[i];
	}
	int ans =son(arr,n);
	if(ans){
		cout<<"Array is Sorted";
	}
	else{
		cout<<"Not Sorted";
	}
}