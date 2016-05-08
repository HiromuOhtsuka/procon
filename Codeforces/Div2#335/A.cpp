#include <iostream>
using namespace std;

int a, b, c, x, y, z;

int main(){
  cin >> a >> b >> c;
  cin >> x >> y >> z;

  a -= x; b -= y; c -= z;

  int r = 0;
  if(a > 0){
    r += a / 2;
  }
  if(b > 0){
    r += b / 2;
  }
  if(c > 0){
    r += c / 2;
  }

  if(a < 0){
    r += a;
  }
  if(b < 0){
    r += b;
  }
  if(c < 0){
    r += c;
  }

  if(r < 0){
    cout << "No" << endl;
  }
  else{
    cout << "Yes" << endl;
  }

  return 0;
}
