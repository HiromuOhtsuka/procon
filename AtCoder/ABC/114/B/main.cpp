#include <iostream>
#include <climits>
#include <cmath>
#include <algorithm>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <string>
#include <deque>
#define INF_INT (INT_MAX / 2)
#define INF_LONG (LONG_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

const int MAX = 100001;
const int MOD = 1000000007;

typedef long long ll;
typedef pair< int, int > pii;
typedef pair< ll, ll > pll;
typedef pair< ll, int > pli;
typedef pair< int, ll > pil;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  string s;
  cin >> s;

  int ans = INT_MAX;
  for(int i = 0; i + 2 < s.length(); i++){
    int n = 100 * (s[i] - '0') + 10 * (s[i + 1] - '0') + (s[i + 2] - '0');
    ans = min(ans, abs(n - 753));
  }

  cout << ans << endl;

  return 0;
}
