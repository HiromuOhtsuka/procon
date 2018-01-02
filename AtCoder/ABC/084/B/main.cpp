#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#include <cmath>
#include <string>
#define INF (INT_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int a, b;
  cin >> a >> b;
  string s;
  cin >> s;

  bool valid = true;
  for(int i = 0; i < a; i++){
    if(!isdigit(s[i])){
      valid = false;
      break;
    }
  }
  if(s[a] != '-') valid = false;
  for(int i = a + 1; i < a + b + 1; i++){
    if(!isdigit(s[i])){
      valid = false;
      break;
    }
  }

  if(valid) cout << "Yes" << endl;
  else cout << "No" << endl;

  return 0;
}
