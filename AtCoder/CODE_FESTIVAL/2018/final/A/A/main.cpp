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

class edge{
  public:
    int v, w, d;
    edge(int v, int w, int d): v(v), w(w), d(d){}

    bool operator <(const edge &e) const{
      if(d == e.d) return w < e.w;
      return d < e.d;
    }
};

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, m;
  cin >> n >> m;
  int a[m], b[m], l[m];
  for(int i = 0; i < m; i++){
    cin >> a[i] >> b[i] >> l[i];
    --a[i]; --b[i];
  }

  vector< set< edge > > graph(n);
  for(int i = 0; i < m; i++){
    graph[a[i]].insert(edge(a[i], b[i], l[i]));
    graph[b[i]].insert(edge(b[i], a[i], l[i]));
  }

  ll count = 0;
  for(int i = 0; i < m; i++){
    int d = 2540 - l[i];
    count += distance(
        graph[b[i]].lower_bound(edge(b[i], a[i] + 1, d)),
        graph[b[i]].lower_bound(edge(b[i], 0, d + 1)));
    count += distance(
        graph[a[i]].lower_bound(edge(a[i], b[i] + 1, d)),
        graph[a[i]].lower_bound(edge(a[i], 0, d + 1)));
  }

  cout << count << endl;

  return 0;
}
