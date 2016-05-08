#include <cstdio>
using namespace std;

static int N, M;

int main(){
  while(true){
    scanf("%d %d", &N, &M);
    if(N == 0){
      return 0;
    }
    bool turn = true;
    int I = 0, O = 0, count = 0, ch;
    getchar();
    while((ch = getchar()) != '\n'){
      if(turn && ch != 'I'){
        I = O = 0;
        turn = true;
        continue;
      }
      if(!turn && ch != 'O'){
        O = 0;
        I = 1;
        continue;
      }

      if(turn && ch == 'I'){
        ++I;
      }
      else if(!turn && ch == 'O'){
        ++O;
      }
      turn = !turn;

      if(I == N + 1 && O == N){
        ++count;
        --I; --O;
      }
    }

    printf("%d\n", count);
  }

  return 0;
}
