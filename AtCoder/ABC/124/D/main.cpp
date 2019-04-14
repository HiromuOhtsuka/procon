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

  int n, k;
  cin >> n >> k;
  string s;
  cin >> s;

  vector< int > a;
  int i = 0;
  while(i < n){
    int j = i + 1;
    while(j < n && s[i] == s[j]){
      ++j;
    }
    a.push_back(j - i);
    i = j;
  }

  int m = a.size();

  int d = (s[0] == '1' ? 1 : 0);

  i = 0;
  int j = 0;
  int ans = 0;
  int sum = 0;
  while(i < m){
    while(j < m && j < i + 2 * k + d){
      sum += a[j];
      ++j;
    }
    ans = max(ans, sum);
    sum -= a[i];
    d = (d == 0 ? 1 : 0);
    ++i;
  }

  cout << ans << endl;

  return 0;
}
