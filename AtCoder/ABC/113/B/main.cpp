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
  double t, a;
  cin >> t >> a;
  double h[n];
  for(int i = 0; i < n; i++) cin >> h[i];

  int i = 0;
  for(int j = 1; j < n; j++){
    if(abs(a - (t - h[i] * 0.006)) > abs(a - (t - h[j] * 0.006))) i = j;
  }

  cout << (i + 1) << endl;

  return 0;
}
