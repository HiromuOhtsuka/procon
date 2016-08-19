#include <cstdio>
using namespace std;

static int N;

int main(){
  scanf("%d", &N);

  if(N <= 59){
    printf("Bad\n");
  }
  else if(N <= 89){
    printf("Good\n");
  }
  else if(N <= 99){
    printf("Great\n");
  }
  else{
    printf("Perfect\n");
  }

  return 0;
}
