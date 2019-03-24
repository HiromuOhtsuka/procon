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

int compress(vector<int>& x, map< int, int >& inv, int conv[]) {
  sort(x.begin(), x.end());
  x.erase(unique(x.begin(), x.end()), x.end());
  for(int i = 0; i < x.size(); i++){
    inv[x[i]] = i;
    conv[i] = x[i];
  }
  return x.size();
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int h, w;
  cin >> h >> w;
  int n, m;
  cin >> n >> m;
  vector< string > a(n);
  for(int i = 0; i < n; i++){
    cin >> a[i];
  }

  int ds = w - m, dt = h - n;
  vector< int > x, y;
  vector< pii > s;
  for(int i = 0; i < n; i++){
    for(int j = 0; j < m; j++){
      if(a[i][j] == '#'){
        x.push_back(j);  x.push_back(j + ds);
        x.push_back(j + ds + 1);
        x.push_back(j + 1);
        y.push_back(i);  y.push_back(i + dt);
        y.push_back(i + dt + 1);
        y.push_back(i + 1);
        s.push_back(make_pair(i, j));
      }
    }
  }

  map< int, int > xinv;
  int xconv[2 * m + 1];
  int mm = compress(x, xinv, xconv);

  map< int, int > yinv;
  int yconv[2 * n + 1];
  int nn = compress(y, yinv, yconv);

  int b[nn][mm];
  for(int i = 0; i < nn; i++){
    fill(b[i], b[i] + mm, 0);
  }

  for(pii p: s){
    int i = yinv[p.first], j = xinv[p.second];
    int i2 = yinv[p.first + dt] + 1, j2 = xinv[p.second + ds] + 1;
    b[i][j]++; b[i2][j2]++;
    b[i][j2]--; b[i2][j]--;
  }

  for(int i = 0; i < nn; i++){
    for(int j = 1; j < mm; j++){
      b[i][j] += b[i][j - 1];
    }
  }

  for(int i = 1; i < nn; i++){
    for(int j = 0; j < mm; j++){
      b[i][j] += b[i - 1][j];
    }
  }

  ll sum = 0;
  for(int i = 0; i < nn; i++){
    for(int j = 0; j < mm; j++){
      if(b[i][j] > 0){
        sum += (ll)(abs(xconv[j] - xconv[j + 1])) * 
          (ll)(abs(yconv[i] - yconv[i + 1]));
      }
    }
  }

  cout << sum << endl;

  return 0;
}
