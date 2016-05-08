#include <iostream>
using namespace std;

int main(){
  int a, b;
  char o;

  cin >> a;
  for(;;){
    cin >> o;
    if(o == '='){
      cout << a << endl;
      return 0;
    }
    cin >> b;
    switch(o){
      case '+' : a = a + b; break;
      case '-' : a = a - b; break;
      case '*' : a = a * b; break;
      case '/' : a = a / b; break;
    }
  }

  return 0;
}
