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

  int sw[n + 1], se[n + 1];
  fill(sw, sw + n + 1, 0);
  fill(se, se + n + 1, 0);
  for(int i = 1; i <= n; i++){
    sw[i] = sw[i - 1];
    if(s[i - 1] == 'W') ++sw[i];
    se[i] = se[i - 1];
    if(s[n - i] == 'E') ++se[i];
  }

  int ans = INF_INT;
  for(int i = 0; i < n; i++){
    ans = min(ans, sw[i] + se[n - i - 1]);
  }

  cout << ans << endl;

  return 0;
}
