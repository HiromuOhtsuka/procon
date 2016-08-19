#include <cstdio>
#include <algorithm>
#include <vector>
#define MAX_N 100000
#define MAX_Q 100000
using namespace std;

class Q {
  public:
    int v, w, y;
    bool isEdge;
    Q(int v, int w, int y, bool isEdge){
      this->v = v;  this->w = w;
      this->y = y;
      this->isEdge = isEdge;
    }

    bool operator <(const Q& q) const {
      if(y == q.y){
        if(isEdge && !q.isEdge){
          return false;
        }
        else if(!isEdge && q.isEdge){
          return true;
        }
        else{
          return false;
        }
      }
      return q.y < y;
    }
};

class UF {
  public:
    int n;
    vector< int > root, rank, child;

    UF(int n){
      this->n = n;
      root = vector< int >(n);
      rank = vector< int >(n);
      child = vector< int >(n);
      for(int i = 0; i < n; i++){
        root[i] = i;
        child[i] = 1;
      }
    }

    void unite(int v, int w){
      int vr = find(v), wr = find(w);
      if(vr == wr){
        return;
      }
      int sum = child[vr] + child[wr];
      child[vr] = child[wr] = sum;
      if(rank[vr] < rank[wr]){
        root[vr] = wr;
      }
      else{
        root[wr] = vr;
        if(rank[vr] == rank[wr]){
          ++rank[vr];
        }
      }
    }

    int size(int v){
      return child[find(v)];
    }

    int find(int v){
      if(root[v] == v){
        return v;
      }
      return root[v] = find(root[v]);
    }
};


int n, m, q;
vector< Q > queries;

int main(){
  scanf("%d %d", &n, &m);
  for(int i = 0; i < m; i++){
    int a, b, y;
    scanf("%d %d %d", &a, &b, &y);
    queries.push_back(Q(a - 1, b - 1, y, true));
  }
  scanf("%d", &q);
  for(int i = 0; i < q; i++){
    int v, w;
    scanf("%d %d", &v, &w);
    queries.push_back(Q(v - 1, i, w, false));
  }

  sort(queries.begin(), queries.begin() + (q + m));
  UF uf(n);
  int ans[q];
  for(int i = 0; i < q + m; i++){
    Q query = queries[i];
    if(query.isEdge){
      int v = query.v, w = query.w;
      uf.unite(v, w);
    }
    else{
      ans[query.w] = uf.size(query.v);
    }
  }

  for(int i = 0; i < q; i++){
    printf("%d\n", ans[i]);
  }

  return 0;
}
