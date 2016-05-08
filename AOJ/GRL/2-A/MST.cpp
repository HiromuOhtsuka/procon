#include <cstdio>
#include <vector>
#include <algorithm>
#define MAX_N 10000
#define MAX_M 100000
using namespace std;

class Edge {
  public :
    int from, to, cost;

    Edge(int from, int to, int cost){
      this->from = from;
      this->to = to;
      this->cost = cost;
    }

    bool operator<(const Edge& e) const{
      return this->cost < e.cost;
    }
};

class UnionFindTree {
  public :
    int parent[MAX_N], h[MAX_N];

  UnionFindTree(){
    fill(h, h + MAX_N, 0);
    for(int i = 0; i < MAX_N; i++){
      parent[i] = i;
    }
  }

  int root(int v){
    if(parent[v] != v){
      return parent[v] = root(parent[v]);
    }
    return v;
  }

  bool same(int s, int t){
    return root(s) == root(t);
  }

  void unite(int s, int t){
    int rs = root(s), rt = root(t);
    if(rs == rt){
      return;
    }
    if(h[rs] < h[rt]){
      parent[rs] = rt;
    }
    else if(h[rs] > h[rt]){
      parent[rt] = rs;
    }
    else{
      parent[rt] = rs;
      h[rs]++;
    }
  }

};

int N, M;
vector< Edge > G;

int kruskal(){
  sort(G.begin(), G.end());
  UnionFindTree uft;
  int cost = 0;
  for(int i = 0; i < M; i++){
    Edge e = G[i];
    if(!uft.same(e.from, e.to)){
      cost += e.cost;
      uft.unite(e.from, e.to);
    }
  }

  return cost;
}

int main(){
  scanf("%d %d", &N, &M);
  for(int i = 0; i < M; i++){
    int s, t, w;
    scanf("%d %d %d", &s, &t, &w);
    G.push_back(Edge(s, t, w));
  }

  int mst = kruskal();

  printf("%d\n", mst);

  return 0;
}
