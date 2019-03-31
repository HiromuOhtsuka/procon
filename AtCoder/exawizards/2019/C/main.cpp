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
#define MAX_Q 200000
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

int n, q;
string s;
string t[MAX_Q], d[MAX_Q];

bool left(int i){
  if(i == 0) return true;
  if(i == n + 1) return false;
  for(int j = 0; j < q; j++){
    if(t[j][0] == s[i - 1]){
      if(d[j] == "R") ++i;
      else --i;
    }
    if(i == n + 1) return false;
    if(i == 0) return true;
  }
  return false;
}

bool right(int i){
  if(i == n + 1) return true;
  if(i == 0) return false;
  for(int j = 0; j < q; j++){
    if(t[j][0] == s[i - 1]){
      if(d[j] == "R") ++i;
      else --i;
    }
    if(i == 0) return false;
    if(i == n + 1) return true;
  }
  return false;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> n >> q;
  cin >> s;
  for(int i = 0; i < q; i++){
    cin >> t[i] >> d[i];
  }

  int low = 0, high = n + 1;
  while(high - low > 1){
    int mid = (low + high) / 2;
    if(left(mid)) low = mid;
    else high = mid;
  }
  int left = high;

  low = 0, high = n + 1;
  while(high - low > 1){
    int mid = (low + high) / 2;
    if(right(mid)) high = mid;
    else low = mid;
  }
  int right = high;

  int ans = (right - left);

  cout << ans << endl;

  return 0;
}
