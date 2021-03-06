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

  int a[5];
  for(int i = 0; i < 5; i++){
    cin >> a[i];
  }

  int p[5] = {0, 1, 2, 3, 4};

  int ans = INF_INT;
  do{
    int tmp = 0;
    for(int i = 0; i < 5; i++){
      if(tmp % 10 != 0){
        tmp += (10 - tmp % 10);
      }
      tmp += a[p[i]];
    }
    ans = min(ans, tmp);
  } while(next_permutation(p, p + 5));

  cout << ans << endl;

  return 0;
}
