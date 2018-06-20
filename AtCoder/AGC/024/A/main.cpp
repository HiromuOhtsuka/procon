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

typedef long long ll;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int a, b, c;
  ll k;
  cin >> a >> b >> c;
  cin >> k;

  int ans;
  if(k % 2 == 0) ans = a - b;
  else ans = b - a;

  cout << ans << endl;

  return 0;
}
