#include <cstdio>
#include <vector>
#include <algorithm>
#define MAX_N 100000
#define MAX_Q 100000
using namespace std;

int n;
vector< int > G[MAX_N];
int q;
int ans[MAX_Q];

int parent[MAX_N];
int depth[MAX_N];
void dfs(int v, int p, int d){
  depth[v] = d;
  for(int i = 0; i < G[v].size(); i++){
    int w = G[v][i];
    if(w != p){
      parent[w] = v;
      dfs(w, v, d + 1);
    }
  }
}

int main(){
  scanf("%d", &n);
  for(int i = 0; i < n - 1; i++){
    int x, y;
    scanf("%d %d", &x, &y);
    G[x - 1].push_back(y - 1);
    G[y - 1].push_back(x - 1);
  }


  parent[0] = -1;
  dfs(0, -1, 0);

  scanf("%d", &q);
  for(int i = 0; i < q; i++){
    int a, b;
    scanf("%d %d", &a, &b);
    int v = a - 1, w = b - 1;
    if(depth[v] < depth[w]){
      while(depth[w] != depth[v]){
        w = parent[w];
      }
    }
    else{
      while(depth[w] != depth[v]){
        v = parent[v];
      }
    }
    while(v != w){
      v = parent[v];  w = parent[w];
    }

    int ans = depth[a - 1] + depth[b - 1] - 2 * depth[v] + 1;

    printf("%d\n", ans);
  }

  return 0;
}


