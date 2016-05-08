#include <iostream>
#include <string>
using namespace std;

string W;

int main(){
  cin >> W;

  for(int i = 0, len = W.length(); i < len; i++){
    switch(W[i]){
      case 'a': case 'i': case 'u': case 'e': case 'o':
      break;
      default:
      cout << W[i]; break;
    }
  }

  cout << endl;

  return 0;
}
