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

  string s;
  cin >> s;

  int ans = 0;
  for(int i = 0; i < s.length(); i++){
    if(isdigit(s[i])){
      if(i + 1 < s.length() && isdigit(s[i + 1])){
        ans = 10 * (s[i] - '0') + (s[i + 1] - '0');
      }
      else{
        ans = s[i] - '0';
      }
      break;
    }
  }

  cout << ans << endl;

  return 0;
}
