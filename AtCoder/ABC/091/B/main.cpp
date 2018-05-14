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
#define MAX_N 100
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  string s[MAX_N];
  for(int i = 0; i < n; i++){
    cin >> s[i];
  }
  int m;
  cin >> m;
  string t[MAX_N];
  for(int i = 0; i < m; i++){
    cin >> t[i];
  }

  bool exist[n];
  fill(exist, exist + n, true);
  for(int i = 0; i < m; i++){
    for(int j = 0; j < n; j++){
      if(exist[j] && s[j] == t[i]){
        exist[j] = false;
        break;
      }
    }
  }

  int ans = 0;
  for(int i = 0; i < n; i++){
    int count = 0;
    for(int j = 0; j < n; j++){
      if(exist[i] && exist[j] && 
        s[i] == s[j]) ++count;
    }
    ans = max(ans, count);
  }

  cout << ans << endl;

  return 0;
}
