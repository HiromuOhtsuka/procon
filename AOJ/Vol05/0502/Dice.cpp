#include <cstdio>
#include <cstring>
using namespace std;

static int N;
static const int UP = 0, SOUTH = 1, EAST = 2;
static int Dice[3];

int main(){
  while(true){
    scanf("%d", &N);
    if(N == 0){
      return 0;
    }
    int sum = 1;
    Dice[UP] = 1; Dice[SOUTH] = 2;  Dice[EAST] = 3;
    for(int i = 0; i < N; i++){
      char str[8];
      scanf("%s", str);
      if(!strcmp(str, "North")){
        int tmp = Dice[UP];
        Dice[UP] = Dice[SOUTH];
        Dice[SOUTH] = 7 - tmp;
      }
      else if(!strcmp(str, "East")){
        int tmp = Dice[EAST];
        Dice[EAST] = Dice[UP];
        Dice[UP] = 7 - tmp;
      }
      else if(!strcmp(str, "West")){
        int tmp = Dice[UP];
        Dice[UP] = Dice[EAST];
        Dice[EAST] = 7 - tmp;
      }
      else if(!strcmp(str, "South")){
        int tmp = Dice[SOUTH];
        Dice[SOUTH] = Dice[UP];
        Dice[UP] = 7 - tmp;
      }
      else if(!strcmp(str, "Right")){
        int tmp = Dice[SOUTH];
        Dice[SOUTH] = Dice[EAST];
        Dice[EAST] = 7 - tmp;
      }
      else if(!strcmp(str, "Left")){
        int tmp = Dice[EAST];
        Dice[EAST] = Dice[SOUTH];
        Dice[SOUTH] = 7 - tmp;
      }
      sum += Dice[UP];
    }
    printf("%d\n", sum);
  }

  return 0;
}
