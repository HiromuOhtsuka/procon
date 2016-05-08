#include <iostream>
#include <algorithm>
using namespace std;

int main(){
  int n, a, b, c;
  cin >> n;
  if(n == 2){
    cin >> a >> b;
    for(int i = 1; i <= min(a, b); i++){
      if(a % i == 0 && b % i == 0){
        cout << i << endl;
      }
    }
  }
  else{
    cin >> a >> b >> c;
    for(int i = 1; i <= min(a, min(b, c)); i++){
      if(a % i == 0 && b % i == 0 && c % i == 0){
        cout << i << endl;
      }
    }
  }

  return 0;
}
