#include <iostream>
#include <algorithm>
#include <vector>
#define MAX_N 16
using namespace std;

vector< int > graph[MAX_N];

bool topological_order(int perm[], int n){
  for(int i = 0; i < n; i++){
    for(int j = 0; j < i; j++){
      int v = perm[i], w = perm[j];
      if(find(graph[v].begin(), graph[v].end(), w) != graph[v].end()){
        return false;
      }
    }
  }
  return true;
}

int main(){
  int n, m;
  cin >> n >> m;
  for(int i = 0; i < m; i++){
    int x, y;
    cin >> x >> y;
    graph[x - 1].push_back(y - 1);
  }

  if(n > 8){
    return 0;
  }

  int perm[n];
  for(int i = 0; i < n; i++){
    perm[i] = i;
  }

  int sum = 0;
  sort(perm, perm + n);
  do{
    if(topological_order(perm, n)) ++sum;
  }while(next_permutation(perm, perm + n));

  cout << sum << endl;

  return 0;
}
