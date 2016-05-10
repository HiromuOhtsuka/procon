#include <cstdio>
#include <map>
#define MAX_WH 100
using namespace std;

static int W, H;
static char tiles[MAX_WH][MAX_WH + 1];

static bool table[MAX_WH][MAX_WH], is_loop;
static pair< int, int > goal;
static void search(int sx, int sy){
  if(table[sy][sx]){
    is_loop = true;
    return;
  }
  if(tiles[sy][sx] == '.'){
    goal = pair< int, int > (sx, sy);
    return;
  }
  table[sy][sx] = true;
  switch(tiles[sy][sx]){
    case '>' : search(sx + 1, sy); break;
    case '<' : search(sx - 1, sy); break;
    case 'v' : search(sx, sy + 1); break;
    case '^' : search(sx, sy - 1); break;
  }
}

int main(){
  while(true){
    scanf("%d %d", &H, &W);

    if(W == 0 && H == 0){
      return 0;
    }

    getchar();
    for(int i = 0; i < H; i++){
      for(int j = 0; j <= W; j++){
        scanf("%c", &tiles[i][j]);
        table[i][j] = false;
      }
    }

    is_loop = false;
    search(0, 0);
    if(is_loop){
      printf("LOOP\n");
    }
    else{
      printf("%d %d\n", goal.first, goal.second);
    }
  }

  return 0;
}
