#include <cstdio>
#define MAX_N 15
#define MAX_M 15
using namespace std;

const int BLACK = 1, WHITE = 0;
static int M, N;
static int map[MAX_M][MAX_N], w_map[MAX_M][MAX_N], t[MAX_M][MAX_N], best[MAX_M][MAX_N];

static void init(){
  for(int i = 0; i < M; i++){
    for(int j = 0; j < N; j++){
      w_map[i][j] = map[i][j];
    }
  }
  for(int i = 0; i < M; i++){
    for(int j = 0; j < N; j++){
      t[i][j] = 0;
    }
  }
}

static void step(int x, int y){
  static const int dx[] = {-1, 0, 0, 0, 1}, 
               dy[] = {0, 0, -1, 1, 0};
  for(int i = 0; i < 5; i++){
    if(0 <= (x + dx[i]) && (x + dx[i]) < N &&
        0 <= (y + dy[i]) && (y + dy[i]) < M){
      w_map[y + dy[i]][x + dx[i]] = (w_map[y + dy[i]][x + dx[i]] == BLACK) ? WHITE : BLACK;
    }
  }
}

int main(){
  scanf("%d %d", &M, &N);
  for(int i = 0; i < M; i++){
    for(int j = 0; j < N; j++){
      scanf("%d", &map[i][j]);
    }
  }
  int min_c = M * N + 1, count;
  for(int i = 0; i < (1 << N); i++){
    count = 0;
    init();
    for(int j = 0; j < N; j++){
      if((i >> j) & 1){
        step(N - j - 1, 0);
        t[0][N - j - 1] = 1;
        ++count;
      }
    }
    for(int i = 1; i < M; i++){
      for(int j = 0; j < N; j++){
        if(w_map[i - 1][j] == BLACK){
          ++count;
          t[i][j] = 1;
          step(j, i);
        }
      }
    }
    bool possible = true;
    for(int i = 0; i < M; i++){
      for(int j = 0; j < N; j++){
        if(w_map[i][j] == BLACK){
          possible = false;
          break;
        }
      }
    }
    if(possible && min_c > count){
      min_c = count;
      for(int i = 0; i < M; i++){
        for(int j = 0; j < N; j++){
          best[i][j] = t[i][j];
        }
      }
    }
  }
  if(min_c != M * N + 1){
    for(int i = 0; i < M; i++){
      for(int j = 0; j < N - 1; j++){
        printf("%d ", best[i][j]);
      }
      printf("%d\n", best[i][N - 1]);
    }
  }
  else{
    printf("IMPOSSIBLE\n");
  }

  return 0;
}

