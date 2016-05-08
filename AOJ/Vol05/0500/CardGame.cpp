#include <cstdio>
using namespace std;

static int N;
static int score1, score2;

int main(){
  while(true){
    scanf("%d", &N);
    if(N == 0){
      return 0;
    }
    score1 = score2 = 0;
    for(int i = 0; i < N; i++){
      int a, b;
      scanf("%d %d", &a, &b);
      if(a < b){
        score2 += (a + b);
      }
      else if(a > b){
        score1 += (a + b);
      }
      else{
        score1 += a;  score2 += b;
      }
    }
    printf("%d %d\n", score1, score2);
  }

  return 0;
}
