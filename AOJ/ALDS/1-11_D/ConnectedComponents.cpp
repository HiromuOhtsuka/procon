#include <cstdio>
#include <vector>
#include <stack>
#define MAX_N 100000
#define MAX_M 100000
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
int color[MAX_N];

void dfs(int s, int c){
  stack< int > st;

  st.push(s);
  while(!st.empty()){
    int v = st.top(); st.pop();
    if(color[v]){
      continue;
    }
    color[v] = c;
    for(int i = 0; i < G[v].size(); i++){
      st.push(G[v][i].to);
    }
  }
}

int main(){
  scanf("%d %d", &N, &M);
  for(int i = 0; i < M; i++){
    int s, t;
    scanf("%d %d", &s, &t);
    G[s].push_back(Edge(t));
    G[t].push_back(Edge(s));
  }
  int c = 1;
  for(int i = 0; i < N; i++){
    if(color[i] == 0){
      dfs(i, c++);
    }
  }
  scanf("%d", &Q);
  for(int i = 0; i < Q; i++){
    int s, t;
    scanf("%d %d", &s, &t);
    if(color[s] == color[t]){
      printf("yes\n");
    }
    else{
      printf("no\n");
    }
  }

  return 0;
}
