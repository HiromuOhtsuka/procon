#include <cstdio>
#define MAX_N 10
using namespace std;

static int N;
static int table[MAX_N + 1][MAX_N + 1];

int main(){
  while(true){
    scanf("%d", &N);

    if(N == 0){
      return 0;
    }

    for(int i = 0; i < N; i++){
      for(int j = 0; j < N; j++){
        scanf("%d", &table[i][j]);
      }
    }

    for(int i = 0; i < N; i++){
      for(int j = 0; j < N; j++){
        table[i][N] += table[i][j];
        table[N][j] += table[i][j];
        table[N][N] += table[i][j];
      }
    }


    for(int i = 0; i <= N; i++){
      for(int j = 0; j <= N; j++){
        printf("%5d", table[i][j]);
      }
      putchar('\n');
    }

    for(int i = 0; i <= N; i++){
      for(int j = 0; j <= N; j++){
        table[i][j] = 0;
      }
    }
  }

  return 0;
}
