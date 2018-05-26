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

  int n;
  cin >> n;
  string s;
  cin >> s;

  int ans = 0;
  for(int i = 1; i < n; i++){
    set< char > x;
    for(int j = 0; j < i; j++){
      x.insert(s[j]);
    }
    set< char > y;
    for(int j = i; j < n; j++){
      y.insert(s[j]);
    }
    int count = 0;
    for(char ch: x){
      if(y.find(ch) != y.end()){
        ++count;
      }
    }
    ans = max(ans, count);
  }

  cout << ans << endl;

  return 0;
}
