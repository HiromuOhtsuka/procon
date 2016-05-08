#include <cstdio>
using namespace std;

static int table[8][8];
static void search(int sx, int sy){
  static const int dx[] = 
  {-3, -2, -1, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3};
  static const int dy[] = 
  {0, 0, 0, 0, -1, -2, -3, 1, 2, 3, 0, 0, 0};

  
  table[sy][sx] = 0;

  for(int i = 0; i < 13; i++){
    int x = sx + dx[i], y = sy + dy[i];
    if(0 <= x && x < 8 && 0 <= y && y < 8
        && table[y][x] == 1){
      search(x, y);
    }
  }
}

int main(){
  int n;
  scanf("%d", &n);

  for(int i = 0; i < n; i++){
    getchar();  getchar();
    for(int j = 0; j < 8; j++){
      for(int k = 0; k < 9; k++){
        int ch = getchar();
        if(ch != '\n'){
          table[j][k] = ch - '0';
        }
      }
    }
    int sx, sy;
    scanf("%d %d", &sx, &sy);

    search(sx - 1, sy - 1);

    printf("Data %d:\n", i + 1);
    for(int j = 0; j < 8; j++){
      for(int k = 0; k < 8; k++){
        printf("%d", table[j][k]);
      }
      putchar('\n');
    }

  }

  return 0;
}
