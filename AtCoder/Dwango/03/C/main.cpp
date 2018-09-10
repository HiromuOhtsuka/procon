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

  int n;
  cin >> n;
  int a[n];
  for(int i = 0; i < n; i++) cin >> a[i];

  int count[5];
  fill(count, count + 5, 0);
  for(int i = 0; i < n; i++){
    count[a[i]]++;
  }

  int ans = 0;
  for(int i = 0; i < n; i++){
    if(count[a[i]] == 0) continue;
    count[a[i]]--;
    int r = 4 - a[i];
    int j = r;
    while(j >= 0 && r > 0){
      if(r - j >= 0 && count[j] > 0){
        count[j]--;
        r -= j;
      }
      else --j;
    }
    ++ans;
  }

  cout << ans << endl;

  return 0;
}
