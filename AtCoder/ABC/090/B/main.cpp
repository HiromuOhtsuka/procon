#include <iostream>
#include <climits>
#include <cmath>
#include <algorithm>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <string>
#define INF_INT (INT_MAX / 2)
#define INF_LONG (LONG_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int a, b;
  cin >> a >> b;

  int count = 0;
  for(int i = a; i <= b; i++){
    string s = to_string(i);
    int n = s.length();
    bool p = true;
    for(int j = 0; j < n / 2; j++){
      if(s[j] != s[n - 1 - j]){
        p = false;
        break;
      }
    }
    if(p) ++count;
  }

  cout << count << endl;

  return 0;
}
