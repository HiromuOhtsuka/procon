#include <cstdio>
#define MAX_SIZE 8
#define OUT (-1)
#define DOT (1)
using namespace std;

static int table[MAX_SIZE][MAX_SIZE];

static void init_table(){
  for(int i = 0; i < MAX_SIZE; i++){
    for(int j = 0; j < MAX_SIZE; j++){
      table[i][j] = 0;
    }
  }
}
static int get_val(int x, int y){
  if(!(0 <= x && x < MAX_SIZE && 0 <= y && y < MAX_SIZE)){
    return OUT;
  }
  return table[y][x];
}

static bool is_A(int sx, int sy){
  return get_val(sx, sy) == DOT && get_val(sx + 1, sy) == DOT 
         && get_val(sx, sy + 1) == DOT && get_val(sx + 1, sy + 1);
}

static bool is_B(int sx, int sy){
  return get_val(sx, sy) == DOT && get_val(sx, sy + 1) == DOT 
         && get_val(sx, sy + 2) == DOT && get_val(sx, sy + 3) == DOT;
}

static bool is_C(int sx, int sy){
  return get_val(sx, sy) == DOT && get_val(sx + 1, sy) == DOT
         && get_val(sx + 2, sy) == DOT && get_val(sx + 3, sy) == DOT;
}

static bool is_D(int sx, int sy){
  return get_val(sx, sy) == DOT && get_val(sx, sy + 1) == DOT 
         && get_val(sx - 1, sy + 1) == DOT && get_val(sx - 1, sy + 2) == DOT;
}

static int is_E(int sx, int sy){
  return get_val(sx, sy) == DOT && get_val(sx + 1, sy) == DOT
         && get_val(sx + 1, sy + 1) == DOT && get_val(sx + 2, sy + 1) == DOT;
}

static int is_F(int sx, int sy){
  return get_val(sx, sy) == DOT && get_val(sx, sy + 1) == DOT
         && get_val(sx + 1, sy + 1) == DOT && get_val(sx + 1, sy + 2);
}

static int is_G(int sx, int sy){
  return get_val(sx, sy) == DOT && get_val(sx + 1, sy) == DOT
         && get_val(sx, sy + 1) == DOT && get_val(sx - 1, sy + 1) == DOT;
}

int main(){
  while(true){
    for(int i = 0; i < MAX_SIZE; i++){
      for(int j = 0; j <= MAX_SIZE; j++){
        int ch = getchar();
        if(ch == EOF){
          return 0;
        }
        else if(ch == '\n'){
          continue;
        }
        table[i][j] = (int)ch - '0';
      }
    }
    for(int i = 0; i < MAX_SIZE; i++){
      for(int j = 0; j < MAX_SIZE; j++){
        if(table[i][j] == DOT){
          if(is_A(j, i)){
            printf("A\n");
          }
          else if(is_B(j, i)){
            printf("B\n");
          }
          else if(is_C(j, i)){
            printf("C\n");
          }
          else if(is_D(j, i)){
            printf("D\n");
          }
          else if(is_E(j, i)){
            printf("E\n");
          }
          else if(is_F(j, i)){
            printf("F\n");
          }
          else if(is_G(j, i)){
            printf("G\n");
          }
          break;
        }
      }
    }
    init_table();
    getchar();
  }

  return 0;
}
