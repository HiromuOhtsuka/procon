#include <cstdio>
#include <algorithm>
#define MAX_N 100000
using namespace std;

static int N, M;

class UnionFind {
  private:
    int parent[MAX_N], rank[MAX_N];

    int root(int u){
      if(parent[u] == u){
        return u;
      }
      return parent[u] = root(parent[u]);
    }

  public :
    UnionFind(int size){
      for(int i = 0; i < size; i++){
        parent[i] = i;
        rank[i] = 0;
      }
    }

    void unite(int u, int v){
      int up = root(u), vp = root(v);
      if(up == vp){
        return;
      }
      if(rank[up] < rank[vp]){
        parent[up] = vp;
      }
      else{
        parent[vp] = up;
        if(rank[up] == rank[vp]){
          ++rank[up];
        }
      }
    }

    bool same(int u, int v){
      return root(u) == root(v);
    }
};

class Edge {
  public :
    int from, to, cost;

    Edge(){}

    Edge(int from, int to, int cost){
      this->from = from;
      this->to = to;
      this->cost = cost;
    }

    bool operator<(const Edge& e) const{
      return cost < e.cost;
    }
};

static Edge edges[MAX_N];

int main(){
  while(true){
    scanf("%d", &N);
    if(N == 0){
      return 0;
    }
    scanf("%d", &M);
    for(int i = 0; i < M; i++){
      int a, b, cost;
      scanf("%d,%d,%d", &a, &b, &cost);
      edges[i] = Edge(a, b, cost / 100 - 1);
    }
    sort(edges, edges + M);
    int cost = 0;
    UnionFind uf (N + 1);
    for(int i = 0; i < M; i++){
      Edge e = edges[i];
      if(!uf.same(e.to, e.from)){
        cost += e.cost;
        uf.unite(e.to, e.from);
      }
    }
    printf("%d\n", cost);
  }

  return 0;
}

