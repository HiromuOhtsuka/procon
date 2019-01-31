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
#define MAX_N 100000
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
  ll a[n], b[n];
  for(int i = 0; i < n; i++) cin >> a[i] >> b[i];

  vector< pair< ll, pll > > v(n);
  for(int i = 0; i < n; i++){
    v[i] = make_pair(a[i] + b[i], make_pair(a[i], b[i]));
  }
  sort(v.begin(), v.end(), greater< pair< ll, pll > >());

  ll t_sum = 0, a_sum = 0;
  for(int i = 0; i < n; i++){
    if(i % 2 == 0) t_sum += v[i].second.first;
    else a_sum += v[i].second.second;
  }

  cout << (t_sum - a_sum) << endl;

  return 0;
}
