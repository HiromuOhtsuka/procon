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

  int n, m;
  cin >> n >> m;
  int k[m];
  vector< vector< int > > s(m);
  for(int i = 0; i < m; i++){
    cin >> k[i];
    for(int j = 0; j < k[i]; j++){
      int tmp;
      cin >> tmp;
      s[i].push_back(tmp);
    }
  }
  int p[m];
  for(int i = 0; i < m; i++) cin >> p[i];

  int count = 0;
  for(int t = 0; t < (1 << n); t++){
    bool all_on = true;
    for(int i = 0; i < m; i++){
      int c = 0;
      for(int j = 0; j < k[i]; j++){
        if((t & (1 << (s[i][j] - 1))) != 0) ++c;
      }
      if((c % 2) != p[i]){
        all_on = false;
        break;
      }
    }
    if(all_on) ++count;
  }

  cout << count << endl;

  return 0;
}
