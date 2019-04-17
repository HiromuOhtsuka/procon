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

  int a, b, c;
  cin >> a >> b >> c;

  int d = min(a / 3, min(b / 2, c / 2));
  int sum = 7 * d;
  a -= 3 * d; b -= 2 * d; c -= 2 * d;

  char f[7] = {'f', 'r', 'c', 'f', 'c', 'r', 'f'};
  int mc = 0;
  for(int i = 0; i < 7; i++){
    int aa = a, bb = b, cc = c;
    int count = 0;
    for(int j = 0; j < 7; j++){
      switch(f[(i + j) % 7]){
        case 'f': --aa; break;
        case 'r': --bb; break;
        case 'c': --cc; break;
      }
      if(aa < 0 || bb < 0 || cc < 0) break;
      ++count;
    }
    mc = max(mc, count);
  }

  sum += mc;

  cout << sum << endl;

  return 0;
}
