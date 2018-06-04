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

  string s;
  cin >> s;

  int ans = 700;
  if(s[0] == 'o') ans += 100;
  if(s[1] == 'o') ans += 100;
  if(s[2] == 'o') ans += 100;

  cout << ans << endl;

  return 0;
}
