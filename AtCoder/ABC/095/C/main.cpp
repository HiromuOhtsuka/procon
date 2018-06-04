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

  int a, b, ab, x, y;
  cin >> a >> b >> ab >> x >> y;

  int ans = min(x, y) * min(a + b, 2 * ab);
  if(x < y) ans += (y - x) * min(b, 2 * ab);
  else ans += (x - y) * min(a, 2 * ab);

  cout << ans << endl;

  return 0;
}
