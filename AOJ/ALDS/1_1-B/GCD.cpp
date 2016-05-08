#include <iostream>
using namespace std;

int x, y;

int GCD(int a, int b){
  if(b == 0){
    return a;
  }
  return GCD(b, a % b);
}

int main(){
  cin >> x >> y;
  cout << GCD(x, y) << endl;
  return 0;
}
