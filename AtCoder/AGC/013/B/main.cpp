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
#define MAX_N 100000
using namespace std;

vector< int > graph[MAX_N];

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

  for(int i = 0; i < m; i++){
    graph[a[i]].push_back(b[i]);
    graph[b[i]].push_back(a[i]);
  }

  deque< int > path;
  path.push_back(a[0]); path.push_back(b[0]);
  set< int > vertices;
  vertices.insert(a[0]); vertices.insert(b[0]);
  while(true){
    bool all = true;
    for(int v: graph[path[0]]){
      if(vertices.find(v) == vertices.end()){
        all = false;
        path.push_front(v); vertices.insert(v);
        break;
      }
    }
    if(all) break;
  }
  while(true){
    bool all = true;
    for(int v: graph[path[path.size() - 1]]){
      if(vertices.find(v) == vertices.end()){
        all = false;
        path.push_back(v); vertices.insert(v);
        break;
      }
    }
    if(all) break;
  }

  string buf;
  buf += to_string(path.size()) + "\n";
  for(int v: path){
    buf += to_string(v + 1) + " ";
  }

  cout << buf << endl;

  return 0;
}
