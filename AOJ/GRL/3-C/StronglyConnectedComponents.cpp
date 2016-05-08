#include <cstdio>
#include <vector>
#define MAX_N 10000
#define MAX_M 30000
using namespace std;

class Edge {
  public:
    int to;

  Edge(int to){
    this->to = to;
  }

};

int N, M, Q;
vector< Edge > G[MAX_N];
vector< Edge > G_rev[MAX_N];
int ph[MAX_N], ph_rev[MAX_N], comp[MAX_N], n, k;
bool r[MAX_N];

void visit1(int v){
  r[v] = true;

  for(int i = 0; i < G[v].size(); i++){
    int w = G[v][i].to;
    if(!r[w]){
      visit1(w);
    }
  }

  n++;
  ph[v] = n;
  ph_rev[n] = v;
}

void visit2(int v){
  r[v] = true;

  for(int i = 0; i < G_rev[v].size(); i++){
    int w = G_rev[v][i].to;
    if(!r[w]){
      visit2(w);
    }
  }

  comp[v] = k;
}

void strongly_connected_components(){
  fill(r, r + N, false);
  n = 0;

  for(int i = 0; i < N; i++){
    if(!r[i]){
      visit1(i);
    }
  }

  fill(r, r + N, false);
  k = 0;
  for(int i = N; i >= 1; i--){
    if(!r[ph_rev[i]]){
      k++;
      visit2(ph_rev[i]);
    }
  }
}

int main(){
  scanf("%d %d", &N, &M);
  for(int i = 0; i < M; i++){
    int s, t;
    scanf("%d %d", &s, &t);
    G[s].push_back(Edge(t));
    G_rev[t].push_back(Edge(s));
  }

  strongly_connected_components();

  scanf("%d", &Q);
  for(int i = 0; i < Q; i++){
    int u, v;
    scanf("%d %d", &u, &v);
    if(comp[u] == comp[v]){
      printf("1\n");
    }
    else{
      printf("0\n");
    }
  }

  return 0;
}
