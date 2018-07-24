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
#define MAX_M 100000
using namespace std;

typedef long long ll;
typedef pair< int, int > pii;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, m;
  cin >> n >> m;
  int a[m], b[m];
  for(int i = 0; i < m; i++){
    cin >> a[i] >> b[i];
    --a[i]; --b[i];
  }

  vector< pii > edges;
  for(int i = 0; i < m; i++){
    edges.push_back(make_pair(b[i], a[i]));
  }
  sort(edges.begin(), edges.end());

  int count = 0;
  int cut = -1;
  for(pii e: edges){
    int s = e.second, t = e.first;
    if(cut <= s){
      cut = t;
      ++count;
    }
  }

  cout << count << endl;

  return 0;
}
