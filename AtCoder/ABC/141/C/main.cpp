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

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, k, q;
  cin >> n >> k >> q;
  int a[q];
  for(int i = 0; i < q; i++) cin >> a[i];

  int b[n];
  fill(b, b + n, k);
  for(int i = 0; i < q; i++){
    b[a[i] - 1]++;
  }

  bool ans[n];
  for(int i = 0; i < n; i++){
    ans[i] = (b[i] - q > 0);
  }

  string buf;
  for(int i = 0; i < n; i++){
    if(ans[i]) buf += "Yes";
    else buf += "No";
    buf += "\n";
  }

  cout << buf;

  return 0;
}
