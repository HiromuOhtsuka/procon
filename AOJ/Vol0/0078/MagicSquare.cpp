#include <cstdio>
#define MAX_N 15
using namespace std;

static int N;
static int table[MAX_N][MAX_N];
static bool accept();
static void fill(int i, int x, int y);
static void print_table();

int main(){
  while(true){
    scanf("%d", &N);

    if(N == 0){
      return 0;
    }

    fill(1, N / 2, N / 2 + 1);
  }

  return 0;
}

static void fill(int i, int x, int y){
  if(accept()){
    print_table();
    return;
  }
  if(i > N * N){
    return;
  }
  // 右にはみ出す
  if(x >= N){
    fill(i, 0, y);
    return;
  }
  // 左にはみ出す
  if(x < 0){
    fill(i, N - 1, y);
    return;
  }
  // 下にはみ出す
  if(y >= N){
    fill(i, x, 0);
    return;
  }
  if(table[y][x] == 0){
    table[y][x] = i;
    fill(i + 1, x + 1, y + 1);
    table[y][x] = 0;
  }
  else{
    fill(i, x - 1, y + 1);
  }
}

static bool accept(){
  int S = ((N * N) * (N * N + 1)) / 2 / N;
  for(int i = 0; i < N; i++){
    int sum = 0;
    for(int j = 0; j < N; j++){
      if(table[i][j] == 0){
        return false;
      }
      sum += table[i][j];
    }
    if(sum != S){
      return false;
    }
  }
  return true;
}

static void print_table(){
  for(int i = 0; i < N; i++){
    for(int j = 0; j < N; j++){
      printf("%4d", table[i][j]);
    }
    putchar('\n');
  }
}
