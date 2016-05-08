#include <cstdio>
using namespace std;

static int N, M;
static int map[128];

int main(){
  while(true){
    scanf("%d", &N);
    if(N == 0){
      return 0;
    }
    for(int i = 0; i < N; i++){
      char a, b;
      scanf(" %c %c\n", &a, &b);
      map[a] = b;
    }
    scanf("%d", &M);
    for(int i = 0; i < M; i++){
      char ch;
      scanf(" %c\n", &ch);
      if(map[ch] == 0){
        putchar(ch);
      }
      else{
        putchar(map[ch]);
      }
    }
    putchar('\n');
    for(int i = 0; i < 128; i++){
      map[i] = 0;
    }
  }

  return 0;
}
