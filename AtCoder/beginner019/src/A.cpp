#include <iostream>
using namespace std;

int main(){
  int a, b, c;
  cin >> a;
  cin >> b;
  cin >> c;
  for(int i=0; i<2; i++){
    if(a > b){
      int tmp = a;
      a = b;
      b = tmp;
    }
    if(b > c){
      int tmp = b;
      b = c;
      c = tmp;
    }
  }
  cout << b;

  return 0;
}
