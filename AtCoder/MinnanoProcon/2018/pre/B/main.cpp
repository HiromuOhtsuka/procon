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

int digit(int x){
  int c = 0;
  while(x != 0){
    x /= 10;
    ++c;
  }
  return c;
}

int pow(int a, int b){
  int result = 1;
  for(int i = 0; i < b; i++){
    result *= a;
  }
  return result;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int x, k;
  cin >> x >> k;

  int ans = pow(10, k);
  if(ans > x){
    cout << ans << endl;
    return 0;
  }
  ans += (x / ans) * pow(10, k);
  cout << ans << endl;

  return 0;
}
