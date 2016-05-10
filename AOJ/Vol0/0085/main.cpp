#include <cstdio>
#define MAX_N 1000
#define MAX_M 1000
using namespace std;

static int N, M;
static bool table[MAX_N];
static void init_table(){
  for(int i = 0; i < N; i++){
    table[i] = false;
  }
}

int main(){
  while(true){
    scanf("%d %d", &N, &M);

    if(N == 0 && M == 0){
      return 0;
    }

    int tmp = 0;
    while(true){
      int count = 0, i = tmp;
      while(true){
        if(!table[i]){
          ++count;
        }
        if(count == M){
          tmp = i;
          break;
        }
        i = (i + 1) % N;
      }
      table[tmp] = true;
      bool end = true;
      for(int j = 0; j < N; j++){
        if(!table[j]){
          end = false;
          break;
        }
      }
      if(end){
        printf("%d\n", tmp + 1);
        break;
      }
    }
    init_table();
  }

  return 0;
}
