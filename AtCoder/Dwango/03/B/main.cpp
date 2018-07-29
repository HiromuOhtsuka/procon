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

typedef long long ll;
typedef pair< int, int > pii;

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

  string s;
  cin >> s;

  int n = s.length();

  int ans = 0;
  int count = 0;
  for(int i = 0; i + 1 < n; i += 2){
    if((s[i] == '?' || s[i] == '2') &&
        (s[i + 1] == '?' || s[i + 1] == '5')){
      count += 2;
    }
    else{
      count = 0;
    }
    ans = max(ans, count);
  }

  count = 0;
  for(int i = 1; i + 1 < n; i += 2){
    if((s[i] == '?' || s[i] == '2') &&
        (s[i + 1] == '?' || s[i + 1] == '5')){
      count += 2;
    }
    else{
      count = 0;
    }
    ans = max(ans, count);
  }

  cout << ans << endl;

  return 0;
}
