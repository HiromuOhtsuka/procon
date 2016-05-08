#include <cstdio>
#define MAX_N 100000
using namespace std;

static int N;
static bool table[MAX_N / 2];

int main(){
  while(true){
    scanf("%d", &N);

    if(N == 0){
      return 0;
    }

    for(int i = 1; i <= N; i++){
      if(i % 2){
        int c;
        scanf("%d", &c);
        table[i / 2] = c;
      }
      else{
        int c;
        scanf("%d", &c);
        for(int j = i / 2 - 1; j >= 0; j--){
          if(c != table[j]){
            table[j] = c;
          }
          else{
            break;
          }
        }
      }
    }

    int count = 0;
    for(int i = 0; 2 * i < N; i++){
      if(!table[i]){
        count += 2;
      }
    }

    printf("%d\n", count);
  }

  return 0;
}

