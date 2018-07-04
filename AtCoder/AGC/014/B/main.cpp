#include <iostream>
#include <climits>
#include <cmath>
#include <algorithm>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <string>
#define INF_INT (INT_MAX / 2)
#define INF_LONG (LONG_MAX / 2)
//#define DEBUG true
#define DEBUG false
#define MAX_N 100000
#define MAX_M 100000
using namespace std;

typedef pair< int, int > pii;

int n, m;
int a[MAX_M], b[MAX_M];
vector< int > graph[MAX_N];

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> n >> m;
  for(int i = 0; i < m; i++){
    cin >> a[i] >> b[i];
    --a[i]; --b[i];
  }

  for(int i = 0; i < m; i++){
    graph[a[i]].push_back(b[i]);
    graph[b[i]].push_back(a[i]);
  }

  bool ans = true;
  for(int v = 0; v < n; v++){
    if(graph[v].size() % 2 == 1){
      ans = false;
      break;
    }
  }

  if(ans) cout << "YES" << endl;
  else cout << "NO" << endl;

  return 0;
}
