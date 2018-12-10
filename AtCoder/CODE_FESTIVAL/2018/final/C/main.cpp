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

int ceil(int x, int y){
  return (x % y == 0) ? x / y : x / y + 1;
}

int gcd(int x, int y){
  return y ? gcd(y, x % y) : x;
}

int lcm(int x, int y){
  return x / gcd(x, y) * y;
}

//  b_i < b_j + (a_i - a_j) (a_j <= a_i)
//  b_i < b_j (a_j > a_i)
//  b_i - a_i < b_j - a_j (a_j <= a_i)
int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  int a[n], b[n];
  for(int i = 0; i < n; i++){
    cin >> a[i] >> b[i];
  }
  int m;
  cin >> m;
  int t[m];
  for(int i = 0; i < m; i++){
    cin >> t[i];
  }

  vector< pii > c(n);
  for(int i = 0; i < n; i++){
    c[i] = make_pair(a[i], b[i]);
  }
  sort(c.begin(), c.end());

  string buf;
  for(int i = 0; i < m; i++){
    auto it = lower_bound(c.begin(), c.end(), make_pair(t[i], 1));
    int aa1, bb1;
    if(it == c.begin()){
      aa1 = it->first; bb1 = it->second;
    }
    else{
      aa1 = (it - 1)->first; bb1 = (it - 1)->second;
    }

    int aa2, bb2;
    if(it == c.end()){
      aa2 = aa1; bb2 = bb1;
    }
    else{
      aa2 = it->first; bb2 = it->second;
    }

    ll tmp1, tmp2;
    if(aa1 <= t[i]) tmp1 = bb1 + (t[i] - aa1);
    else tmp1 = bb1;

    if(aa2 <= t[i]) tmp2 = bb2 + (t[i] - aa2);
    else tmp2 = bb2;

    int ans = min(tmp1, tmp2);

    buf += to_string(ans) + "\n";
  }

  cout << buf;

  return 0;
}
