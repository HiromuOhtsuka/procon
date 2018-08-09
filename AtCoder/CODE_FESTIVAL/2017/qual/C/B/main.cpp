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

int pow(int x, int y){
  int result = 1;
  for(int i = 0; i < y; i++){
    result *= x;
  }
  return result;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  int a[n];
  for(int i = 0; i < n; i++) cin >> a[i];

  int s = 1;
  for(int i = 0; i < n; i++){
    if(a[i] % 2 == 0){
      s *= 2;
    }
  }

  int ans = pow(3, n) - s;

  cout << ans << endl;

  return 0;
}
