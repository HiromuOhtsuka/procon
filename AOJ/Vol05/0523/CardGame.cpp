#include <cstdio>
#define MAX_N 100
using namespace std;

static int N;
static int number[MAX_N * 2 + 1];
static const int TARO = -1, MID = 0, HANAKO = 1;
static void init(){
  for(int i = 1; i <= 2 * N; i++){
    number[i] = HANAKO;
  }
}

int main(){
  while(true){
    scanf("%d", &N);
    if(N == 0){
      return 0;
    }
    init();
    for(int i = 0; i < N; i++){
      int n;
      scanf("%d", &n);
      number[n] = TARO;
    }
    int taron = N, hanakon = N, n = 0;
    while(taron != 0 && hanakon != 0){
      bool pass = true;
      for(int i = 1; i <= 2 * N; i++){
        if(n < i && number[i] == TARO){
          taron--;
          number[i] = MID;
          n = i;
          pass = false;
          break;
        }
      }
      if(pass){
        n = 0;
      }
      if(taron == 0){
        break;
      }
      pass = true;
      for(int i = 1; i <= 2 * N; i++){
        if(n < i && number[i] == HANAKO){
          hanakon--;
          number[i] = MID;
          n = i;
          pass = false;
          break;
        }
      }
      if(pass){
        n = 0;
      }
    }

    printf("%d\n%d\n", hanakon, taron);
  }

  return 0;
}
