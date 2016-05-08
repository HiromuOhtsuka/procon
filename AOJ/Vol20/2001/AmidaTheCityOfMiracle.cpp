#include <cstdio>
#define MAX_N 100
#define MAX_M 1000
#define MAX_H 1000
using namespace std;

static int N, M, A;
static bool amida[MAX_H][MAX_N][MAX_N];

int main(){
  while(true){
    scanf("%d %d %d", &N, &M, &A);
    if(N == 0 && M == 0 && A == 0){
      return 0;
    }
    for(int i = 0; i < M; i++){
      int h, p, q;
      scanf("%d %d %d", &h, &p, &q);
      amida[h - 1][p - 1][q - 1]
        = amida[h - 1][q - 1][p - 1] = true;
    }

    int at = A;
    for(int h = MAX_H - 1; h >= 0; h--){
      if((at - 1) - 1 >= 0 && 
          amida[h][at - 1][(at - 1) - 1]){
        --at;
      }
      else if((at - 1) + 1 < N && 
          amida[h][at - 1][(at - 1) + 1]){
        ++at;
      }
    }

    printf("%d\n", at);

    for(int i = 0; i < MAX_H; i++){
      for(int j = 0; j < MAX_N; j++){
        for(int k = 0; k < MAX_N; k++){
          amida[i][j][k] = false;
        }
      }
    }
  }

  return 0;
}
