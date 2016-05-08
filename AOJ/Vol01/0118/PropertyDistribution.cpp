#include <cstdio>
#include <algorithm>
#define MAX_H 100
#define MAX_W 100
using namespace std;

int H, W;
bool visited[MAX_H][MAX_W];
char table[MAX_H][MAX_W];
void dfs(char ch, int x, int y){
  if(!(0 <= x && x < W && 0 <= y && y < H)){
    return;
  }
  if(table[y][x] != ch){
    return;
  }
  if(visited[y][x]){
    return;
  }
  visited[y][x] = true;
  dfs(ch, x + 1, y);
  dfs(ch, x - 1, y);
  dfs(ch, x, y + 1);
  dfs(ch, x, y - 1);
}

int main(){
  for(;;){
    scanf("%d %d", &H, &W);

    if(H == 0 && W == 0){
      return 0;
    }

    getchar();
    for(int i = 0; i < H; i++){
      for(int j = 0; j <= W; j++){
        int ch = getchar();
        if(ch == '\n'){
          continue;
        }
        table[i][j] = ch;
      }
    }

    int count = 0;
    for(int i = 0; i < H; i++){
      for(int j = 0; j < W; j++){
        if(!visited[i][j]){
          dfs('@', j, i);
          dfs('#', j, i);
          dfs('*', j, i);
          ++count;
        }
      }
    }

    printf("%d\n", count);

    for(int i = 0; i < H; i++){
      fill(visited[i], visited[i] + W, false);
    }
  }

  return 0;
}
