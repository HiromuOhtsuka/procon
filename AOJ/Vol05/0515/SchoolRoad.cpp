#include <cstdio>
#define MAX_A 16
#define MAX_B 16
using namespace std;

static int A, B;
static bool table[MAX_A][MAX_B];
static int count;
static void dfs(int sx, int sy){
  if(!(0 <= sx && sx < A && 0 <= sy && sy < B)){
    return;
  }
  if(table[sy][sx]){
    return;
  }
  if(sx == A - 1 && sy == B - 1){
    ++count;
    return;
  }
  table[sy][sx] = true;
  dfs(sx + 1, sy);
  dfs(sx, sy + 1);
  table[sy][sx] = false;
}
static void init(){
  count = 0;
  for(int i = 0; i < A; i++){
    for(int j = 0; j < B; j++){
      table[i][j] = false;
    }
  }
}

int main(){
  while(true){
    scanf("%d %d", &A, &B);
    if(A == 0 && B == 0){
      return 0;
    }
    init();
    int n;
    scanf("%d", &n);
    for(int i = 0; i < n; i++){
      int x, y;
      scanf("%d %d", &x, &y);
      table[y - 1][x - 1] = true;
    }
    dfs(0, 0);
    printf("%d\n", count);
  }
  return 0;
}
