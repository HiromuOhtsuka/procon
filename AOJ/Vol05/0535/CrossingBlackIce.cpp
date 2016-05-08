#include <cstdio>
#define MAX_M 90
#define MAX_N 90
using namespace std;

static int M, N;
static const int NO = 0, I = 1, B = 2;
static int table[MAX_N][MAX_M];
static int best;
static bool search(int sx, int sy, int path){
  if(!(0 <= sx && sx < M && 0 <= sy && sy < N)){
    return false;
  }
  if(table[sy][sx] != I){
    return false;
  }

  bool sound = true;
  table[sy][sx] = B;
  if(search(sx + 1, sy, path + 1)){
    sound = false;
  }
  if(search(sx - 1, sy, path + 1)){
    sound = false;
  }
  if(search(sx, sy + 1, path + 1)){
    sound = false;
  }
  if(search(sx, sy - 1, path + 1)){
    sound = false;
  }
  table[sy][sx] = I;
  if(sound && path > best){
    best = path;
  }

  return true;
}

int main(){
  while(true){
    scanf("%d %d", &M, &N);

    if(M == 0 && N == 0){
      return 0;
    }

    for(int i = 0; i < N; i++){
      for(int j = 0; j < M; j++){
        scanf("%d", &table[i][j]);
      }
    }

    best = 0;
    for(int i = 0; i < N; i++){
      for(int j = 0; j < M; j++){
        search(j, i, 1);
      }
    }

    printf("%d\n", best);
  }

  return 0;
}
