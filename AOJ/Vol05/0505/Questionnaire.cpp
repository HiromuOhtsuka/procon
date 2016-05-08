#include <cstdio>
#include <algorithm>
#define MAX_M 100
using namespace std;

static int N, M;
static int COUNT[MAX_M];

int main(){
  while(true){
    scanf("%d %d", &N, &M);
    if(N == 0 && M == 0){
      return 0;
    }
    for(int i = 0; i < N; i++){
      for(int j = 0; j < M; j++){
        int n;
        scanf("%d", &n);
        if(n){
          ++COUNT[j];
        }
      }
    }
    int max_i = 0;
    for(int i = 0; i < M; i++){
      for(int j = 0; j < M; j++){
        if(COUNT[max_i] < COUNT[j]){
          max_i = j;
        }
      }
      printf("%d%c", max_i + 1, (i == M - 1) ? '\n' : ' ');
      COUNT[max_i] = 0;
    }
  }

  return 0;
}
