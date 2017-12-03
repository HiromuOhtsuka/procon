#include <iostream>
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  int m = n;
  int sum = 0;
  while(m != 0){
    sum += m % 10;
    m /= 10;
  }

  if(n % sum == 0){
    cout << "Yes" << endl;
  }
  else{
    cout << "No" << endl;
  }

  return 0;
}
