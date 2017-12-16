#include <iostream>
#include <cstdio>
#include <climits>
#include <cmath>
#include <algorithm>
#include <vector>
#include <map>
#include <set>
#include <queue>
#define INF_INT (INT_MAX / 2)
#define INF_LONG (LONG_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

int n;
vector< int > graph[100000];

// vector
template< typename T > ostream& operator<<(ostream& s, const vector< T >& v){
  int len = v.size();
  for(int i = 0; i < len; i++){
    s << i;
    s << ": ";
    s << v[i];
    if(i < len - 1) s << "\t";
  }
  return s;
}

void eular_path(int v, vector< int >& path){
  while(not graph[v].empty()){
    int w = graph[v].back();  graph[v].pop_back();
    eular_path(w, path);
  }
  path.push_back(v);
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int m;
  cin >> m;
  map< string, int > str_to_v;
  map< int, string > v_to_str;
  n = 0;
  vector< pair< int, int > > edges;
  for(int i = 0; i < m; i++){
    string s;
    cin >> s;
    string a = s.substr(0, 2);
    string b = s.substr(1, 2);
    if(!str_to_v.count(a)){
      str_to_v[a] = n;
      v_to_str[n] = a;
      ++n;
    }
    if(!str_to_v.count(b)){
      str_to_v[b] = n;
      v_to_str[n] = b;
      ++n;
    }
    edges.push_back(pair< int, int >(str_to_v[a], str_to_v[b]));
  }

  if(DEBUG){
    for(int v = 0; v < n; v++){
      cout << graph[v] << endl;
    }
  }

  int in_deg[n];
  fill(in_deg, in_deg + n, 0);
  for(pair< int, int > e: edges){
    graph[e.first].push_back(e.second);
    ++in_deg[e.second];
  }

  bool exist = true;
  int s = -1, t = -1;
  for(int v = 0; v < n; v++){
    if(graph[v].size() == in_deg[v]) continue;
    if(graph[v].size() == in_deg[v] + 1 && s == -1) s = v;
    else if(graph[v].size() + 1 == in_deg[v] && t == -1) t = v;
    else{
      exist = false; break;
    }
  }
  if(not exist){
    if(DEBUG){
      cout << "not exist" << endl;
    }
    cout << "NO" << endl; return 0;
  }
  if(s == -1) s = 0;

  vector< int > path;
  eular_path(s, path);

  for(int v = 0; v < n; v++){
    if(graph[v].size() != 0){
      cout << "NO" << endl; return 0;
    }
  }

  cout << "YES" << endl;
  for(int i = path.size() - 1; i >= 0; i--){
    printf("%c", v_to_str[path[i]][0]);
    if(i == 0) printf("%c\n", v_to_str[path[i]][1]);
  }

  return 0;
}
