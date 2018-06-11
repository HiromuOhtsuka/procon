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
using namespace std;

int n, m;
vector< int > graph[MAX_N];

void draw(int v, int c, int color[]){
  if(color[v] != -1) return;
  color[v] = c;
  for(int w: graph[v])
    draw(w, c, color);
}

vector< set< int > > components(){
  int color[n];
  fill(color, color + n, -1);
  int count = 0;
  for(int s = 0; s < n; s++){
    if(color[s] == -1){
      draw(s, count++, color);
    }
  }
  vector< set< int > > result;
  for(int i = 0; i < count; i++){
    set< int > s;
    result.push_back(s);
  }
  for(int v = 0; v < n; v++){
    result[color[v]].insert(v);
  }
  return result;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> n >> m;
  int p[n];
  for(int i = 0; i < n; i++) cin >> p[i];
  int x[m], y[m];
  for(int i = 0; i < m; i++) cin >> x[i] >> y[i];

  for(int i = 0; i < m; i++){
    graph[x[i] - 1].push_back(y[i] - 1);
    graph[y[i] - 1].push_back(x[i] - 1);
  }

  int count = 0;
  for(set< int > vertices: components()){
    for(int v: vertices){
      if(vertices.find(p[v] - 1) != vertices.end())
        ++count;
    }
  }

  cout << count << endl;

  return 0;
}
