#include <cstdio>
#include <unordered_map>
#include <algorithm>
#include <string>
#define MAX_N 10000
using namespace std;

class Edge {
  public:
    int v, w, d;

    Edge(int v, int w, int d){
      this->v = v;  this->w = w;
      this->d = d;
    }

    bool operator==(const Edge &e) const{
      return (v == e.v && w == e.w) ||
        (v == e.w && w == e.v);
    }

    bool operator!=(const Edge &e) const{
      return !((v == e.v && w == e.w) ||
        (v == e.w && w == e.v));
    }
};

struct Hash {
  size_t operator()(const Edge &e) const{
    size_t h = 13 ^ e.v ^ e.w;
    return h;
  }
};

int n;
vector< Edge > T[MAX_N];
unordered_map< Edge, int, Hash > dp[MAX_N];

int opt(int s, Edge e){
  if(dp[s][e] > 0){
    return dp[s][e];
  }

  int mx = 0;
  for(int i = 0; i < T[e.w].size(); i++){
    if(T[e.w][i].w != s){
      mx = max(mx, opt(e.w, T[e.w][i])); 
    }
  }

  return dp[s][e] = mx + e.d;
}

int main(){
  scanf("%d", &n);
  for(int i = 0; i < n - 1; i++){
    int s, t, w;
    scanf("%d %d %d", &s, &t, &w);
    T[s].push_back(Edge(s, t, w));
    T[t].push_back(Edge(t, s, w));
  }

  string ans;
  for(int i = 0; i < n; i++){
    int mx = 0;
    for(int j = 0; j < T[i].size(); j++){
      mx = max(mx, opt(i, T[i][j]));
    }
    ans += to_string(mx) + "\n";
  }

  printf("%s", ans.c_str());

  return 0;
}
