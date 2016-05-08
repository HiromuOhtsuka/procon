#include <cstdio>
#include <map>
#include <vector>
#define MAX_N 1000
#define MAX_M 100000
#define MAX_H 1000
#define MAX_K MAX_N
using namespace std;

int N, M, H, K;
int amida[MAX_H + 1][MAX_N], score[MAX_N];
vector< int > bar[MAX_H + 1];

int main(){
  for(;;){
    scanf("%d %d %d %d", &N, &M, &H, &K);

    if(N == 0 && M == 0 && H == 0 && K == 0){
      return 0;
    }

    for(int i = 0; i < N; i++){
      int s;
      scanf("%d", &s);
      score[i] = s;
    }
    for(int i = 0; i < M; i++){
      int a, b;
      scanf("%d %d", &a, &b);
      bar[b].push_back(a - 1);
    }

    for(int i = 0; i < N; i++){
      amida[0][i] = i;
    }
    for(int i = 1; i <= H; i++){
      for(int j = 0; j < N; j++){
        amida[i][j] = amida[i - 1][j];
      }
      for(int j = 0; j < bar[i].size(); j++){
        int a = bar[i][j];
        int tmp = amida[i][a];
        amida[i][a] = amida[i][a + 1];
        amida[i][a + 1] = tmp;
      }
    }

    int sum = 0;
    for(int i = 0; i < N; i++){
      if(amida[H][i] < K){
        sum += score[i];
      }
    }
    int best = sum;
    for(int i = 1; i <= H; i++){
      for(int j = 0; j < bar[i].size(); j++){
        int a = bar[i][j];
        int c1 = amida[i - 1][a], c2 = amida[i - 1][a + 1];
        sum = 0;
        for(int k = 0; k < N; k++){
          if(amida[H][k] == c1){
            if(c2 < K){
              sum += score[k];
            }
          }
          else if(amida[H][k] == c2){
            if(c1 < K){
              sum += score[k];
            }
          }
          else if(amida[H][k] < K){
            sum += score[k];
          }
        }
        if(best > sum){
          best = sum;
        }
      }
    }

    printf("%d\n", best);

    for(int i = 0; i <= H; i++){
      bar[i].clear();
    }
  }

  return 0;
}
