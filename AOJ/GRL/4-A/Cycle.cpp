#include <iostream>
#include <vector>
#include <queue>
#define MAX_N 100
#define MAX_M 1000
using namespace std;

class Edge {
  public :
    int to;

  Edge(int to){
    this->to = to;
  }
};

int N, M;
vector< Edge > G[MAX_N];

int indegree[MAX_N];
bool visited[MAX_N];
void bfs(int s){
  queue< int > que;

  que.push(s);
  while(!que.empty()){
    int from = que.front(); que.pop();
    visited[from] = true;
    for(int i = 0; i < G[from].size(); i++){
      int to = G[from][i].to;
      indegree[to]--;
      if(indegree[to] == 0){
        que.push(to);
      }
    }
  }

}

bool cycled(){
  fill(visited, visited + N, false);
  fill(indegree, indegree + N, 0);
  for(int i = 0; i < N; i++){
    for(int j = 0; j < G[i].size(); j++){
      indegree[G[i][j].to]++;
    }
  }

  for(int s = 0; s < N; s++){
    if(!visited[s] && indegree[s] == 0){
      bfs(s);
    }
  }

  for(int i = 0; i < N; i++){
    if(indegree[i] != 0){
      return true;
    }
  }

  return false;
}

int main(){
  cin >> N >> M;
  for(int i = 0; i < M; i++){
    int s, t;
    cin >> s >> t;
    G[s].push_back(Edge(t));
  }

  if(cycled()){
    cout << "1" << endl;
  }
  else{
    cout << "0" << endl;
  }

  return 0;
}
