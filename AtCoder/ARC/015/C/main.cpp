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
#define MAX_N 200
using namespace std;

typedef pair< double, int > pii;

vector< pii > graph[MAX_N];

double dfs(int v, int t, double cost, bool visited[]){
  if(visited[v]) return 0;
  visited[v] = true;
  if(v == t) return cost;
  for(pii w: graph[v]){
    double result = dfs(w.second, t, cost * w.first, visited);
    if(result > 0) return result;
  }
  return 0;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  double m[n];
  string large[MAX_N], small[MAX_N];
  for(int i = 0; i < n; i++){
    cin >> large[i] >> m[i] >> small[i];
  }

  map< string, int > s2i;
  map< int, string > i2s;

  int id = 0;
  for(int i = 0; i < n; i++){
    if(s2i.find(large[i]) == s2i.end()){
      s2i[large[i]] = id;
      i2s[id] = large[i];
      ++id;
    }
    if(s2i.find(small[i]) == s2i.end()){
      s2i[small[i]] = id;
      i2s[id] = small[i];
      ++id;
    }
  }

  for(int i = 0; i < n; i++){
    graph[s2i[large[i]]].push_back(
        make_pair(m[i], s2i[small[i]]));
    graph[s2i[small[i]]].push_back(
        make_pair(1.0 / m[i], s2i[large[i]]));
  }

  bool visited[id];
  double value = 1;
  int l = 0, s = 0;
  for(int v = 0; v < id; v++){
    for(int w = 0; w < id; w++){
      fill(visited, visited + id, false);
      double tmp = dfs(v, w, 1, visited);
      if(value < tmp){
        value = tmp;
        l = v;  s = w;
      }
    }
  }

  string ans = "1" + i2s[l] + "=" + to_string((int)(value + 0.1)) + i2s[s];

  cout << ans << endl;

  return 0;
}
