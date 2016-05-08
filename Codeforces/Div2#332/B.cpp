#include <iostream>
#include <algorithm>
#include <set>
#define MAX_N 100000
#define MAX_M 100000
using namespace std;

int N, M, f[MAX_N], b[MAX_M], a[MAX_N];
int f_map[MAX_N];

int main(){
  cin >> N >> M;
  for(int i = 0; i < N; i++){
    cin >> f[i];
    f_map[f[i]] = i;
  }
  for(int i = 0; i < M; i++){
    cin >> b[i];
  }

  sort(f, f + N);
  for(int i = 0; i < M; i++){
    int *p = lower_bound(f, f + N, b[i]);
    if(*p == b[i] && *(p + 1) != b[i]){
      a[i] = f_map[*p] + 1;
    }
    else if(*p == b[i]){
      cout << "Ambiguity" << endl;
      return 0;
    }
    else{
      cout << "Impossible" << endl;
      return 0;
    }
  }

  cout << "Possible" << endl;
  for(int i = 0; i < M; i++){
    cout << a[i] << ((i == M - 1) ? '\n' : ' ');
  }

  return 0;
}
