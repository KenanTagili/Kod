#include <iostream>
using namespace std;
int main() {
	int a,b,c,d,f;
	cin>>a>>b>>c>>d;
	f=(720+60*a+b+c*60+d)/2;
	cout<<f/60<<":"<<f%60/10<<f%60%10;	
	return 0;
}
