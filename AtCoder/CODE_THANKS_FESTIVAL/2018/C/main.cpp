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

  int n;
  cin >> n;
  int x[n];
  for(int i = 0; i < n; i++){
    cin >> x[i];
  }

  sort(x, x + n);

  ll sum = 0;
  for(int i = 0; i + 1 < n; i++){
    sum += ((ll)x[i + 1] - (ll)x[i]) * ((ll)(i + 1) * (ll)(n - (i + 1)));
  }

  cout << sum << endl;

  return 0;
}
