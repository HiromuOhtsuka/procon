#include <iostream>
using namespace std;

int N;

bool zorome(int n){
  const int r = n % 10;
  while(n / 10){
    n /= 10;
    int m = n % 10;
    if(m != r){
      return false;
    }
  }
  return true;
}

int main(){
  cin >> N;

  int count = 0, n = 0;
  while(count != N){
    ++n;
    if(zorome(n)){
      ++count;
    }
  }

  cout << n << endl;

  return 0;
}
